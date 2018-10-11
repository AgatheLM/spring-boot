package dawan.bacasable.monument;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dawan.bacasable.exceptions.MonumentNotFound;


@Controller
@EnableAutoConfiguration
public class MonumentController {
	
	
	//En pratique la couche DAO n'est pas appelée directement par le controller mais passe par une couche service
	@Autowired
	MonumentRepository monumentRepository;
	
	

	//@PostMapping(value ="/monument")
	@RequestMapping(value ="/monument",  method=RequestMethod.POST)
	@ResponseBody
	Monument create(@RequestBody Monument m) {
		Monument monumentSauvegarde = monumentRepository.save(m);
		return monumentSauvegarde;
	}
	
	@RequestMapping(value ="/monument/{id}",  method=RequestMethod.GET)
	@ResponseBody
	Optional<Monument> find(@PathVariable(value="id", required=true) int id) {
		if (!monumentRepository.existsById(id)) {
			throw new MonumentNotFound(id);
		}
		Optional<Monument> monumentDemande = monumentRepository.findById(id);
		return monumentDemande;
	}
	
	@RequestMapping(value ="/monument",  method=RequestMethod.PUT, consumes= {"application/json","application/xml"}, produces = {"application/json"})
	@ResponseBody
	Monument update(@RequestBody Monument m) {
		if (!monumentRepository.existsById(m.getId())) {
			throw new MonumentNotFound(m.getId());
		}
		Monument monumentModifie = monumentRepository.save(m);
		return monumentModifie;
	}
	
	
	@RequestMapping(value ="/monument/{id}",  method=RequestMethod.DELETE)
	@ResponseBody
	Monument delete(@PathVariable(value="id", required=true) int id) {
		if (!monumentRepository.existsById(id)) {
			throw new MonumentNotFound(id);
		}
		// Sur les optional, .get lève une exception si null, orElse(null) renvoie nul
		Monument monumentDemande = monumentRepository.findById(id).get();
		monumentRepository.delete(monumentDemande);
		return monumentDemande;
	}
	
	@RequestMapping(value ="/monuments")
	@ResponseBody
	Page<Monument> findAll(@RequestParam(value="search", required=false) String search, Pageable p) {
		if(search==null) {
			return monumentRepository.findAll(p);

		}else {
			return monumentRepository.findByDescription(search, p);
		}
		
	}
	


	public static void main(String[] args) throws Exception {
		SpringApplication.run(MonumentController.class, args);
	}


}
