package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AmountBean;
import com.bean.SubCategoryBean;
import com.dao.AmountDao;
import com.dao.SubCategoryDao;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
	@Autowired
	AmountDao amountDao;
	
	@GetMapping("/listSubCategoryById")
	public List<SubCategoryBean> listSubCategory(@RequestParam("categoryId") int categoryId){
		List<SubCategoryBean> listSubCategory = subCategoryDao.listBySubCategoryId(categoryId);
		return listSubCategory;
	}
	
	@GetMapping ("/listCardNumberById")
	public List<AmountBean> listCardNumber(@RequestParam("amountType") String amountType){
		List<AmountBean> listCardNo = amountDao.listByAmountTypeId(amountType);
		return listCardNo;
	}
}
