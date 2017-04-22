package main;


public abstract class LectorConfiguracio {
	

	public LectorConfiguracio(){
		resultat = new Configuracio();
	}
	
	protected Configuracio resultat;
	
	public void llegirConfiguracio() throws Exception{
		resultat = this.obtenirConfiguracio();
	}
	
	protected abstract Configuracio obtenirConfiguracio() throws Exception;
	
	public Configuracio getConfiguracio(){
		return resultat;
	}
}
