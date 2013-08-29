package com.fastsharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastsharing.config.FilePath;
import com.fastsharing.config.RequestMap;

/**
 * Handles requests for static pages
 */
@Controller
public class StaticPages {

	/**
	 * Handles requests for how to use page
	 * 
	 * @param model
	 *            The model
	 * @return The path to the page
	 */
	@RequestMapping(value = RequestMap.HOW_TO_USE_MAP, method = RequestMethod.GET)
	public String HOW_TO_USE_MAP(Model model) {
		model.addAttribute("fileName", FilePath.HOW_TO_USE_PATH);
		return FilePath.HOW_TO_USE_PATH;
	}

	/**
	 * Handles requests for about us page
	 * 
	 * @param model
	 *            The model
	 * @return The path to the page
	 */
	@RequestMapping(value = RequestMap.ABOUT_US_MAP, method = RequestMethod.GET)
	public String ABOUT_US_MAP(Model model) {
		model.addAttribute("fileName", FilePath.ABOUT_US_PATH);
		return FilePath.ABOUT_US_PATH;
	}

}
