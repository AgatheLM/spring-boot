package dawan.bacasable.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWordController {
	
	@RequestMapping("/{nom}")
	@ResponseBody
	String home(@PathVariable("nom") String monNom) {
		return "Hello " + monNom +" !";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloWordController.class, args);
	}

}
