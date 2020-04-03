package edu.qyc.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.qyc.springweb.mode.User;

@Controller
public class UserController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/myJsp.do")
	public String myJsp(User user){
		System.out.println(user.getName());
		return "user/MyJsp";
	}
}
