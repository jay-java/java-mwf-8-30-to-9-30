package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		request.setAttribute("name", "java");
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("java");
		list.add("java");
		list.add("java");
		list.add("java");
		request.setAttribute("list", list);
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute User u,Model m) {
		dao.inserOrUpdatetUser(u);
		List<User> list= dao.getAllUser();
		m.addAttribute("list", list);
		return "home";
	}
	

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

}
