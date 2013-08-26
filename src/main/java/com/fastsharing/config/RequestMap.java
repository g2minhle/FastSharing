package com.fastsharing.config;

import org.springframework.stereotype.Controller;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RequestMap {
	public static final String UPLOAD_MAP = "/upload/";
	public static final String UPLOAD_RESULT_MAP = "/upload/{fileIndex}/";
	public static final String DOWNLOAD_MAP = "/download/";
	public static final String DOWNLOAD_FILE_MAP = "/download/{fileIndex}/";	
	public static final String HOW_TO_USE_MAP = "/howto/";
	public static final String ABOUT_US_MAP = "/about/";
}
