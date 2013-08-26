package com.fastsharing.structure;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

	private MultipartFile theFile;

	public MultipartFile getTheFile() {
		return theFile;
	}

	public void setTheFile(MultipartFile newFile) {
		this.theFile = newFile;
	}

	public FileUploadForm() {
		theFile = null;
	}
}