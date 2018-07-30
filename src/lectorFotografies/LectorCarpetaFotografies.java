package lectorFotografies;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import model.Fotografia;

public class LectorCarpetaFotografies implements ILector {

	
	protected String folder;
	
	protected Set<Fotografia> resultat;
	
	
	public Set<Fotografia> getResultat(){
		return this.resultat;
	}
	
	public LectorCarpetaFotografies(String folder){
		this.folder = folder;
	}
	
	private static Pattern p = Pattern.compile("^(?:jpg|bmp|png)$",Pattern.CASE_INSENSITIVE);
	
	private static boolean imageExtension(String extension){
		Matcher m = p.matcher(extension);
		return m.matches();
	}
	
	public void llegir(){
		resultat = new HashSet<Fotografia>();
		for (File f :
			(List<File>) FileUtils.listFiles(new File(folder), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)){
			if (LectorCarpetaFotografies.imageExtension(FilenameUtils.getExtension(f.getName()))){
				resultat.add(new Fotografia(f));
			}
		}
		
		
	}
}
