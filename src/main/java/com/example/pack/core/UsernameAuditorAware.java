package com.example.pack.core;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsernameAuditorAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal() == null)
				return "system";
			return authentication.getName();
		} catch(ClassCastException | NullPointerException e) {
			return "system"; 
		}
	}
}
