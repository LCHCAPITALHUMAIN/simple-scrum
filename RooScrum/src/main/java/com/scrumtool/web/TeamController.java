package com.scrumtool.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scrumtool.domain.Sprint;
import com.scrumtool.domain.Team;

@RooWebScaffold(path = "teams", formBackingObject = Team.class)
@RequestMapping("/teams")
@Controller
public class TeamController {
    @RequestMapping(params = {"form","sprint"}, method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "sprint", required = false) Long sprintId,Model uiModel) {
    	Team team=new Team();
        team.setSprint(Sprint.findSprint(sprintId));
    	uiModel.addAttribute("team", team);
        return "teams/create";
    }
}
