package com.npu.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Filter;
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
		
		Filter filter = s.enableFilter("feedFilter");
		filter.setParameter("feedFilterID", 3);
		System.out.println("Cache hits:"+s.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		System.out.println("Cache hits Miss:"+s.getSessionFactory().getStatistics().getSecondLevelCacheMissCount());
		System.out.println("Cache hits put:"+s.getSessionFactory().getStatistics().getSecondLevelCachePutCount());
		Query query = s.createQuery("from Feeds");
		query.setCacheable(true);
		Transaction transaction = s.beginTransaction();
		ArrayList<Feeds> feedList = (ArrayList<Feeds>)query.list();
		System.out.println("Total Feed: "+feedList.size());
		return feedList;
	}
	
	
	
	
}
