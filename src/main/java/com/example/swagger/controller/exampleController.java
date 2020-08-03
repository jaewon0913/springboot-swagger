package com.example.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/example")
public class exampleController {
	
	@GetMapping("/test")
	public String test() {
		
		return "swagger test project";
	}
	
	@RequestMapping("/test2")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
}

