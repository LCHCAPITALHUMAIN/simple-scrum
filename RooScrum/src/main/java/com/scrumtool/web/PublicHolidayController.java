package com.scrumtool.web;

import com.scrumtool.domain.PublicHoliday;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "publicholidays", formBackingObject = PublicHoliday.class)
@RequestMapping("/publicholidays")
@Controller
public class PublicHolidayController {
}
