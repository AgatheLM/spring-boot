package dawan.bacasable.monument;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

//Permet de converitr le json en xml quand on demande un header Acvcept : application/xml
@XmlRootElement
@Entity
@Table(name="Points")
public class Point {
	
	@Id
	@GeneratedValue
	private int id;
	private double latitude;
	private double longitude;	
	
	// Constructeurs
	/* Le constructeur vide est utile pour Spring*/
	
	public Point() {
		super();
	}

	public Point(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	//GETTERS et SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Pour surcharger le nom de l'attribut quand on envoie un xml ou un json en post
	@XmlElement(name="lat")
	@JsonProperty("lat")
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	//Pour surcharger le nom de l'attribut quand on envoie un xml ou un json en post
	@XmlElement(name="long")
	@JsonProperty("long")
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
