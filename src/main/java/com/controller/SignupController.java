package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SignupController {
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(UserBean user, Model model) {
		model.addAttribute("user",user);
		return "Signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {
		System.out.println("SaveUser called.....");
		System.out.println(result);
		if (result.hasErrors()) {// true == error
			model.addAttribute("user", user);
			return "Signup";
		} else {
			user.setUserType("customer");
			userDao.addUser(user);
			model.addAttribute("msg", "Signup done..");
			return "redirect:/login";

		}
	}

	@GetMapping("/login")
	public String login(LoginBean login,Model model) {
		model.addAttribute("login",login);
		return "Login";
	}

	@PostMapping("/login")
	public String authenticate(@ModelAttribute("login") @Valid LoginBean login, BindingResult result, Model model, HttpSession session) {
		UserBean user = userDao.authenticate(login);
		System.out.println(result);
		if (result.hasErrors()) {
			model.addAttribute("login", login);
			return "Login";
		} else if (user.getUserType().contentEquals("customer")) {
			session.setAttribute("user", user);
			return "Home";
		} else if (user.getUserType().contentEquals("admin")) {
			session.setAttribute("user", user);
			return "Dashboard";
		} else {
			model.addAttribute("msg", "Please Contact Admin");
			return "Login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}