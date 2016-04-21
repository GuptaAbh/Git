package com.npu.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.View;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.npu.pojo.Feeds;
import com.npu.pojo.PdfReportView;

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
		System.out.println("Cache hits:"+s.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		System.out.println("Cache hits Miss:"+s.getSessionFactory().getStatistics().getSecondLevelCacheMissCount());
		System.out.println("Cache hits put:"+s.getSessionFactory().getStatistics().getSecondLevelCachePutCount());
		Query query = s.createQuery("from Feeds");
		query.setCacheable(true);
		Transaction transaction = s.beginTransaction();
		ArrayList<Feeds> feedList = (ArrayList<Feeds>)query.list();
		System.out.println("Total Feed: "+feedList.size());
		//generatedpdf();
		return feedList;
	}
	
	
	
	
}
