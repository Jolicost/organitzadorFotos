package main;

public abstract class LectorParametres {
	

	public LectorParametres(){
		resultat = new Configuracio();
	}
	
	protected Configuracio resultat;
	
	public void llegirConfiguracio(){
		resultat = this.obtenirConfiguracio();
	}
	
	protected abstract Configuracio obtenirConfiguracio();
	
	public Configuracio getConfiguracio(){
		return resultat;
	}
}
