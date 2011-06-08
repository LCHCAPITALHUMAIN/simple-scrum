package com.scrumtool.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scrumtool.domain.ManagementTask;
import com.scrumtool.domain.Sprint;

@RooWebScaffold(path = "managementtasks", formBackingObject = ManagementTask.class)
@RequestMapping("/managementtasks")
@Controller
public class ManagementTaskController {
   @RequestMapping(params = {"form","sprint"}, method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "sprint", required = false) Long sprintId,Model uiModel) {
    	ManagementTask managementTask=new ManagementTask();
        managementTask.setSprint(Sprint.findSprint(sprintId));
    	uiModel.addAttribute("managementTask", managementTask);
        return "managementtasks/create";
    }
}
