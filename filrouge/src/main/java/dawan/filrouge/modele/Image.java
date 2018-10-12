package dawan.filrouge.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Images")
public class Image {
	@Column(length=100)
	@Id
	private String id;
	@Column(columnDefinition="LONGBLOB")
	private byte[] contenu;
	@ManyToOne
	private Format format;
	private String originalFileName;
	private String imageGroupId;
	
	//Constructeurs
	
	public Image() {
		super();
	}
	
	public Image(String id, byte[] contenu, Format format, String originalFileName, String imageGroupId) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.format = format;
		this.originalFileName = originalFileName;
		this.imageGroupId = imageGroupId;
	}
	
	//GETTERS et SETTERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getContenu() {
		return contenu;
	}
	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getImageGroupId() {
		return imageGroupId;
	}
	public void setImageGroupId(String imageGroupId) {
		this.imageGroupId = imageGroupId;
	}
	
	

}
