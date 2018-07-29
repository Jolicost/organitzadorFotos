package main;

import java.awt.Component;
import java.awt.HeadlessException;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class LectorConsola extends LectorConfiguracio {

	public LectorConsola(){
		escullidor = new EscullidorCarpeta();
	}
	
	/* Escullidor de carpeta, fer servir aixo per escollir carpetes */
	protected IEscullidorCarpeta escullidor;

	/* Llegir una configuracio per consola, els fitxers han de ser llegits utilitzant la interf�cie
	 */
	@Override
	protected Configuracio obtenirConfiguracio() throws Exception {
	/* Escriure el teu codi aqui */
	
	/* Codi de prova per llegir 1 carpeta, pots executar amb el main de la classe Main */
	Configuracio ret = new Configuracio();
	
	//EL TEU CODI AQUI, cal manipular ret fent skmervir un escaner i l'objecte escullidor
	System.out.println("Entra una ordre: origen / desti / mode / ordena ");
	  
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();
	while (!(line.equals("finalitza"))){
		if (line.equals("origen")){
			ret.add(escullidor.triarCarpeta());
			System.out.println("Afegida una carpeta d'origen");
		}
		if (line.equals("desti")){
			ret.setDesti(escullidor.triarCarpeta());
			System.out.println("S'ha establert una carpeta de desti");
		}
		if (line.equals("mode")){
			System.out.println("carpeta unica / arbre carpetes");
			String lectura = in.nextLine(); 
			if (lectura.equals("carpeta unica")){
				Mode m = Mode.carpeta_unica;
				ret.setMode(m);
			}
			else{
				Mode m = Mode.arbre_carpetes;
				ret.setMode(m);
			}
		}
		System.out.println("Entra una ordre: origen / desti / mode / finalitza");
		line = in.nextLine();
	}
 
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

		public String triarCarpeta() throws TriaCancelada, ErrorTria {
			
			JFileChooser j = new MyChooser();
			j.setDialogTitle("Tria un directori");
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int ret = j.showDialog(null, "Triar carpeta");
			//int ret = j.showOpenDialog(d);
			if (ret == JFileChooser.CANCEL_OPTION) throw new TriaCancelada();
			else if (ret == JFileChooser.ERROR_OPTION) throw new ErrorTria();
			else return j.getSelectedFile().getAbsolutePath();
		}
		
	}
	
	static class MyChooser extends JFileChooser {
        protected JDialog createDialog(Component parent)
                throws HeadlessException {
            JDialog dlg = super.createDialog(parent);
            dlg.setAlwaysOnTop(true);
            return dlg;
        }
    }
}
