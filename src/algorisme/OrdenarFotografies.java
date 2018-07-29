package algorisme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import model.Fotografia;
import model.NovaFotografia;

public class OrdenarFotografies {

	
	/* Llistes d'entrada i sortida, cada una conte les fotografies que es volen ordenar
	 * i les ja ordenades, respectivament */
	private Set<Fotografia> entrada;
	private String path;
	private List<NovaFotografia> sortida;
	
	public OrdenarFotografies(Set<Fotografia> entrada,String path){
		this.entrada = entrada;
		sortida = new ArrayList<NovaFotografia>();
		this.path = path;
	}
	
	public void ordenar(){
		crearNovesFotografies();
		DeteccioDuplicats d = new DeteccioDuplicats(sortida);
		d.tractarDuplicats();
		moureFotografies();
		
	}
	
	protected void crearNovesFotografies(){
		for (Fotografia f : entrada){
			NovaFotografia n = new NovaFotografia(f,path);
			sortida.add(n);
		}
	}


	protected void moureFotografies(){
		for (NovaFotografia nf : sortida){
			try{
				nf.moureFitxer();
			}
			catch(Exception e){
				System.err.println("No s'ha pogut moure el fitxer");
			}
		}
	}
	
}
