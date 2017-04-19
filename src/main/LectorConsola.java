package main;

import javax.swing.JFileChooser;

public class LectorConsola extends LectorParametres {

	public LectorConsola(String fitxer){
		this.fitxer = fitxer;
		escullidor = new EscullidorCarpeta();
	}
	
	/* Fitxer on guardar la configuracio */
	protected String fitxer;
	
	/* Escullidor de carpeta, fer servir aixo per escollir carpetes */
	protected IEscullidorCarpeta escullidor;

	/* Llegir una configuracio per consola, els fitxers han de ser llegits utilitzant la interfície
	 */
	@Override
	protected Configuracio obtenirConfiguracio() {
		/* Escriure el teu codi aqui */
		
		/* Codi de prova per llegir 1 carpeta, pots executar amb el main de la classe Main */
		Configuracio ret = new Configuracio();
		try {
			/* Llegim una carpeta i la fiquem com a destí de la configuracio
			 * escullidor es un atribut de la classe LectorConsola, sempre disponible
			 */
			String carpeta = escullidor.triarCarpeta();
			ret.setDesti(carpeta);
		} catch (TriaCancelada | ErrorTria e) {
			/* Si succeeix un error imprimim el log */
			System.err.println(e.toString());
		}
		
		//EL TEU CODI AQUI, cal manipular ret fent servir un escaner i l'objecte escullidor
		/*
		 * Scanner in = new Scanner(System.in);
		 * String line = in.nextLine();
		 * while (condicio de sortida){
		 * 		Fer operacions
		 * 		Llegir la seguent linea
		 * }
		 */
		//FI DEL TEU CODI
		return ret;
	}
	
	
	
	
	
	/* Tot el que hi ha d'aqui en avall ja esta fet */
	protected interface IEscullidorCarpeta{
		public String triarCarpeta() throws TriaCancelada,ErrorTria;
	}
	
	private class TriaCancelada extends Exception{
		public String toString(){
			return "La tria ha estat cancelada";
		}
	}
	private class ErrorTria extends Exception{
		public String toString(){
			return "Error al triar el fitxer";
		}
	}
	protected class EscullidorCarpeta implements IEscullidorCarpeta{

		@Override
		public String triarCarpeta() throws TriaCancelada, ErrorTria {
			JFileChooser j = new JFileChooser();
			j.setDialogTitle("Tria un directori");
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int ret = j.showOpenDialog(null);
			if (ret == JFileChooser.CANCEL_OPTION) throw new TriaCancelada();
			else if (ret == JFileChooser.ERROR_OPTION) throw new ErrorTria();
			else return j.getSelectedFile().getAbsolutePath();
		}
		
	}
}
