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

@Entity
@Table(name = "FILE_STORAGE")
public class TheFile {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int fileID;
	@Column(name = "FS_FILE_NAME", columnDefinition = "text")
	private String fileName;
	@Column(name = "FS_DATE_UPLOADED")
	private Date uploadTime;
	@Column(name = "FS_THE_FILE")
	private Blob theFile;

	public TheFile() {
		this.fileName = "";
		this.theFile = null;
		this.uploadTime = null;
	}

	public TheFile(String fileName, Blob theFile) {
		this.fileName = fileName;
		this.theFile = theFile;
		this.uploadTime = new Date();
	}

	public int getFileID() {
		return fileID;
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getFileContent() throws SQLException {
		return theFile.getBinaryStream();
	}

}
