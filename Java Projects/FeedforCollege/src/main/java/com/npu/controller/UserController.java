package com.npu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.npu.dao.UserDAO;
import com.npu.pojo.FileUpload;
import com.npu.pojo.RegisteredUser;

@Controller
public class UserController {

	@RequestMapping(value="/chkusername", method=RequestMethod.GET)
	public void chkusername(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException{
		String username = request.getParameter("username");
		if(username.equalsIgnoreCase("") || username==null){

			
		}else{

			UserDAO userDAO = new UserDAO();
			Boolean usernamefound = userDAO.chkusername(username);
			PrintWriter out = response.getWriter();
			if(usernamefound){
				JSONObject jObjd=new JSONObject();
				jObjd.put("avail", false);
				out.println(jObjd);
			}else{
				JSONObject jObjd=new JSONObject();
				jObjd.put("avail", true);
				out.println(jObjd);
			}

		}

	}


	@RequestMapping(value="/chkemail", method=RequestMethod.GET)
	public void chkemail(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException{
		String email = request.getParameter("email");
		if(email.equalsIgnoreCase("") || email==null){


		}else{
			UserDAO userDAO = new UserDAO();
			Boolean useremailfound = userDAO.chkemail(email);
			PrintWriter out = response.getWriter();
			if(useremailfound){
				JSONObject jObjd=new JSONObject();
				jObjd.put("avail", false);
				out.println(jObjd);
			}else{
				JSONObject jObjd=new JSONObject();
				jObjd.put("avail", true);
				out.println(jObjd);
			}
		}
	}

	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public String signup(Model model,@ModelAttribute("registereduser") RegisteredUser user,HttpServletRequest request){
		UserDAO userDAO = new UserDAO();
		RegisteredUser registereduser = userDAO.SaveUSer(user);
		HttpSession session = request.getSession();
		session.setAttribute("user",registereduser);
		model.addAttribute("saveduser",registereduser.getUserName());
		model.addAttribute("fileObj",new FileUpload());
		System.out.println(user.getFirstName());
		return "uploadprofilepic";	
	}


	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signin(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String returnpage="home";

		RegisteredUser user = (RegisteredUser)session.getAttribute("user");

		if(session.getAttribute("user")!=null){

		}else{
			UserDAO userDAO = new UserDAO();
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			user = userDAO.login(username, password);
			session.setAttribute("user", user);

		}

		if(user.getUserName().equals("SADMIN")){
			returnpage= "adminhome";
		}else{
			returnpage= "userhome";	
		}


		return returnpage;
	}
}
