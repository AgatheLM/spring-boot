package dawan.bacasable.monument;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// Permet de converitr le json en xml quand on demande un header Acvcept : application/xml

@Entity
@Table(name="Monuments")
@XmlRootElement
public class Monument {
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String description;
	//Permet de créer et supprimer en cascade
	@OneToMany(cascade=CascadeType.ALL)
	private List<Point> position;
	
	// GETTERS et SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
