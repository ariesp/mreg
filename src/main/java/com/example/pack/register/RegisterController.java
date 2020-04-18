package com.example.pack.register;

import static com.example.pack.core.RequestMappingContant.REDIRECT;
import static com.example.pack.core.RequestMappingContant.REGISTER;
import static com.example.pack.core.RequestMappingContant.SAVE;
import static com.example.pack.core.TemplateConstant.ERROR_MESSAGE_KEY;
import static com.example.pack.core.TemplateConstant.STATUS_MESSAGE_KEY;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = REGISTER)
public class RegisterController {
	
	static final String REGISTER_DIR_TEMPLATE_NAME = "register/";
	static final String REGISTER_CREATE_TEMPLATE_NAME = "register-create";
	
	static final String REGISTER_CREATE = REGISTER_DIR_TEMPLATE_NAME + REGISTER_CREATE_TEMPLATE_NAME;
	
	@Autowired
	private RegisterService registerService;

	@GetMapping
	public ModelAndView root(Model model) {	
		RegisterForm registerForm = new RegisterForm();
		model.addAttribute("registerForm", registerForm);
		
		return new ModelAndView(REGISTER_CREATE);
	}
	
	@PostMapping(value = SAVE)
	public String save(@Valid RegisterForm registerForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("registerForm", registerForm);
	        return REGISTER_CREATE;
		}
		
		try {
			ResponseEntity<RegisterForm> response =  registerService.save(registerForm);
			redirectAttributes.addFlashAttribute(STATUS_MESSAGE_KEY,
					"Your registration has submitted, check your email: " 
							+ response.getBody().getEmail()
							+ " to verify");
			return REDIRECT + "/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute(ERROR_MESSAGE_KEY, new StringBuilder("Something went wrong: ").append(e.getMessage()));
			return REDIRECT + REGISTER_CREATE;
		}
	
	}
}
