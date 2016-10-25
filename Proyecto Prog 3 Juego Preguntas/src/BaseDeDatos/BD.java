package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TiposDeDatos.Usuario;

public class BD {
	
	private Connection con;
	private static Statement stmt;
	
	/**
	 * Metodo que crea una sentencia para acceder a la base de datos 
	 */
	public void crearSentencia()
	{
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo establecer la conexión a la base de datos
	 */

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:Q4M.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para cerrar una sentencia 
	 */
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para desconectarse de la base de datos
	 */
	public void desconectar()
	{
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Constructor de la base de datos. Se establece la conexión dentro.
	 */
	
	public BD(){
		conectar();
	}
	
	/**
	 * Metodo para obtener Usuario
	 * @param dni
	 * @return
	 */
	
	/*public Usuario obtenerCliente(String dni){
		String query;
		Usuario u=null;
		//Preparamos la query
		query="SELECT * FROM usuario WHERE dni='"+dni+"'"; 
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if(rs.next()) 
				u=new Usuario(rs.getString("dni"),rs.getString("nombre"),rs.getInt("edad"),rs.getString("contrasenia"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	 */



}
