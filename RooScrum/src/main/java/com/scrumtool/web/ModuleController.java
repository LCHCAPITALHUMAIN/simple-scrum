package com.scrumtool.web;

import com.scrumtool.domain.Module;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "modules", formBackingObject = Module.class)
@RequestMapping("/modules")
@Controller
public class ModuleController {
}
