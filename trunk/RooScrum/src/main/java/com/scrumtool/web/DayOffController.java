package com.scrumtool.web;

import com.scrumtool.domain.DayOff;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "dayoffs", formBackingObject = DayOff.class)
@RequestMapping("/dayoffs")
@Controller
public class DayOffController {
}
