package com.npu.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.multipart.MultipartFile;

import com.npu.pojo.FileUpload;
import com.npu.pojo.RegisteredUser;

public class UserDAO extends ConnecionDAO{


	public boolean uploadImage(RegisteredUser user, FileUpload fileObj,String name) {
		try{
			System.out.println("Inside DAO");
			MultipartFile file = fileObj.getFileabc();
			String fpath = "";
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					//System.out.println("file org name is "+file.getOriginalFilename()+" file ext is "+FilenameUtils.getExtension(file.getOriginalFilename()));
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					System.out.println("root path is : "+rootPath);
					File dir = new File(rootPath + File.separator + "images");

					// File dir = new File(path + File.separator + "images");
					if (!dir.exists()) {
						dir.mkdirs();
					}

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					fpath = dir.getAbsolutePath()+ File.separator + name;
					System.out.println("full path of file is "+dir.getAbsolutePath()
					+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					System.out.println("file saved");
					try{
						Transaction transaction = getSession().beginTransaction();

						fileObj.setFileName(name);
						fileObj.setFilePath(fpath);
						getSession().saveOrUpdate(fileObj);
						user.setFile(fileObj);
						//user.setProfilepicName(name);
						getSession().merge(user);

						getSession().save(fileObj);
						transaction.commit();
						close();
					}
					catch(HibernateException e){
						close();
						e.printStackTrace();
						return false;
					}

					return true;


				} catch (Exception e) {
					System.out.println("file cant be saved ");e.printStackTrace();
					return false;
				}
			} else {
				System.out.println("file cant be saved ");
				return false;
			}}catch(Exception e){
				System.out.println("File "+e.getMessage());
				return false;
			}

	}




	public RegisteredUser SaveUSer(RegisteredUser user){
		Transaction transaction = getSession().beginTransaction();

		Session s = getSession();
		Long userid = (Long)s.save(user);
		System.out.println(userid);
		transaction.commit();
		RegisteredUser regUser = searchUser(userid);
		return regUser;
	}

	public RegisteredUser searchUser(Long userid){
		Transaction transaction = getSession().beginTransaction();
		Session s = getSession();
		Query query= s.createQuery("from RegisteredUser where userId= :id");
		query.setLong("id", userid);
		RegisteredUser ruser = (RegisteredUser)query.uniqueResult();
		return ruser;
	}

	public RegisteredUser login(String username,String password){
		Session s = getSession();
		System.out.println(username);
		Query query= s.createQuery("from RegisteredUser where userName= :username "
				+ "and password= :password");
		query.setString("username", username);
		query.setString("password", password);
		RegisteredUser user = (RegisteredUser)query.uniqueResult();
		System.out.println("username "+user.getUserName());
		return user;
	}

	public Boolean chkemail(String email){
		Session s = getSession();
		System.out.println(email);
		Query query= s.createQuery("from RegisteredUser where email= :email");
		query.setString("email", email);
		List result = query.list();
	
		if(result.size()>0){
			return true;	
		}else{
			return false;
		}
		

	}

	public Boolean chkusername(String username){
		try{Session s = getSession();
		System.out.println(username);
		Query query= s.createQuery("from RegisteredUser where userName= :username");
		query.setString("username", username);
		List result = query.list();
		System.out.println("Size"+result.size());
	
		if(result.size()>0){
			return true;	
		}else{
			return false;
		}}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}


}
