package com.scrumtool.web;

import com.scrumtool.domain.ManagementTaskType;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "managementasktypes", formBackingObject = ManagementTaskType.class)
@RequestMapping("/managementasktypes")
@Controller
public class ManagemenTaskTypeController {
}
