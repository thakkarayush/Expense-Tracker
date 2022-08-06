package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;
import com.bean.AmountBean;

@Repository
public class ExpenseDao {

	@Autowired
	JdbcTemplate stmt;

	public void addExpense(ExpenseBean expenseBean) {
		stmt.update("insert into expense(categoryid,date,time,description,amount,typeofpayment,userid,subcategoryname) values(?,?,?,?,?,?,?,?)",
				expenseBean.getCategoryId(),expenseBean.getDate(),expenseBean.getTime(),
				expenseBean.getDescription(),expenseBean.getAmount(),
				expenseBean.getTypeofpayment(),expenseBean.getUserId(),expenseBean.getSubCategoryName());
		System.out.println(expenseBean.getSubCategoryName());
	}

	public List<ExpenseBean> listExpense(Integer userId) {
		return stmt.query("select * from expense where userId=?" , new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {userId}); 
	}

	public List<ExpenseBean> totalExpense(Integer userId) {
		return stmt.query("select sum(amount) as amount from expense where userId=?" , new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {userId});
	}
	
		
	
}