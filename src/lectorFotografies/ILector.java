package lectorFotografies;

import java.util.Set;

import model.Fotografia;

public interface ILector {

	public void llegir();
	
	public Set<Fotografia> getResultat();
}
