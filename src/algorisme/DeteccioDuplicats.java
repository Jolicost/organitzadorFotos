package algorisme;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.NovaFotografia;

public class DeteccioDuplicats {

	public DeteccioDuplicats(List<NovaFotografia> fotos){
		this.fotos = fotos;
	}
	
	
	private List<NovaFotografia> fotos;
	private Map<String,Set<NovaFotografia>> mapa;

	public void tractarDuplicats() {
		obtenirDuplicats();
		renombrarDuplicats();
	}
	
	protected void afegirFotoMapa(NovaFotografia f){
		if (mapa.containsKey(f.getNomFinal())){
			mapa.get(f.getNomFinal()).add(f);
		}
		else{
			Set<NovaFotografia> grup = new HashSet<NovaFotografia>();
			grup.add(f);
			mapa.put(f.getNomFinal(),grup);
		}
	}
	
	protected void obtenirDuplicats(){
		mapa = new HashMap<String, Set<NovaFotografia>>();
		for (NovaFotografia f:fotos){
			afegirFotoMapa(f);
		}
	}
	
	protected void renombrarDuplicats(){
		for (Set<NovaFotografia> grup : mapa.values()){
			if (grup.size() > 1){
				int i = 1;
				for (NovaFotografia f:grup){
					f.setNouNom(f.getNouNom() + " " + i);
					i++;
				}
			}
		}
	}
}
