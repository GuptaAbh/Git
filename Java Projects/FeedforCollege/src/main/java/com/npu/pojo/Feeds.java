package com.npu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblfeed")
public class Feeds {
	@Id
	@GeneratedValue
	@Column(name="feedid")
	private Long feedId;

	@ManyToOne
	@JoinColumn(name="userId")
	private RegisteredUser user;
	
	@Column(name="feedlocation")
	private String feedLocation;

	@Column(name="feeddate")
	private Date feedDate;

	@Column(name="feedcollege")
	private String feedcollegeName;

	@Column(name="feeddescription")
	private String feeddescription;


	public Feeds() {
		// TODO Auto-generated constructor stub
	}
	public String getFeeddescription() {
		return feeddescription;
	}

	public void setFeeddescription(String feeddescription) {
		this.feeddescription = feeddescription;
	}

	public Long getFeedId() {
		return feedId;
	}

	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}

	public String getFeedLocation() {
		return feedLocation;
	}

	public void setFeedLocation(String feedLocation) {
		this.feedLocation = feedLocation;
	}

	public Date getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
	}

	public String getFeedcollegeName() {
		return feedcollegeName;
	}

	public void setFeedcollegeName(String feedcollegeName) {
		this.feedcollegeName = feedcollegeName;
	}
	public RegisteredUser getUser() {
		return user;
	}
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
}
