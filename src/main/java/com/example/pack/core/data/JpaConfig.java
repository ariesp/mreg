package com.example.pack.core.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.pack.core.AuditingDateTimeProvider;
import com.example.pack.core.CurrentTimeDateTimeService;
import com.example.pack.core.DateTimeService;
import com.example.pack.core.UsernameAuditorAware;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class JpaConfig {

	@Bean
	public DateTimeService currentTimeDateTimeService() {
		return new CurrentTimeDateTimeService();
	}

	@Bean
	public DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
		return new AuditingDateTimeProvider(dateTimeService);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new UsernameAuditorAware();
	}
}
