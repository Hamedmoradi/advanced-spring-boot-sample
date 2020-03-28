package com.pooyabyte.training.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginEventListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

@Override
public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
{
	
	UserDetails user = (UserDetails) event.getAuthentication().getPrincipal();
	//todo update
	System.out.println("LOGIN name: "+user.getUsername());
}
}