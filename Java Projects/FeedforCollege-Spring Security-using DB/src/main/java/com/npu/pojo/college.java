package com.npu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class college {


	@Id
	@GeneratedValue
	@Column(name="collegeid")
	private Long collegeId;

	@Column(name="collegename")
	private String collegeName;

	public college() {
		// TODO Auto-generated constructor stub
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
