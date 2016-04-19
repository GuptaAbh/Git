package com.npu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.npu.dao.UserDAO;
import com.npu.pojo.FileUpload;


@Controller
public class UploadController {

	
	@RequestMapping(value = "/picpic", method = RequestMethod.POST)
	public String uploadPic(@RequestParam("fileabc") MultipartFile mfile,Model model, @ModelAttribute("fileObj") FileUpload file, HttpServletRequest request,BindingResult result, HttpServletResponse response)
	{
		
		//String ext = FilenameUtils.getExtension((file.getFile()).getOriginalFilename());
		//	String name = old.getFirstName()+"_"+System.currentTimeMillis()*r+"_pic."+ext;
			//old.setProfilepicName(name);
			
			UserDAO userdao = new UserDAO();
			boolean flag = userdao.uploadImage(file);
			
		/*try{
		System.out.println("Inside");
		String returnPage = "UserProfile";
		if(!file.getFile().isEmpty())
		{
		if (result.hasErrors())
		{
		//--- errors detected ---//
			}
		else {
			try {
				//-- old.setProfilepic(photo); 
				String ext = FilenameUtils.getExtension((file.getFile()).getOriginalFilename());
			//	String name = old.getFirstName()+"_"+System.currentTimeMillis()*r+"_pic."+ext;
				//old.setProfilepicName(name);
				
				UserDAO userdao = new UserDAO();
				boolean flag = userdao.uploadImage(file);
				//boolean flag = userDao.uploadImage(old,file,name);		
				System.out.println("the img store flag is "+flag);
				if (flag) {
					model.addAttribute("message",
							"Your profile has been updated successfully");
					model.addAttribute("task", "success");
					//request.getSession().setAttribute("user",old);

				} 
				else {
					model.addAttribute(
							"message",
							"Please try again, your profile could not be saved");
					model.addAttribute("task", "failure");
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
		else{
			model.addAttribute(
					"message",
					"Profile picture can not be saved, Please try again with a Image format");
			model.addAttribute("task", "failure");
			System.out.println("file empty");
		}
		model.addAttribute("fileObj", new FileUpload());
		return returnPage;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "home";
		}*/
		return "home";
	}
	
}
