package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {

	public static ArrayList<String> leerDatos(String nombre) {
		try {
			ArrayList<String> lineas = new ArrayList<String>(); 
			BufferedReader br = new BufferedReader(new FileReader(nombre));
			String linea;
			while((linea=br.readLine()) != null) {
				lineas.add(linea);
			}			
			br.close();
			return lineas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
