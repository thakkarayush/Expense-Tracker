package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@RestController
public class SubCategoryRestController {
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
	@GetMapping("/listSubCategoryById")
	public List<SubCategoryBean> listSubCategory(@RequestParam("categoryId") int categoryId){
		List<SubCategoryBean> listSubCategory = subCategoryDao.listBySubCategoryId(categoryId);
		return listSubCategory;
	}
}
