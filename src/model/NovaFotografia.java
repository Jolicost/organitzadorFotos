package model;

import java.io.File;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NovaFotografia extends Fotografia {

	/* Podem instanciar una nova Fotografia a partir de l'antiga, ja que ambdues deriven de File */
	public NovaFotografia(File f,String nouNom,String path) {
		super(f);
		this.nouNom = nouNom;
		this.path = path;
	}
	
	public NovaFotografia(Fotografia f,String path){
		super(f);
		this.nouNom = obtenirNouNom();
		this.path = path;
	}
	
	private String nouNom;
	private String path;
	
	private static String defaultPattern = "^(?:\\d{4})-(?:\\d{1,2})-(?:\\d{1,2}) (.+)$";
	
	public String getNouNom(){
		return nouNom;
	}
	
	public void setNouNom(String nouNom){
		this.nouNom = nouNom;
	}
	
	protected boolean nameMatches(){
		Pattern p = Pattern.compile(this.getPattern());
		Matcher m = p.matcher(this.getNom());
		return m.matches();
	}
	
	protected String getPattern(){
		return NovaFotografia.defaultPattern;
	}
	
	protected String obtenirNouNom(){
		if (nameMatches()) return this.getNom();
		else{
			String data = this.getCreacio().toString("YYYY-MM-dd");
			return data + " " + this.getNom();
		}
	}
	
	public String getNomFinal(){
		return this.path + File.separator + this.getNouNom() + "." +  this.getExtensio();
	}
	public void moureFitxer() throws Exception {
		this.renameTo(new File(this.getNomFinal()));
	}
	
	public boolean mateixNom(NovaFotografia f){
		return f.getNouNom().equals(this.getNouNom()) && this.getExtensio().equals(f.getExtensio());
	}
	
	public static class ComparadorNovaFotografia implements Comparator<NovaFotografia>{


		@Override
		public int compare(NovaFotografia o1, NovaFotografia o2) {
			return o1.getNomFinal().compareTo(o2.getNomFinal());
		}
		
	}

}
