package main;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class EscriptorConfiguracio {
	
	public EscriptorConfiguracio(Configuracio conf,String fitxer){
		this.escriure = conf;
		this.fitxer = fitxer;
	}
	
	private Configuracio escriure;
	private String fitxer;
	
	public void Escriure() throws Exception {
		FileUtils.writeStringToFile(new File(fitxer), escriure.toJson(), Charset.defaultCharset().displayName());
	}
}
