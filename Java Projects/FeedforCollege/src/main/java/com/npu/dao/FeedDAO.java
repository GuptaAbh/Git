package com.npu.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.npu.pojo.Feeds;

public class FeedDAO extends ConnecionDAO{
	
	public void saveFeed(Feeds feed){
		Transaction transaction = getSession().beginTransaction();
		Session s = getSession();
		s.save(feed);
		transaction.commit();
		
		System.out.println("Total Feeds"+getallFeed().size());
	}
	
	public ArrayList<Feeds> getallFeed(){
		Session s = getSession();
		Query query = s.createQuery("from Feeds");
		Transaction transaction = s.beginTransaction();
		ArrayList<Feeds> feedList = (ArrayList<Feeds>)query.list();
		System.out.println(feedList.size());
		return feedList;
	}
}
