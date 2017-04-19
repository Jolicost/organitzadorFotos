package main;

import java.util.ArrayList;
import java.util.List;

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


	@Override
	public String toString() {
		return "Configuracio [desti=" + desti + ", mode=" + mode + ", origen=" + origen.toString() + "]";
	}


	
}
