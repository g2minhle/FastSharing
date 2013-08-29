package com.fastsharing.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastsharing.FileDB;
import com.fastsharing.config.FilePath;
import com.fastsharing.config.RequestMap;
import com.fastsharing.structure.TheFile;

/**
 * Handles requests for the download page.
 */
@Controller
public class DownloadPages {

	/**
	 * Handles requests for the download page
	 * 
	 * @param model
	 *            The model
	 * @return The path to the page
	 */
	@RequestMapping(value = RequestMap.DOWNLOAD_MAP, method = RequestMethod.GET)
	public String DOWNLOAD_MAP(Model model) {
		model.addAttribute("fileName", FilePath.DOWNLOAD_PATH);
		return FilePath.DOWNLOAD_PATH;
	}

	/**
	 * Handles requests for checking existent of a file
	 * 
	 * @param fileIndex
	 *            The file ID
	 * @param request
	 *            Http request
	 * @param response
	 *            Http response
	 */
	@RequestMapping(value = RequestMap.DOWNLOAD_MAP, method = RequestMethod.POST)
	public @ResponseBody
	void DOWNLOAD_MAP_POST(@RequestParam("fileIndex") String fileIndex,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String resultString;
			if (FileDB.hasID(fileIndex)) {
				String fileName = FileDB.getFileName(fileIndex);
				resultString = fileName + "~" + fileIndex;
			} else {
				resultString = "NO_FILE";
			}
			response.getOutputStream().write(resultString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	/**	 */
	ServletContext ServletContext;

	/**
	 * Handles requests for downloading the file
	 * 
	 * @param fileIndex
	 *            The file ID
	 * @param request
	 *            Http request
	 * @param response
	 *            Http response
	 */
	@RequestMapping(value = RequestMap.DOWNLOAD_FILE_MAP, method = RequestMethod.GET)
	public @ResponseBody
	void DOWNLOAD_FILE_MAP(@PathVariable("fileIndex") String fileIndex,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (FileDB.hasID(fileIndex)) {
				TheFile theFile = FileDB.getFile(fileIndex);
				String fileName = theFile.getFileName();
				InputStream fileContent = theFile.getFileContent();
				OutputStream out = response.getOutputStream();
				response.setHeader("Content-Disposition",
						String.format("attachment; filename=%s", fileName));
				IOUtils.copy(fileContent, out);
				out.flush();
			} else {
				String resultString;
				resultString = "NO_FILE";
				response.getOutputStream().write(resultString.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
