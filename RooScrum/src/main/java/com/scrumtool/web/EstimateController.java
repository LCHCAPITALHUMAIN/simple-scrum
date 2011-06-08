package com.scrumtool.web;

import com.scrumtool.domain.Estimate;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "estimates", formBackingObject = Estimate.class)
@RequestMapping("/estimates")
@Controller
public class EstimateController {
}
