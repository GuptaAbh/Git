package com.npu.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.npu.dao.FeedDAO;
import com.npu.pojo.Feeds;
import com.npu.pojo.RegisteredUser;

@Controller
public class FeedController {
	
	
	
	@RequestMapping(value="/successfeed", method=RequestMethod.POST)
	public String save(Model model,@ModelAttribute("feed") Feeds feed,HttpServletRequest request){
		feed.setFeedDate(new Date());
		FeedDAO feedDAO = new FeedDAO();
		HttpSession session = request.getSession();
		RegisteredUser user  = (RegisteredUser)session.getAttribute("user");
		feed.setUser(user);
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
