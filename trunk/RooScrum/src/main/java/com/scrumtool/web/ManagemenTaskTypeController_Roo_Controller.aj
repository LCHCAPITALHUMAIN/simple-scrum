// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.web;

import com.scrumtool.domain.ManagementTaskType;
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

privileged aspect ManagemenTaskTypeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String ManagemenTaskTypeController.create(@Valid ManagementTaskType managementTaskType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("managementTaskType", managementTaskType);
            return "managementasktypes/create";
        }
        uiModel.asMap().clear();
        managementTaskType.persist();
        return "redirect:/managementasktypes/" + encodeUrlPathSegment(managementTaskType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String ManagemenTaskTypeController.createForm(Model uiModel) {
        uiModel.addAttribute("managementTaskType", new ManagementTaskType());
        return "managementasktypes/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String ManagemenTaskTypeController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("managementtasktype", ManagementTaskType.findManagementTaskType(id));
        uiModel.addAttribute("itemId", id);
        return "managementasktypes/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String ManagemenTaskTypeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("managementtasktypes", ManagementTaskType.findManagementTaskTypeEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) ManagementTaskType.countManagementTaskTypes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("managementtasktypes", ManagementTaskType.findAllManagementTaskTypes());
        }
        return "managementasktypes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String ManagemenTaskTypeController.update(@Valid ManagementTaskType managementTaskType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("managementTaskType", managementTaskType);
            return "managementasktypes/update";
        }
        uiModel.asMap().clear();
        managementTaskType.merge();
        return "redirect:/managementasktypes/" + encodeUrlPathSegment(managementTaskType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String ManagemenTaskTypeController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("managementTaskType", ManagementTaskType.findManagementTaskType(id));
        return "managementasktypes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String ManagemenTaskTypeController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ManagementTaskType.findManagementTaskType(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/managementasktypes";
    }
    
    @ModelAttribute("managementtasktypes")
    public Collection<ManagementTaskType> ManagemenTaskTypeController.populateManagementTaskTypes() {
        return ManagementTaskType.findAllManagementTaskTypes();
    }
    
    String ManagemenTaskTypeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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