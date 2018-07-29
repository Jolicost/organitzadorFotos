package main;

import java.util.HashSet;
import java.util.Set;

import algorisme.OrdenarFotografies;
import lectorFotografies.FactoryLector;
import lectorFotografies.ILector;
import model.Fotografia;

public class Main {

	public static void main (String[] argv) {
		if (argv.length < 1) {
			System.err.println("usage: organitzadorFotos.jar (Mode) (Fitxer)");
			System.err.println("Mode: consola | fitxer | test");
			return;
		}
		
		if(argv[0].equalsIgnoreCase("consola")){
			escriureConfiguracioConsola(argv[1]);
		}
		else if(argv[0].equalsIgnoreCase("fitxer")){
			ordenarFotografies(argv[1]);
		}
		else if (argv[0].equalsIgnoreCase("test")){
			testFitxer(argv[1]);
		}
		else {
			System.err.println("Mode incorrecte");
		}
		
	}
	
	
	protected static void escriureConfiguracioConsola(String fitxer){
		try{
			LectorConfiguracio l = new LectorConsola();
			l.llegirConfiguracio();
			Configuracio c = l.getConfiguracio();
			c.validar();
			EscriptorConfiguracio e = new EscriptorConfiguracio(c,fitxer);
			e.Escriure();
			System.out.println("Configuracio escrita amb exit");
		} catch (Exception e){
			System.err.println(e.toString());
		}
	}
	
	protected static void ordenarFotografies(String fitxerConfiguracio){
		try{
			LectorConfiguracio l = new LectorFitxer(fitxerConfiguracio);
			l.llegirConfiguracio();
			/* TODO: Logica de fotografies */
			Set<Fotografia> fotos = new HashSet<Fotografia>();
			for (String root: l.getConfiguracio().getOrigen()){
				ILector lector = FactoryLector.getInstance().obtenirLectorFotografies(l.getConfiguracio(), root);
				lector.llegir();
				fotos.addAll(lector.getResultat());
			}
			
			OrdenarFotografies o = new OrdenarFotografies(fotos,l.getConfiguracio().getDesti());
			o.ordenar();
			
		} catch (Exception e){
			System.err.println(e.toString());
		}
	}
	
	protected static void testFitxer(String fitxer){
		try{
			LectorConfiguracio l = new LectorFitxer(fitxer);
			l.llegirConfiguracio();
			System.out.println(l.getConfiguracio());
		} catch (Exception e){
			System.err.println(e.toString());
		}
	}
	
	
	
}
