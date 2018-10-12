package dawan.filrouge.controller;


import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dawan.filrouge.Service.TransformerService;
import dawan.filrouge.exception.ImageNotFound;
import dawan.filrouge.modele.Format;
import dawan.filrouge.modele.Image;
import dawan.filrouge.repository.FormatRepository;
import dawan.filrouge.repository.ImageRepository;



@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	TransformerService transformer;

	@Autowired
	FormatRepository formatRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	
	
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes="multipart/form-data")
	String upload(@RequestParam(value = "fileUpload", required = true) MultipartFile file) throws IOException, InterruptedException {
	   Image img = new Image();
	   img.setId(UUID.randomUUID().toString());
	   img.setContenu(file.getBytes());
	   img.setOriginalFileName(file.getOriginalFilename());
	   img.setFormat(null);
	   img.setImageGroupId(img.getId());	   
	   imageRepository.save(img);		
	   for (Format format : formatRepository.findAll()) {
		   Image imageTranformee = transformer.transformer(img, format);	
		   imageRepository.save(imageTranformee);
	   }		
	   return img.getImageGroupId();	   
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	void delete(@PathVariable String id){
		if(!imageRepository.existsById(id)) {
			throw new ImageNotFound(id);
		}
		Image img = imageRepository.findById(id).get();
		imageRepository.delete(img);

	}
	
	
	
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET, produces="application/octet-stream")	
	ResponseEntity<byte[]> get(@PathVariable String groupId, @RequestParam("format") String format){
		Format f= formatRepository.findById(format).get();
		Image img = imageRepository.findByImageGroupId(groupId, format);
		System.out.println(img);
		return ResponseEntity.ok()
		.header("Content-Type", f.getMimeType())
		.header("Content-Disposition", "attachment; filename=\"out"+f.getExtension()+"\"")
		.body(img.getContenu());
		
	}
	
}