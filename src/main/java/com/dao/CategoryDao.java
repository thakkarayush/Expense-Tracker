package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;

@Repository
public class CategoryDao {
	@Autowired
	JdbcTemplate stmt;

	public void addCategory(CategoryBean categoryBean) {
		stmt.update("insert into category(categoryname,userid) values(?,?)", categoryBean.getCategoryName(),
				categoryBean.getUserId());
	}

	public List<CategoryBean> listCategory(Integer userId) {
		return stmt.query("select * from category where userId=? or userId=9",
				new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class), new Object[] { userId });
	}
}