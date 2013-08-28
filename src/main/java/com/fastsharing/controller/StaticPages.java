package com.fastsharing.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastsharing.config.FilePath;
import com.fastsharing.config.RequestMap;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StaticPages {

	@RequestMapping(value = RequestMap.ABOUT_US_MAP, method = RequestMethod.GET)
	public String ABOUT_US_MAP(Locale locale, Model model) {
		model.addAttribute("fileName", FilePath.ABOUT_US_PATH);
		return FilePath.ABOUT_US_PATH;
	}

	@RequestMapping(value = RequestMap.HOW_TO_USE_MAP, method = RequestMethod.GET)
	public String HOW_TO_USE_MAP(Locale locale, Model model) {
		model.addAttribute("fileName", FilePath.HOW_TO_USE_PATH);
		return FilePath.HOW_TO_USE_PATH;
	}

}
