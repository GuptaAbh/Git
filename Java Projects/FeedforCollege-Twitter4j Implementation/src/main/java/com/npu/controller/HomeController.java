package com.npu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.npu.dao.CollegeDAO;
import com.npu.dao.FeedDAO;
import com.npu.pojo.Feeds;
import com.npu.pojo.FileUpload;
import com.npu.pojo.RegisteredUser;
import com.npu.pojo.college;

import antlr.collections.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/index", method = RequestMethod.GET) public
	 * ModelAndView welcome() { //return new ModelAndView("redirect:/h.html");
	 * 
	 * return new ModelAndView("addEmployee"); }
	 * 
	 * @RequestMapping(value = "/h", method = RequestMethod.GET) public
	 * ModelAndView welcome1() { return new ModelAndView("addEmployee"); }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale) {

		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("hi sis");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		FeedDAO feed = new FeedDAO();
		feed.getallFeed();
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/footer", method = RequestMethod.GET)
	public String footer(Model model) {
		return "footer";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("registereduser", new RegisteredUser());
		return "signup";
	}

	@RequestMapping(value = "/viewupdateprofile", method = RequestMethod.GET)
	public String viewupdateprofile(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		RegisteredUser user = (RegisteredUser) session.getAttribute("user");
		model.addAttribute("registereduser", user);
		if (user.getFile() != null) {
			model.addAttribute("fileObj", user.getFile());
		} else {
			model.addAttribute("fileObj", new FileUpload());
		}
		return "viewupdateprofile";
	}

	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String adminhome(Model model) {
		return "adminhome";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(Model model, HttpServletResponse response) throws IOException {
		return "signin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String hometest(Model model) {
		System.out.println("hi sis");
		return "home";
	}

	@RequestMapping(value = "/uploadprofilepic", method = RequestMethod.GET)
	public String uploadprofilepic(Locale locale, Model model) {
		FileUpload fu = new FileUpload();
		System.out.println(" Home " + fu.getFileabc());
		model.addAttribute("fileObj", fu);
		return "uploadprofilepic";
	}

	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public String userhome(Model model) {
		return "userhome";
	}

	@RequestMapping(value = "/sharefeed", method = RequestMethod.GET)
	public String sharefeed(Model model) {
		model.addAttribute("feed", new Feeds());
		return "sharefeed";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error(Model model) {
		return "403";
	}

	@RequestMapping(value = "/logoutadmin", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "home";// You can redirect wherever you want, but generally it's
						// a good practice to show login screen again.
	}

	@RequestMapping(value = "/loadtweets", method = RequestMethod.GET)
	public void loadtweets(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Twitter twitter = new TwitterFactory().getInstance();
		AccessToken a = new AccessToken("140854111-xY5oJvE02BX4QDnArFLRDqGgL83vsELAOaYDsrM7",
				"DuHm822NBe3dJ8cfw9kzqcxX9l2OauXCj48r9MVHaA4zG");
		twitter.setOAuthConsumer("hqfuS38GQVrYeBjihrKogbEDQ", "WUltUN0Wkzm4zALYaWtEtzt8zDOIDTObTCMlBHugrIEm2msX9W");
		twitter.setOAuthAccessToken(a);
		String searchTweets = request.getParameter("searchTweets");
		Query query = new Query(searchTweets);
		query.count(100);
		try {
			QueryResult result = twitter.search(query);
			PrintWriter out = response.getWriter();
			
			ArrayList<Status> statusList = new ArrayList<Status>();
			for (Status status : result.getTweets()) {
				statusList.add(status);
			}
			Gson gson = new GsonBuilder().create();
			JsonArray arraylist = gson.toJsonTree(statusList).getAsJsonArray();
			System.out.println(arraylist);
			out.println(arraylist);
		} catch (TwitterException e) {
			System.out.println("Error Message :" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
