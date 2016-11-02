package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TiposDeDatos.Pregunta;
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
	 * Método para obtener preguntas
	 */
	public Pregunta obtenerPregunta(){
		Pregunta p=null;
		//Preparamos la query
		String query="SELECT * FROM preguntas"; 
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if(rs.next()) 
				p=new Pregunta(rs.getString("pregunta"),rs.getString("resp1"),rs.getString("resp2"),rs.getString("resp3"),rs.getString("resp4"),rs.getString("respOk"),rs.getInt("nivel"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Metodo para obtener Usuario
	 * @param dni
	 * @return
	 */
	
	/*public Usuario obtenerUsuarioAdmin(String nombre){
		String query;
		Usuario u=null;
		//Preparamos la query
		query="SELECT * FROM usuario WHERE user='"+nombre+"' AND tipo='admin'"; 
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
