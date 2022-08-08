package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AmountBean;
import com.bean.SubCategoryBean;

@Repository
public class AmountDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addAmount(AmountBean amount) {
		stmt.update("insert into amount(accounttype,amount,userid,cardno) values(?,?,?,?)" ,
				amount.getAccountType(),amount.getAmount(),amount.getUserId(), amount.getCardNo());	}

	public List<AmountBean> listAmount(Integer userId) {
		return stmt.query("select * from amount where userId=?" , new BeanPropertyRowMapper<AmountBean>(AmountBean.class),new Object[] {userId}); 
	}

	public List<AmountBean> listAmountType(Integer userId) {
		return stmt.query("select distinct accounttype from amount where userId=?",
				new BeanPropertyRowMapper<AmountBean>(AmountBean.class), new Object[] {userId});
	}

	public List<AmountBean> totalBalance(Integer userId) {
		
		return stmt.query("select sum(amount) as amount from amount where userId=?" , new BeanPropertyRowMapper<AmountBean>(AmountBean.class),new Object[] {userId});
	}

	public void saveExistingAmount(AmountBean amountBean) {
		List<AmountBean> list = new ArrayList<AmountBean>();
		System.out.println(amountBean.getAccountType());
		if(amountBean.getAccountType().equals("cash")) {
			System.out.println("Cash amount updated");
			list=stmt.query("select amount from amount where userid=? and accounttype=?", new BeanPropertyRowMapper<AmountBean>(AmountBean.class), new Object[] {amountBean.getUserId(), amountBean.getAccountType()});
			int amount=amountBean.getAmount()+list.get(0).getAmount();
			System.out.println(amountBean.getAmount());
			System.out.println(list.get(0).getAmount());
			System.out.println(amount);
			stmt.update("update amount set amount = ? where userid=? and accounttype=?",amount,amountBean.getUserId(),amountBean.getAccountType());
			
		}else if(amountBean.getAccountType().equals("paytm") || amountBean.getAccountType().equals("creditcard") || amountBean.getAccountType().equals("debitcard")) {
			System.out.println("Card/paytm amount updated");
			list=stmt.query("select amount from amount where userid=? and accounttype=? and cardno=?", new BeanPropertyRowMapper<AmountBean>(AmountBean.class), new Object[] {amountBean.getUserId(), amountBean.getAccountType(), amountBean.getCardNo()});
			int amount=amountBean.getAmount()+list.get(0).getAmount();
			System.out.println(amountBean.getAmount());
			System.out.println(list.get(0).getAmount());
			System.out.println(amount);
			stmt.update("update amount set amount = ? where userid=? and accounttype=? and cardno=?",amount,amountBean.getUserId(),amountBean.getAccountType(), amountBean.getCardNo());
		}
	}

	public List<AmountBean> listByAmountTypeId(String amountType) {
		return stmt.query("select * from amount where accounttype =?", new BeanPropertyRowMapper<AmountBean>(AmountBean.class),amountType);
	}

}
