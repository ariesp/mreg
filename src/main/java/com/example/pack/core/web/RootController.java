package com.example.pack.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	
	@GetMapping
	public String root(HttpServletRequest request, HttpServletResponse response) {		
		return "enrollment";
	}
	
	@GetMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}
}