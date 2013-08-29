package com.fastsharing.structure;

import org.springframework.web.multipart.MultipartFile;

/**
 * The model for file upload from
 * 
 * @author g2minhle
 * 
 */
public class FileUploadForm {

	/** The file uploaded file */
	private MultipartFile theFile;

	/**
	 * Get the uploaded file
	 * 
	 * @return The uploaded file
	 */
	public MultipartFile getTheFile() {
		return theFile;
	}

	/**
	 * Set the uploaded file
	 * 
	 * @param newFile
	 *            The new upload file
	 */
	public void setTheFile(MultipartFile newFile) {
		this.theFile = newFile;
	}

	/**
	 * Initialize the new upload form
	 */
	public FileUploadForm() {
		theFile = null;
	}
}