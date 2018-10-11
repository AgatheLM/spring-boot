package dawan.filrouge.modele;

import java.util.HashMap;
import java.util.Map;

public class Format {

	private String nom;
	private String extension;
	private String mimeType;
	private Map<String,String> proprietes= new HashMap<>() ;
	
	// Constructeurs
	public Format() {
		super();
	}
	public Format(String nom, String extension, String mimeType, Map<String, String> proprietes) {
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
	public Map<String, String> getProprietes() {
		return proprietes;
	}
	public void setProprietes(Map<String, String> proprietes) {
		this.proprietes = proprietes;
	}
	
	
}
