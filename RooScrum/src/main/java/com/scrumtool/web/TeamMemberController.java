package com.scrumtool.web;

import com.scrumtool.domain.TeamMember;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "teammembers", formBackingObject = TeamMember.class)
@RequestMapping("/teammembers")
@Controller
public class TeamMemberController {
}
