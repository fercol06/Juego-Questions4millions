package TestJUnit;

import org.junit.Test;

import BasesDeDatos.BD;
import TiposDeDatos.Administrador;
import TiposDeDatos.Jugador;
import TiposDeDatos.Pregunta;
import junit.framework.TestCase;

public class TestBD extends TestCase{
	
	
	private static BD bd;
	private Pregunta nuevaPregunta;
	private Jugador nuevoJugador;
	private Administrador nuevoAdministrador;
	
	/**
	 * Méetodo que inicializa el test JUnit con la conexión de la Base de datos. 
	 */
	@Override
	public void setUp(){
		bd=new BD();
		nuevaPregunta = new Pregunta("P","a","b","c","d","a",1);
		nuevoJugador = new Jugador ("Pepe");
		nuevoAdministrador = new Administrador("admin","admin");
	}
	
	/**
	 * Test que comprueba que se añaden preguntas.
	 */
	@Test
	public void testAniadirPregunta() {	
		bd.aniadirPregunta(nuevaPregunta);
		assertEquals(true, bd.hayPreguntas());	
	}
	
	/**
	 * Comprueba si se inserta un usuario
	 */
	@Test
	public void testInsertarUser() {	
		bd.insertarUsuario(nuevoJugador);
		assertEquals(true, bd.comprobarUsuario(new Jugador("pepe")));
	}
	
	
	/**
	 * Test que comprueba si hay pregunatas.
	 */
	@Test
	public void testhayPreguntas() {	
		assertEquals(true, bd.hayPreguntas());	
	}
	
	/**
	 * Test que comprueba si se añade admin. 
	 */
	@Test
	public void testAniadeAdmin() {
		bd.insertarAdmin(nuevoAdministrador);
		assertEquals(true, bd.hayAdmin());	
	}
	
	/**
	 * Metodo para eliminar objetos
	 */
	@Override
	public void tearDown(){
		bd.borrarPregunta(nuevaPregunta);
		bd.borrarUsuario(nuevoJugador);
		nuevoJugador=new Jugador(nuevoAdministrador.getUser());
		bd.borrarUsuario(nuevoJugador);
	}
	
}
