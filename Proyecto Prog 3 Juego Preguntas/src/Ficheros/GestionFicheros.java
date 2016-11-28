package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import TiposDeDatos.Pregunta;

public class GestionFicheros {
	
	public static ArrayList<Pregunta> leerFichero(String fichero){
		Pregunta p = null;
		ArrayList<Pregunta> aP=new ArrayList<Pregunta>();
		try {
		      FileReader fr = new FileReader(fichero);
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;
		      while((linea = br.readLine()) != null){
		    	  p.setPregunta(linea.trim());
		    	  
		    	  //leo las respuestas quitando los espacios en blanco
		    	  linea = br.readLine();
		    	  p.setResp1(linea.trim());
		    	  linea = br.readLine();
		    	  p.setResp2(linea.trim());
		    	  linea = br.readLine();
		    	  p.setResp3(linea.trim());
		    	  linea = br.readLine();
		    	  p.setResp4(linea.trim());
		    	  linea = br.readLine();
		    	  p.setRespCorrecta(linea.trim());
		    	  linea = br.readLine();
		    	  p.setNivel(Integer.parseInt(linea.trim()));
		    	  
		    	  //meto arrayList
		    	  aP.add(p);
		      }
		 
		      fr.close();
		    }
		    catch(Exception e) {
		      e.printStackTrace();
		    }
		return aP;
	}

}
