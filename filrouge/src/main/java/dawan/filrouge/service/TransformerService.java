package dawan.filrouge.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dawan.filrouge.modele.Format;
import dawan.filrouge.modele.Image;

@Service
public class TransformerService {

	public Image  transformer(Image imgInit, Format f) throws IOException, InterruptedException {
		//Telecharger la version portable d'image magick qui permet de modifier une image en ligne de commande
		// Requêtes du type : C:\ImageMagick\magick.exe "C:\Users\ADMINS~1\AppData\Local\Temp\img7099129627256039568pacman.jpg"  -resize 100x100 "C:\Users\ADMINS~1\AppData\Local\Temp\IMG972839681600642856.pdf"
		String convert="C:\\ImageMagick\\magick.exe";
		String commandTemplate = "%s \"%s\" %s \"%s\"";
		
		// On crée le fichier temporaire en entrée
		File fInit = File.createTempFile("img", imgInit.getOriginalFileName());
		FileOutputStream fout = new FileOutputStream(fInit);
		fout.write(imgInit.getContenu());
		fout.close();
		
		//On crée le nom du fichier en sortie, avec le format passé en paramètre
		File fSortie = File.createTempFile("IMG", f.getExtension());
		
		// On parcours les proprité du format
		StringBuilder builder = new StringBuilder();
		for (String pKey : f.getProprietes().keySet()) {
			String pValue = f.getProprietes().get(pKey);
			builder.append(" -");
			builder.append(pKey);
			builder.append(" ");
			builder.append(pValue);	
		}
		
		String command=String.format(commandTemplate, convert, fInit.getAbsolutePath(),builder.toString(),fSortie);
		System.out.println("Commande : "+ command);
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
		
		Image imgRetour = new Image();
		imgRetour.setContenu(Files.readAllBytes(fSortie.toPath()));
		imgRetour.setFormat(f);
		imgRetour.setImageGroupId(imgInit.getImageGroupId());
		imgRetour.setId(UUID.randomUUID().toString());
		return imgRetour;
	}

}


