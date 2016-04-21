package com.npu.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "Files")
public class FileUpload implements Serializable{

	@Id @GeneratedValue
	@OneToOne(mappedBy="fileid")
	private long fileId;

	@Column(name="filepath", nullable=false,unique=true)
	private String filePath;

	@Column(name="fileName", nullable=false,unique=true)
	private String fileName;

	@Transient
	private MultipartFile fileabc;
	
	public MultipartFile getFileabc() {
		return fileabc;
	}
	public void setFileabc(MultipartFile fileabc) {
		this.fileabc = fileabc;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

public FileUpload() {
	// TODO Auto-generated constructor stub
}

}
