package TestJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import BasesDeDatos.BD;
import TiposDeDatos.Pregunta;
import junit.framework.TestCase;

public class TestBD extends TestCase{
	
	BD bd;
	
	/**
	 * Méetodo que inicializa el test JUnit con la conexión de la Base de datos. 
	 */
	public void setUp(){
		bd=new BD();
	}
	
	/**
	 * Test que comprueba que se añaden preguntas. 
	 */
	@Test
	public void testAniadirPregunta() {	
		bd.aniadirPregunta(new Pregunta("P","a","b","c","d","a",1));
		assertEquals(true, bd.hayPreguntas());	
	}
	
	/**
	 * Test que comprueba si hay pregunatas. 
	 */
	@Test
	public void testhayPreguntas() {	
		assertEquals(true, bd.hayPreguntas());	
	}

}
