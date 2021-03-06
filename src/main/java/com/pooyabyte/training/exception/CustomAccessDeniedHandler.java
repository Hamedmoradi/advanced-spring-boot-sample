package com.pooyabyte.training.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

public static final Logger LOG = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);


@Override
public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.access.AccessDeniedException e) throws IOException, ServletException {
	Authentication auth
			= SecurityContextHolder.getContext().getAuthentication();
	if (auth != null) {
		LOG.warn("User: " + auth.getName()
				         + " attempted to access the protected URL: "
				         + httpServletRequest.getRequestURI());
	}
	
	httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/accessDenied");
}
}