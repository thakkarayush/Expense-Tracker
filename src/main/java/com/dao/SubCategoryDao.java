package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SubCategoryBean;

@Repository
public class SubCategoryDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addSubCategory(SubCategoryBean subCateoryBean) {
		stmt.update("insert into subcategory(categoryid, subcategoryname, userid) values(?,?,?)", subCateoryBean.getCategoryId(),
				subCateoryBean.getSubCategoryName(),subCateoryBean.getUserId());
		
	}

	public List<SubCategoryBean> listBySubCategoryId(int categoryId) {
		return stmt.query("select * from subcategory where categoryid =?", new BeanPropertyRowMapper<SubCategoryBean>(SubCategoryBean.class),categoryId);
	}
}
