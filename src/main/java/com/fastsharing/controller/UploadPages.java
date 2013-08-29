package com.fastsharing.controller;

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
 * Handles requests for upload page
 */
@Controller
public class UploadPages {

	/**
	 * Redirect the home page to the upload page
	 * 
	 * @return Redirect request to the upload page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String INDEX() {
		return "redirect:/upload/";
	}

	/**
	 * Handles requests for upload page
	 * 
	 * @param model
	 *            The model
	 * @return The path to the page
	 */
	@RequestMapping(value = RequestMap.UPLOAD_MAP, method = RequestMethod.GET)
	public String UPLOAD_MAP(Model model) {
		model.addAttribute("fileName", FilePath.UPLOAD_PATH);
		return FilePath.UPLOAD_PATH;
	}

	/**
	 * Save an uploaded file to database
	 * 
	 * @param uploadForm
	 *            The upload From
	 * @param model
	 *            The model
	 * @return The path to the page
	 */
	@RequestMapping(value = RequestMap.UPLOAD_MAP, method = RequestMethod.POST)
	public String UPLOAD_MAP_POST(
			@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model model) {
		int fileIndex = -1;
		String fileName = "";
		try {
			MultipartFile multipartFile = uploadForm.getTheFile();
			TheFile theFile = new TheFile(multipartFile);
			fileIndex = FileDB.saveFile(theFile);
			if (fileIndex == FileDB.ERROR_FILE_TOO_BIG) {
				return FilePath.TOO_BIG_FILE_PATH;
			} else if (fileIndex == FileDB.ERROR_OUT_OF_MEMORY) {
				return FilePath.OUT_OF_MEMORY_PATH;
			}
			fileName = theFile.getFileName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileIndex", fileIndex);
		model.addAttribute("fileName", fileName);
		return FilePath.UPLOAD_RESULT_PATH;
	}
}
