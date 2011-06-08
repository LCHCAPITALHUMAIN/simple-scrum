package com.scrumtool.web;

import com.scrumtool.domain.Release;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "releases", formBackingObject = Release.class)
@RequestMapping("/releases")
@Controller
public class ReleaseController {
}
