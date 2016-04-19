package com.npu.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.npu.dao.FeedDAO;
import com.npu.pojo.Feeds;

@Controller
public class FeedController {
	
	
	
	@RequestMapping(value="/successfeed", method=RequestMethod.POST)
	public String save(Model model,@ModelAttribute("feed") Feeds feed){
		feed.setFeedDate(new Date());
		FeedDAO feedDAO = new FeedDAO();
		feedDAO.saveFeed(feed);
		return "successfeed";
	}
	
	
	@RequestMapping(value="/viewfeed", method=RequestMethod.GET)
	public String viewFeed(Model model){
		FeedDAO feedDAO = new FeedDAO();
		ArrayList<Feeds> feedList = feedDAO.getallFeed();
		model.addAttribute("feedList", feedList);
		return "viewfeed";
	}
	

}
