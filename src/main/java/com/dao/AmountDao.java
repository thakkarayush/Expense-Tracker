package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AmountBean;

@Repository
public class AmountDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addAmount(AmountBean amount) {
		stmt.update("insert into amount(accounttype,amount,userid,cardno,upiid) values(?,?,?,?,?)" ,
				amount.getAccountType(),amount.getAmount(),amount.getUserId(), amount.getCardNo(), amount.getUpiId());	}

	public List<AmountBean> listAmount(Integer userId) {
		return stmt.query("select * from amount where userId=?" , new BeanPropertyRowMapper<AmountBean>(AmountBean.class),new Object[] {userId}); 
	}

	public List<AmountBean> listAmountType(Integer userId) {
		return stmt.query("select * from amount where userId=?",
				new BeanPropertyRowMapper<AmountBean>(AmountBean.class), new Object[] {userId});
	}

	public List<AmountBean> totalBalance(Integer userId) {
		
		return stmt.query("select sum(amount) as amount from amount where userId=?" , new BeanPropertyRowMapper<AmountBean>(AmountBean.class),new Object[] {userId});
	}

	public void saveExistingAmount(AmountBean amountBean) {
		List<AmountBean> list = new ArrayList<AmountBean>();
		list=stmt.query("select amount from amount where userid=? and accounttype=?", new BeanPropertyRowMapper<AmountBean>(AmountBean.class), new Object[] {amountBean.getUserId(), amountBean.getAccountType()});
		int amount=amountBean.getAmount()+list.get(0).getAmount();
		System.out.println(amountBean.getAmount());
		System.out.println(list.get(0).getAmount());
		System.out.println(amount);
		stmt.update("update amount set amount = ? where userid=? and accounttype=?",amount,amountBean.getUserId(),amountBean.getAccountType());
		
	}

}
