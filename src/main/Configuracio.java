package main;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuracio {

	public Configuracio(String desti, Mode mode, List<String> origen) {
		super();
		this.desti = desti;
		this.mode = mode;
		this.origen = origen;
	}
	private String desti;
	private Mode mode;
	private List<String> origen;
	
	public Configuracio() {
		this.origen = new ArrayList<>();
	}
	
	public String getDesti() {
		return desti;
	}
	public void setDesti(String desti) {
		this.desti = desti;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public List<String> getOrigen() {
		return origen;
	}
	public void setOrigen(List<String> origen) {
		this.origen = origen;
	}
	
	/* Afegeix un element a la llista origen */
	public boolean add(String e) {
		return origen.add(e);
	}
	
	public void validar() throws ConfiguracioInvalida{
		boolean ret = true;
		if (this.origen == null) ret = false;
		if (this.mode == null) ret = false;
		if (this.desti == null) ret = false;
		
		if (!ret) throw new ConfiguracioInvalida();
	}


	@Override
	public String toString() {
		return "Configuracio: " + "\n" +
				"Origen:" + "\n" +
				"\t" + this.origen.toString() +  "\n" +
				"Desti:"  + "\n" +
				"\t" + this.desti  + "\n" +
				"Mode:"  + "\n" +
				"\t" + this.mode.toString();
	}
	
	private class ConfiguracioInvalida extends Exception{
		public String toString(){
			return "la configuracio es invalida";
			//test
		}
	}

	public String toJson(){
		GsonBuilder b = new GsonBuilder();
		Gson g = b.setPrettyPrinting().create();
		return g.toJson(this);
	}
	
	public static Configuracio fromJson(String json){
		Gson g = new Gson();
		return g.fromJson(json, Configuracio.class);
	}
	
	public boolean Validacio (){
		try {
			this.validar();
			return true;
		} catch (ConfiguracioInvalida e) {
			return false;
		}
	}


	
}
