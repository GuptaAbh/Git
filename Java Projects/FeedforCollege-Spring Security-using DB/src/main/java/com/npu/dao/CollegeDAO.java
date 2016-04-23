package com.npu.dao;



import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.npu.pojo.college;

public class CollegeDAO extends ConnecionDAO{

	// Add Colleges to the database
	public void addCollege(college col){
		Transaction transaction = getSession().beginTransaction();
		Session session = getSession();
		session.save(col);
		transaction.commit();
	}
	
	public ArrayList<college> getCollegeList(){
		
		
		Transaction transaction = getSession().beginTransaction();
		Session session = getSession();
		Query query = session.createQuery("from college");
		ArrayList<college> collegeList = (ArrayList<college>)query.list();
		return collegeList;		
	}
	
	
}
