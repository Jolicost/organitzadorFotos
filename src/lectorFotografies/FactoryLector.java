package lectorFotografies;

import main.Configuracio;

public class FactoryLector {

	private static FactoryLector instance = new FactoryLector();
	public static FactoryLector getInstance(){
		return FactoryLector.instance;
	}
	
	public ILector obtenirLectorFotografies(Configuracio conf,String arrel){
		if (conf.esModeArbre()){
			return new LectorArbreFotografies(arrel);
		}
		else if (conf.esModeCarpeta()){
			return new LectorCarpetaFotografies(arrel);
		}
		else {
			return new LectorCarpetaFotografies(arrel);
		}
	}
}
