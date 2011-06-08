package com.scrumtool.web;

import com.scrumtool.domain.User;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "users", formBackingObject = User.class)
@RequestMapping("/users")
@Controller
public class UserController {
}
