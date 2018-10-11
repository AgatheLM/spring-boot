package dawan.bacasable.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dawan.bacaasable.monument.Monument;
import dawan.bacaasable.monument.Point;


@Controller
@EnableAutoConfiguration
public class MonumentController {
	

	//@PostMapping(value ="/monument")
	@RequestMapping(value ="/monument",  method=RequestMethod.POST)
	@ResponseBody
	Monument create(@RequestBody Monument m) {
		m.setId(5);
		return m;
	}
	
	@RequestMapping(value ="/monument/{id}",  method=RequestMethod.GET)
	@ResponseBody
	Monument find(@PathVariable(value="id", required=true) int id) {
		Monument m= new Monument();
		m.setNom("Tour Eiffel");
		m.setDescription("c'est très haut");
		m.setId(id);
		m.setPosition(Arrays.asList(new Point(15.0,16.0),new Point(17.0,18.0)));
		return m;
	}
	
	@RequestMapping(value ="/monument",  method=RequestMethod.PUT, consumes= {"application/json","application/xml"}, produces = {"application/json"})
	@ResponseBody
	Monument update(@RequestBody Monument m) {
		return m;
	}
	
	
	@RequestMapping(value ="/monument/{id}",  method=RequestMethod.DELETE)
	@ResponseBody
	Monument delete(@PathVariable(value="id", required=true) int id) {
		Monument m= new Monument();
		m.setNom("Tour Eiffel");
		m.setDescription("c'est très haut");
		m.setId(id);
		m.setPosition(Arrays.asList(new Point(15.0,16.0),new Point(17.0,18.0)));
		return m;
	}
	
	@RequestMapping(value ="/monuments")
	@ResponseBody
	List<Monument> findAll() {
		Monument m1= new Monument();
		m1.setNom("Tour Eiffel");
		m1.setDescription("c'est très haut");
		m1.setId(1);
		m1.setPosition(Arrays.asList(new Point(15.0,16.0),new Point(17.0,18.0)));
		Monument m2= new Monument();
		m2.setNom("Arc de triomphe");
		m2.setDescription("c'est une porte");
		m2.setId(2);
		m2.setPosition(Arrays.asList(new Point(16.0,15.0),new Point(18.0,17.0)));
		return Arrays.asList(m1,m2);
	}
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MonumentController.class, args);
	}


}
