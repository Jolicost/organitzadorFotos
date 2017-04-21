package main;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class LectorFitxer extends LectorConfiguracio {

	public LectorFitxer(String fitxer){
		this.fitxer = fitxer;
	}
	
	protected String fitxer;
	@Override
	protected Configuracio obtenirConfiguracio() throws Exception {
		String json = FileUtils.readFileToString(new File(fitxer), Charset.defaultCharset().displayName());
		Configuracio ret = Configuracio.fromJson(json);
		return ret;
	}

}
