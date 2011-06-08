package com.scrumtool.web;

import com.scrumtool.domain.ProductBacklog;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "productbacklogs", formBackingObject = ProductBacklog.class)
@RequestMapping("/productbacklogs")
@Controller
public class ProductBacklogController {
}
