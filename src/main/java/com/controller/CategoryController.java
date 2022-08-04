package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.AmountBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	@GetMapping("/addcategory")
	public String addcategory() {
		return "AddCategory";
	}
	@PostMapping("/savecategory")
	public String addCategory(CategoryBean categoryBean) {
		
		categoryDao.addCategory(categoryBean);
		return "Home";
	}
	@GetMapping("/listcategory")
	public String listCategory(HttpSession session, Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<CategoryBean> category = categoryDao.listCategory(user.getUserId());
		model.addAttribute("category", category);
		return "ListCategory";
	}
}