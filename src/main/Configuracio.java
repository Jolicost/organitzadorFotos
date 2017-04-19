package main;

import java.util.List;

public class Configuracio {

	private String desti;
	private Mode mode;
	private List<String> origen;
	
	public Configuracio() {
		
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
	
}
