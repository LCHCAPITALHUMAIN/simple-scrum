package com.scrumtool.web;

import com.scrumtool.domain.Budget;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "budgets", formBackingObject = Budget.class)
@RequestMapping("/budgets")
@Controller
public class BudgetController {
}
