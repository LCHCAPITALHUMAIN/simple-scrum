package com.scrumtool.web;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.scrumtool.domain.Sprint;
import com.scrumtool.domain.SprintDay;

@RooWebScaffold(path = "sprints", formBackingObject = Sprint.class)
@RequestMapping("/sprints")
@Controller
public class SprintController {
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Sprint sprint, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		addDateTimeFormatPatterns(uiModel);
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("sprint", sprint);
			return "sprints/create";
		}
		uiModel.asMap().clear();
		sprint.persist();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(sprint.getFromDate().getTime());
		end.setTime(sprint.getToDate().getTime());
		int day = 1;
		if (start.before(end)) {
			while (start.get(Calendar.DAY_OF_YEAR) != end
					.get(Calendar.DAY_OF_YEAR)) {
				if (start.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
						&& start.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					SprintDay sprintDay = new SprintDay();
					sprintDay.setDate(start.getTime());
					sprintDay.setSprint(sprint);
					sprintDay.setDay(day);
					sprintDay.persist();
				}
				day++;
				start.set(Calendar.DAY_OF_YEAR,
						start.get(Calendar.DAY_OF_YEAR) + 1);
			}
		}
		return "redirect:/sprints/"
				+ encodeUrlPathSegment(sprint.getId().toString(),
						httpServletRequest);
	}

	void addDateTimeFormatPatterns(Model uiModel) {
		uiModel.addAttribute(
				"sprint_fromdate_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
		uiModel.addAttribute(
				"sprint_todate_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
		uiModel.addAttribute(
				"sprint_globalstanduptime_date_format",
				DateTimeFormat.patternForStyle("-S",
						LocaleContextHolder.getLocale()));
	}

	String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}
}
