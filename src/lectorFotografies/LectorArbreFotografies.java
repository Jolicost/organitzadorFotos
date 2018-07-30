package lectorFotografies;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import model.Fotografia;

public class LectorArbreFotografies extends LectorCarpetaFotografies{

	public LectorArbreFotografies(String folder) {
		super(folder);
		// TODO Auto-generated constructor stub
	}

	public void llegir(){
		super.llegir();
		File carp = new File(super.folder);
		File[] subdirs = carp.listFiles((FileFilter) DirectoryFileFilter.INSTANCE);
		for (File f : subdirs) {
			LectorArbreFotografies l = new LectorArbreFotografies(f.getAbsolutePath());
			l.llegir();
			super.resultat.addAll(l.getResultat());
		}
	
	}
}
