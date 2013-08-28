package com.fastsharing.controller;

import java.sql.Blob;
import java.util.Locale;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fastsharing.FileDB;
import com.fastsharing.config.FilePath;
import com.fastsharing.config.RequestMap;
import com.fastsharing.structure.FileUploadForm;
import com.fastsharing.structure.TheFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UploadPages {

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
	public String UPLOAD_MAP_POST(
			@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model model) {
		int fileIndex = -1;
		String fileName = "";
		try {
			Blob fileContent;
			MultipartFile multipartFile = uploadForm.getTheFile();
			fileContent = new SerialBlob(multipartFile.getBytes());
			fileName = multipartFile.getOriginalFilename();
			TheFile theFile = new TheFile(fileName, fileContent);
			fileIndex = FileDB.saveFile(theFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileIndex", fileIndex);
		model.addAttribute("fileName", fileName);
		return FilePath.UPLOAD_RESULT_PATH;
	}
}
