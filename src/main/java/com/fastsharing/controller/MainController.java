package com.fastsharing.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Locale;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fastsharing.config.FilePath;
import com.fastsharing.config.RequestMap;
import com.fastsharing.structure.FileUploadForm;
import com.fastsharing.structure.TheFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String INDEX(Locale locale, Model model) {
		return "redirect:/upload/";
	}

	@RequestMapping(value = RequestMap.UPLOAD_MAP, method = RequestMethod.GET)
	public String UPLOAD_MAP(Locale locale, Model model) {
		model.addAttribute("fileName", FilePath.UPLOAD_PATH);
		return FilePath.UPLOAD_PATH;
	}

	@RequestMapping(value = RequestMap.UPLOAD_MAP, method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map) {
		MultipartFile theFile = uploadForm.getTheFile();
		Blob fileContent;
		try {
			fileContent = new SerialBlob(theFile.getBytes());
			TheFile fileStorage = new TheFile(theFile.getOriginalFilename(), fileContent);
			map.addAttribute("outPut", theFile.getOriginalFilename());
			return "test";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error"; 
	}

	/*
	 * @RequestMapping(value = RequestMap.UPLOAD_MAP, method =
	 * RequestMethod.POST) public String UPLOAD_MAP_POST(Locale locale, Model
	 * model) { //model.addAttribute("fileName", FilePath.UPLOAD_RESULT_PATH);
	 * //return FilePath.UPLOAD_PATH; }
	 */

	@RequestMapping(value = RequestMap.UPLOAD_RESULT_MAP, method = RequestMethod.GET)
	public String UPLOAD_RESULT_MAP(
			@PathVariable("fileIndex") Integer fileIndex, Model model) {
		model.addAttribute("fileName", FilePath.UPLOAD_RESULT_PATH);
		return FilePath.UPLOAD_RESULT_PATH;
	}

	@RequestMapping(value = RequestMap.DOWNLOAD_MAP, method = RequestMethod.GET)
	public String DOWNLOAD_MAP(Locale locale, Model model) {
		model.addAttribute("fileName", FilePath.DOWNLOAD_PATH);
		return FilePath.DOWNLOAD_PATH;
	}

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
