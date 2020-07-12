package com.stacksimplify.restservices.controllers;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	
	@GetMapping("/hello-world")
	public String  helloWorld() {
		return "Hello World I18N";
	}
	
	
	//more arguments
	@GetMapping("/hello-world-int")
	public String  getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale){
		return messageSource.getMessage("label.hello",null, new Locale(locale));
	}
	
	//without arguments
	@GetMapping("/hello-int")
	public String  getMessagesInI18NFormat2(){
		return messageSource.getMessage("label.hello",null, LocaleContextHolder.getLocale());
	}
	
	
	
	
	
	
	
	

}
