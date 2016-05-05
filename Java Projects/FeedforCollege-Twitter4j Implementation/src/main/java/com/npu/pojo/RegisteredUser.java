package com.npu.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="registereduser")
@Inheritance(strategy=InheritanceType.JOINED)

public class RegisteredUser {
	@Transient
	private String confirmPassword;
		
	@Column
	private String userrole;

	public String getUserrole() {
		return userrole;
	}

	@Column(name="enabled",nullable=false)
	public Boolean enabled;
	

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}


	@Column(name="collegename")
	private String collegename;
	
	@Column(name="profilepicName")
	private String profilepicName;
	
	
	
	public String getProfilepicName() {
		return profilepicName;
	}


	public void setProfilepicName(String profilepicName) {
		this.profilepicName = profilepicName;
	}


	@OneToOne
	@JoinColumn(name="file_fk")
	private FileUpload file;
	
	@OneToMany(mappedBy="user")
	private Set<Feeds> feedList; 
	
	public RegisteredUser(String fName,String lName,String userName,String email,int contactNum,
				String password,String secQ,String secA,String collegename){
		
		this.firstName = fName;
		this.lastName=lName;
		this.userName = userName;
		this.email = email;
		this.contactNum=contactNum;
		this.secQuestion=secQ;
		this.secAnswer=secA;
		this.password=password;
		this.collegename=collegename;
		
	}
	
	
	public FileUpload getFile() {
		return file;
	}

	public void setFile(FileUpload file) {
		this.file = file;
	}

	public Set<Feeds> getFeedList() {
		return feedList;
	}

	public void setFeedList(Set<Feeds> feedList) {
		this.feedList = feedList;
	}


	@Column(name="password")
	private String password;
	
	@Column(name="secquestion")
	private String secQuestion;
	
	@Column(name="secanswer")
	private String secAnswer;
	
	
	
	@Id
	@GeneratedValue
	@Column(name="userid")
	private long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contactnum")
	private int contactNum;
	
	public RegisteredUser() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAnswer() {
		return secAnswer;
	}

	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNum() {
		return contactNum;
	}

	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	
	
	
}
