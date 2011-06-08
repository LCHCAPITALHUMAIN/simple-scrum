package com.scrumtool.web;

import com.scrumtool.domain.Remaining;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "remainings", formBackingObject = Remaining.class)
@RequestMapping("/remainings")
@Controller
public class RemainingController {
}
