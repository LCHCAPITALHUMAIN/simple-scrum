package com.scrumtool.web;

import com.scrumtool.domain.Actual;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "actuals", formBackingObject = Actual.class)
@RequestMapping("/actuals")
@Controller
public class ActualController {
}
