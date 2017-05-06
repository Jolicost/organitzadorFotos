package model;

import java.io.File;

import org.joda.time.LocalDateTime;

public class Fotografia extends File {

	public Fotografia(String pathname) {
		super(pathname);
	}

	private String nom;
	private LocalDateTime creacio;
	private String extensio;
	
	
}
