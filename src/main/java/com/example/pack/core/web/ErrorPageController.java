package com.example.pack.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController implements ErrorController {
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@GetMapping(value = "/error")
	public ModelAndView error(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		model.addAttribute("error", errorAttributes.getErrorAttributes(requestAttributes, true));
		
		return new ModelAndView("error");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
