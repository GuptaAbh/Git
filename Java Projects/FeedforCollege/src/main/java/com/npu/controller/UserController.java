package com.npu.controller;

import javax.persistence.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.npu.dao.UserDAO;
import com.npu.pojo.RegisteredUser;

@Controller
public class UserController {
	
	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public String signup(Model model,@ModelAttribute("registereduser") RegisteredUser user){
		UserDAO userDAO = new UserDAO();
		RegisteredUser registereduser = userDAO.SaveUSer(user);
		model.addAttribute("saveduser",registereduser.getUserName());
		System.out.println(user.getFirstName());
		
			return "userhome";
	
		
		
	}
	
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signin(Model model,HttpServletRequest request,HttpServletResponse response){
		UserDAO userDAO = new UserDAO();
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		RegisteredUser user = userDAO.login(username, password);
		if(user.getUserName().equals("SADMIN")){
			return "adminhome";
		}else{
			return "userhome";	
		}
		
		
	}
}
