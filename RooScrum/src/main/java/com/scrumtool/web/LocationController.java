package com.scrumtool.web;

import com.scrumtool.domain.Location;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "locations", formBackingObject = Location.class)
@RequestMapping("/locations")
@Controller
public class LocationController {
}
