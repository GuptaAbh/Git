package com.npu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.npu.dao.CollegeDAO;
import com.npu.pojo.college;

@Controller
public class CollegeController {


	@RequestMapping(value="/returncollege", method=RequestMethod.GET)
	public void getCollegeList(HttpServletResponse response) throws IOException, JSONException{
		System.out.println("Call returncollege");
		CollegeDAO collegeDAO = new CollegeDAO();
		ArrayList<college> collegeList = collegeDAO.getCollegeList();
		/*JSONArray jsArray = new JSONArray();
		for(int i=0;i<3;i++){
			JSONObject jObjd=new JSONObject();
			jObjd.put("id", "1");
			jObjd.put("id2", "2");
			jsArray.put(jObjd);
		}
		System.out.println("this "+jsArray);
		PrintWriter out = response.getWriter();
		out.println(jsArray);*/
		Gson gson = new GsonBuilder().create();
		JsonArray a = gson.toJsonTree(collegeList).getAsJsonArray();
		PrintWriter out = response.getWriter();
		out.println(a);
	}
	@RequestMapping(value="/addcollege", method=RequestMethod.GET)
	public void addCollege(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String collegename = request.getParameter("collegename");
		CollegeDAO collegeDAO = new CollegeDAO();
		college college = new college();
		college.setCollegeName(collegename);
		collegeDAO.addCollege(college);
		PrintWriter out = response.getWriter();
		out.println(college.getCollegeName()+" has been added Successfully");
		
		
	}
}
