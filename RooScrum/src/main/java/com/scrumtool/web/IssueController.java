package com.scrumtool.web;

import com.scrumtool.domain.Issue;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "issues", formBackingObject = Issue.class)
@RequestMapping("/issues")
@Controller
public class IssueController {
}
