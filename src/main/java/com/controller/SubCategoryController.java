package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@GetMapping("/addsubcategory")
	public String addSubCategorty(HttpSession session, Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<CategoryBean> category = categoryDao.listCategory(user.getUserId());	
		model.addAttribute("category", category);
		return "AddSubCategory";
	}
	
	@PostMapping("/savesubcategory")
	public String saveSubCategory(SubCategoryBean subCateoryBean) {
		subCategoryDao.addSubCategory(subCateoryBean);
		return "Home";
	}

}
