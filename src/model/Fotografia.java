package model;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class Fotografia extends File {


	public Fotografia(File f) {
		super(f.getAbsolutePath());
		this.populate(f.getName());
	}

	private String nom;
	private LocalDateTime creacio;
	private String extensio;
	
	private void populate(String filename){
		this.nom = FilenameUtils.getBaseName(filename);
		this.extensio = FilenameUtils.getExtension(filename);
		this.creacio = new LocalDateTime(this.lastModified());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getCreacio() {
		return creacio;
	}

	public void setCreacio(LocalDateTime creacio) {
		this.creacio = creacio;
	}

	public String getExtensio() {
		return extensio;
	}

	public void setExtensio(String extensio) {
		this.extensio = extensio;
	}

	@Override
	public boolean equals(Object obj) {
		Fotografia f = (Fotografia) obj;
		return f.getName().equals(this.getName()) && 
				f.getExtensio().equals(this.getExtensio()) &&
				f.getCreacio().equals(this.getCreacio());
	}
	
	public boolean mateixNom(Fotografia f){
		return f.getNom().equals(this.getNom()) && this.getExtensio().equals(f.getExtensio());
	}
	
}
