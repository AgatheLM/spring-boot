package dawan.filrouge.modele;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Formats")
public class Format {
	
	@Column(length=100)
	@Id
	private String nom;
	private String extension;
	private String mimeType;
	private HashMap<String,String> proprietes= new HashMap<String,String>() ;
	
	// Constructeurs
	public Format() {
		super();
	}
	public Format(String nom, String extension, String mimeType, HashMap<String, String> proprietes) {
		super();
		this.nom = nom;
		this.extension = extension;
		this.mimeType = mimeType;
		this.proprietes = proprietes;
	}
	
	
	// POur simplifier la liste des proprietes
	public void putPropriete(String key, String value) {
	proprietes.put(key, value);
	}
	
	// GETTERS et SETTERS
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public HashMap<String, String> getProprietes() {
		return proprietes;
	}
	public void setProprietes(HashMap<String, String> proprietes) {
		this.proprietes = proprietes;
	}
	
	
}
