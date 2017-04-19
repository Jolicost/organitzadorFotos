package main;

public class Main {

	public static void main (String[] argv) {
		LectorParametres l = new LectorConsola("fitxer.txt");
		l.llegirConfiguracio();
		System.out.println(l.getConfiguracio());
	}
	
}
