// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.web;

import com.scrumtool.domain.Sprint;
import com.scrumtool.domain.Team;
import com.scrumtool.domain.TeamMember;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect TeamController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String TeamController.create(@Valid Team team, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("team", team);
            return "teams/create";
        }
        uiModel.asMap().clear();
        team.persist();
        return "redirect:/teams/" + encodeUrlPathSegment(team.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String TeamController.createForm(Model uiModel) {
        uiModel.addAttribute("team", new Team());
        return "teams/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String TeamController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("team", Team.findTeam(id));
        uiModel.addAttribute("itemId", id);
        return "teams/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String TeamController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("teams", Team.findTeamEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Team.countTeams() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("teams", Team.findAllTeams());
        }
        return "teams/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String TeamController.update(@Valid Team team, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("team", team);
            return "teams/update";
        }
        uiModel.asMap().clear();
        team.merge();
        return "redirect:/teams/" + encodeUrlPathSegment(team.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String TeamController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("team", Team.findTeam(id));
        return "teams/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String TeamController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Team.findTeam(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/teams";
    }
    
    @ModelAttribute("sprints")
    public Collection<Sprint> TeamController.populateSprints() {
        return Sprint.findAllSprints();
    }
    
    @ModelAttribute("teams")
    public Collection<Team> TeamController.populateTeams() {
        return Team.findAllTeams();
    }
    
    @ModelAttribute("teammembers")
    public Collection<TeamMember> TeamController.populateTeamMembers() {
        return TeamMember.findAllTeamMembers();
    }
    
    String TeamController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
