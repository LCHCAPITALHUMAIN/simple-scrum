package com.scrumtool.web;

import com.scrumtool.domain.Issue;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "jiras", formBackingObject = Issue.class)
@RequestMapping("/jiras")
@Controller
public class JiraController {
}
