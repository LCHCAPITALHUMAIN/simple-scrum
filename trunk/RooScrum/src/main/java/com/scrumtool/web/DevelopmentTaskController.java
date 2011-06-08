package com.scrumtool.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scrumtool.domain.DevelopmentTask;
import com.scrumtool.domain.Sprint;

@RooWebScaffold(path = "developmenttasks", formBackingObject = DevelopmentTask.class)
@RequestMapping("/developmenttasks")
@Controller
public class DevelopmentTaskController {
	@RequestMapping(params = { "form", "sprint" }, method = RequestMethod.GET)
	public String createForm(
			@RequestParam(value = "sprint", required = false) Long sprintId,
			Model uiModel) {
		DevelopmentTask developmentTask = new DevelopmentTask();
		developmentTask.setSprint(Sprint.findSprint(sprintId));
		uiModel.addAttribute("developmentTask", developmentTask);
		return "developmenttasks/create";
	}
}
