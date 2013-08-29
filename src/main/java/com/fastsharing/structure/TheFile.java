package com.fastsharing.structure;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The file entity contains the file and meta information
 * 
 * @author g2minhle
 * 
 */
@Entity
@Table(name = "FILE_STORAGE")
public class TheFile {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	/**	The ID of the file in the database */
	private int fileID;

	/** The file name */
	@Column(name = "FS_FILE_NAME", columnDefinition = "text")
	private String fileName;

	/** The updated date of the file */
	@Column(name = "FS_DATE_UPLOADED")
	private Date uploadTime;

	/** The content of the file */
	@Column(name = "FS_THE_FILE")
	private Blob theFile;

	/**
	 * A default generator for Hibernate database
	 */
	public TheFile() {
		this.fileName = "";
		this.theFile = null;
		this.uploadTime = null;
	}

	/**
	 * Create a new file instance
	 * 
	 * @param fileName
	 *            The file name
	 * @param theFile
	 *            The file content
	 */
	public TheFile(String fileName, Blob theFile) {
		this.fileName = fileName;
		this.theFile = theFile;
		this.uploadTime = new Date();
	}

	/**
	 * Get the ID in database of the file
	 * 
	 * @return The ID in database of the file
	 */
	public int getFileID() {
		return fileID;
	}

	/**
	 * Get the name of the file
	 * 
	 * @return The name of the file
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Get input stream from file content
	 * 
	 * @return The input stream from file content
	 * @throws SQLException
	 */
	public InputStream getFileContent() throws SQLException {
		return theFile.getBinaryStream();
	}

}
