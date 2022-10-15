package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author dmasone
 * @implSpec class used for map API endPoint
 *
 */
@RestController
@RequestMapping(value = "/api")
public class SpringBootExampleStsController {
	
	
	@Value("${api.path}")
	private String apiPath;
	@Value("${api.key}")
	private String apiKey;
	
	
	/**
	 * 
	 * @return Test for check webApp works on
	 */
	@RequestMapping("/")
	public String index() {
		return "IT WORKS!!";
	}

}
