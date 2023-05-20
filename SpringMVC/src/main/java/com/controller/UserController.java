package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.UserDao;
import com.model.User;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("name", "java");
//		request.setAttribute("name", "java");
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("java");
//		list.add("java");
//		list.add("java");
//		list.add("java");
//		request.setAttribute("list", list);
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/home")
	public String Home(Model m) {
		List<User> list= dao.getAllUser();
		m.addAttribute("list", list);
		return "home";
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute User u,Model m) {
		dao.inserOrUpdatetUser(u);
		List<User> list= dao.getAllUser();
		m.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value="/update/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		User u = dao.getUserById(id);
		ModelAndView m = new ModelAndView();
		m.addObject("u", u);
		m.setViewName("update");
		return m;
	}
	

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/delete/{id}")
	public RedirectView deleteUser(@PathVariable("id") int id,Model m,HttpServletRequest request) {
		User u = dao.getUserById(id);
		dao.deleteUer(u);
		List<User> list= dao.getAllUser();
		m.addAttribute("list", list);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath()+"/home");
		return r;
	}
	
//	@RequestMapping(value="/delete/{id}")
//	public ModelAndView deleteUser(@PathVariable("id") int id) {
//		User u = dao.getUserById(id);
//		dao.deleteUer(u);
//		List<User> list= dao.getAllUser();
//		ModelAndView m = new ModelAndView();
//		m.addObject("list", list);
//		m.setViewName("home");
//		return m;
//		
//	}

}
