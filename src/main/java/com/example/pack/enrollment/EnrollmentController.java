package com.example.pack.enrollment;

import static com.example.pack.core.RequestMappingContant.ENROLLMENT;
import static com.example.pack.core.RequestMappingContant.REDIRECT;
import static com.example.pack.core.RequestMappingContant.SAVE;
import static com.example.pack.core.TemplateConstant.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = ENROLLMENT)
public class EnrollmentController {
	
	static final String ENROLLMENT_DIR_TEMPLATE_NAME = "enrollment/";
	static final String ENROLLMENT_CREATE_TEMPLATE_NAME = "enrollment-create";
	
	static final String ENROLLMENT_CREATE = ENROLLMENT_DIR_TEMPLATE_NAME + ENROLLMENT_CREATE_TEMPLATE_NAME;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@GetMapping
	public ModelAndView root(Model model) {	
		EnrollmentForm enrollmentForm = new EnrollmentForm();
		model.addAttribute("enrollmentForm", enrollmentForm);
		
		return new ModelAndView(ENROLLMENT_CREATE);
	}
	
	@PostMapping(value = SAVE)
	public String save(@Valid EnrollmentForm enrollmentForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("enrollmentForm", enrollmentForm);
	        return ENROLLMENT_CREATE;
		}
		try {
			if (enrollmentService.findByPhoneNumber(enrollmentForm.getPhoneNumber()) != null) {
				model.addAttribute("errorPhoneNumber", ERROR_MESSAGE_PHONE_INVALID);
				model.addAttribute("enrollmentForm", enrollmentForm);
				return ENROLLMENT_CREATE;
			}
			if (enrollmentService.findByEmail(enrollmentForm.getEmail()) != null) {
				model.addAttribute("errorEmail", ERROR_MESSAGE_EMAIL_INVALID);
				model.addAttribute("enrollmentForm", enrollmentForm);
		        return ENROLLMENT_CREATE;
			}
			
			Enrollment enrollment = enrollmentForm.bindToModel(new Enrollment());
			enrollmentService.saveOrUpdate(enrollment);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute(ERROR_MESSAGE_KEY, new StringBuilder("Something went wrong: ").append(e.getMessage()));
			return REDIRECT + ENROLLMENT;
		}
	
		redirectAttributes.addFlashAttribute(STATUS_MESSAGE_KEY, "Your registration has submitted, check your email to verify");
		return REDIRECT + "/login";
	}
}
