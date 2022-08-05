package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.CategoryReportBean;

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

	public List<CategoryReportBean> getCategoryByInvestment() {
		return stmt.query("select c.categoryname as category, sum(e.amount) as totalprice from expense e,category c where e.categoryid=c.categoryid group by c.categoryname",new BeanPropertyRowMapper<CategoryReportBean>(CategoryReportBean.class));
	}
}