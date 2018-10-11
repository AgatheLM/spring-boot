package dawan.filrouge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dawan.filrouge.exception.FormatNotFound;
import dawan.filrouge.modele.Format;
import dawan.filrouge.repository.FormatRepository;




@RestController
public class FormatController {
	
	@Autowired
	FormatRepository formatRepository;
	
	//Retourne la liste de tous les formats
	@RequestMapping(value ="/formats")
	Iterable<Format> findAll() {
		return  formatRepository.findAll();
	}
	
	//Retourne un format
	@RequestMapping(value ="/format/{nom}",  method=RequestMethod.GET)
	Optional<Format> find(@PathVariable(value="nom", required=true) String nom) {
		if(!formatRepository.existsById(nom)) {
			throw new FormatNotFound(nom);
		}
		return formatRepository.findById(nom);
	}
	
	//Insère un format d'image
	@RequestMapping(value ="/format",  method=RequestMethod.POST)
	Format create( Format f) {
		Format format = formatRepository.save(f);
		return format;
	}
	
	
	//Supprime un format d'image
	@RequestMapping(value ="/format/{id}",  method=RequestMethod.DELETE)
	Format delete(@PathVariable(value="nom", required=true) String nom) {
		if(!formatRepository.existsById(nom)) {
			throw new FormatNotFound(nom);
		}
		Format format = formatRepository.findById(nom).get();
		formatRepository.delete(format);
		return format;
	}
	
	// Update un format d'image
	@RequestMapping(value ="/format",  method=RequestMethod.PUT)
	Format update( Format f) {
		if(!formatRepository.existsById(f.getNom())) {
			throw new FormatNotFound(f.getNom());
		}
		return formatRepository.save(f);
		
	}
	
	//Retourne un format exemple
		@RequestMapping(value ="/format/exemple",  method=RequestMethod.GET)
		Format exemple() {
			Format f1= new Format();
			f1.setNom("MEDIUM");
			f1.setExtension(".png");
			f1.setMimeType("image/png");
			f1.putPropriete("hauteur", "10");
			f1.putPropriete("largeur", "12");
			return f1;
		}
	
	



}
