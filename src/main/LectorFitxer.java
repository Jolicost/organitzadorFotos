package main;

public class LectorFitxer extends LectorConfiguracio {

	public LectorFitxer(String fitxer){
		this.fitxer = fitxer;
	}
	
	protected String fitxer;
	@Override
	protected Configuracio obtenirConfiguracio() {
		Configuracio ret = new Configuracio();
		// TODO Auto-generated method stub
		return ret;
	}

}
