package dawan.bacaasable.monument;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// Permet de converitr le json en xml quand on demande un header Acvcept : application/xml
@XmlRootElement
public class Monument {
	
	private int id;
	private String nom;
	private String description;
	private List<Point> position;
	
	// GETTERS et SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Point> getPosition() {
		return position;
	}
	public void setPosition(List<Point> position) {
		this.position = position;
	}
	
	
	
	

}
