package com.scrumtool.web;

import com.scrumtool.domain.SprintDay;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "sprintdays", formBackingObject = SprintDay.class)
@RequestMapping("/sprintdays")
@Controller
public class SprintDayController {
}
