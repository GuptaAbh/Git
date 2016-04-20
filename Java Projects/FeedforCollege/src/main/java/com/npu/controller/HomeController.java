package com.npu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.npu.dao.FeedDAO;
import com.npu.pojo.Feeds;
import com.npu.pojo.FileUpload;
import com.npu.pojo.RegisteredUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		FeedDAO feed = new FeedDAO();
		feed.getallFeed();
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value="/footer", method=RequestMethod.GET)
	public String footer(Model model){
		
		return "footer";
	}
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model){
		model.addAttribute("registereduser", new RegisteredUser());
		return "signup";
	}
	
	@RequestMapping(value="/viewupdateprofile", method=RequestMethod.GET)
	public String viewupdateprofile(Model model){
		return "viewupdateprofile";
	}
	
	
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(Model model,HttpServletResponse response) throws IOException{
		
		return "signin";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		HttpSession session = request.getSession();
		session.setAttribute("user",null);
		return "home";
	}
	
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model){
		return "home";
	}
	
	@RequestMapping(value="/uploadprofilepic", method=RequestMethod.GET)
	public String uploadprofilepic(Locale locale,Model model){
		FileUpload fu = new FileUpload();
		System.out.println(" Home "+fu.getFileabc());
		model.addAttribute("fileObj", fu);
		return "uploadprofilepic";
	}
	
	
	@RequestMapping(value="/userhome", method=RequestMethod.GET)
	public String userhome(Model model){
		return "userhome";
	}
	
	@RequestMapping(value="/sharefeed", method=RequestMethod.GET)
	public String sharefeed(Model model){
		model.addAttribute("feed", new Feeds());
		return "sharefeed";
	}
	
	
}
