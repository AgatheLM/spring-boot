package dawan.filrouge.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

	@RequestMapping(value="/", method=RequestMethod.POST, consumes="multipart/form-data")
	String upload(@RequestParam(value="fileUpload", required=true) MultipartFile file) throws IOException {
		return "uploaded: taille : " + file.getBytes().length + " - nom : " +file.getOriginalFilename() + " - type : " + file.getContentType();
	}
		
	
	@RequestMapping(value ="/{nom}",  method=RequestMethod.DELETE)
	void delete(@PathVariable(value="nom", required=true) String nom) {

	}
	

	@RequestMapping(value ="/{nom}",  method=RequestMethod.GET, produces="application/octet-stream")
	byte[] get(@PathVariable String nom, @RequestParam("format") String format) {
		return new byte[0];
	}
	
}
