package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.service.FileUploadService;

@Controller
public class ProfileController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	ProfileDao profileDao;
	
	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile";
	}
	
	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, HttpSession session) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		System.out.println(userId);

		try {
			fileUploadService.imageUpload(file, userId);

			ProfileBean profileBean = new ProfileBean();
			profileBean.setUserId(userId);
			profileBean.setProfileUrl("resources\\images\\" + userId + "\\" + file.getOriginalFilename());
			profileDao.addImg(profileBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/listprofileimages";
	}
	
	@GetMapping("/listprofileimages")
	public String getAllImage(HttpSession session, Model model) {
		UserBean user =(UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		List<ProfileBean> profiles = profileDao.getAllProfileImagesByUser(userId);
		model.addAttribute("profiles", profiles);
		return "ListProfileImages";
	}
	
	@GetMapping("/deleteprofile")
	public String deleteprofile(@RequestParam("profileId") int profileId, Model model) {
		profileDao.deleteProfile(profileId);
		return "redirect:/listprofileimages";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
}
