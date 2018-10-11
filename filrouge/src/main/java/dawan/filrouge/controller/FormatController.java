package dawan.filrouge.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dawan.filrouge.modele.Format;




@RestController
public class FormatController {
	
	//Retourne la liste de tous les formats
	@RequestMapping(value ="/formats")
	List<Format> findAll() {
		Format f1= new Format();
		f1.setNom("MEDIUM");
		f1.setExtension(".png");
		f1.setMimeType("image/png");
		f1.putPropriete("hauteur", "10");
		f1.putPropriete("largeur", "12");
		Format f2= new Format();
		f2.setNom("MEDIUM");
		f2.setExtension(".jpg");
		f2.setMimeType("image/jpg");
		f2.putPropriete("hauteur", "10");
		f2.putPropriete("largeur", "12");
		return Arrays.asList(f1,f2);
	}
	
	//Retourne un format
	@RequestMapping(value ="/format/{nom}",  method=RequestMethod.GET)
	Format find(@PathVariable(value="nom", required=true) String nom) {
		Format f1= new Format();
		f1.setNom(nom);
		f1.setExtension(".png");
		f1.setMimeType("image/png");
		f1.putPropriete("hauteur", "10");
		f1.putPropriete("largeur", "12");
		return f1;
	}
	
	//Insère un format d'image
	@RequestMapping(value ="/format",  method=RequestMethod.POST)
	Format create(@RequestBody Format f) {
		f.setNom("SMALL");
		return f;
	}
	
	
	//Supprime un format d'image
	@RequestMapping(value ="/format/{id}",  method=RequestMethod.DELETE)
	Format delete(@PathVariable(value="nom", required=true) String nom) {
		Format f1= new Format();
		f1.setNom("MEDIUM");
		f1.setExtension(".png");
		f1.setMimeType("image/png");
		f1.putPropriete("hauteur", "10");
		f1.putPropriete("largeur", "12");
		return f1;
	}
	
	// Update un format d'image
	@RequestMapping(value ="/format",  method=RequestMethod.PUT)
	Format update(@RequestBody Format m) {
		return m;
	}
	
	//Retourne un format
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
