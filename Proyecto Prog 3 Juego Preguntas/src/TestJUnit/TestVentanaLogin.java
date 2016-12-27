package TestJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Ventanas.VentanaLogin;

public class TestVentanaLogin {

	public VentanaLogin vl; 
	
	
	//Crear ventana
	protected void setUp(){
		vl=new VentanaLogin(true);
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	

}
