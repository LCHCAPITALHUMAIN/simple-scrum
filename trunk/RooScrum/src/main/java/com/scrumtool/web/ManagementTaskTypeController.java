package com.scrumtool.web;

import com.scrumtool.domain.ManagementTaskType;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "managementtasktypes", formBackingObject = ManagementTaskType.class)
@RequestMapping("/managementtasktypes")
@Controller
public class ManagementTaskTypeController {
}
