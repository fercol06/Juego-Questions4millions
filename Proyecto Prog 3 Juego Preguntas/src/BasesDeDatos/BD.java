package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TiposDeDatos.Pregunta;
import TiposDeDatos.Usuario;

public class BD {

	private Connection con;
	private static Statement stmt;

	/**
	 * Metodo que crea una sentencia para acceder a la base de datos
	 */
	public void crearSentencia() {
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

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Q4M.db");
			crearSentencia();
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para cerrar una sentencia
	 */
	public void cerrarSentencia() {
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
	public void desconectar() {
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

	public BD() {
		conectar();
	}

	/////////////////////////////////////////////////////////////////
	////////////			Metodos con datos			////////////
	/////////////////////////////////////////////////////////////////
	
	////////////// METODOS PREGUNTAS	///////////
	
	
	
	/**
	 * Método para obtener preguntas
	 */
	public ArrayList<Pregunta> obtenerPregunta() {
		Pregunta p = null;
		ArrayList<Pregunta> aP = new ArrayList<>();
		// Preparamos la query
		String query = "SELECT * FROM preguntas";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Comprobamos si ha devuelto filas
				p = new Pregunta(rs.getInt("cod_pr"),rs.getString("pregunta"), rs.getString("resp1"), rs.getString("resp2"),
						rs.getString("resp3"), rs.getString("resp4"), rs.getString("respOk"), rs.getInt("nivel"));
				aP.add(p);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aP;
	}

	/**
	 * Método para añadir una pregunta a la BD
	 */
	public void aniadirPregunta(Pregunta p) {

		/*
		 * Preparamos la query
		 * CUIDADO con cod_pr que es autoincremental
		 * @param pregunta
		 * @param resp1
		 * @param resp2
		 * @param resp3
		 * @param resp4
		 * @param respCorrecta
		 * @param nivel
		 */
		String query = "INSERT INTO preguntas (pregunta,resp1,resp2,resp3,resp4,respOk,nivel) VALUES ('"
				+ p.getPregunta() + "','" + p.getResp1() + "','" + p.getResp2() + "','" + p.getResp3() + "','"
				+ p.getResp4() + "','" + p.getRespCorrecta() + "'," + p.getNivel() + ")";
		try {
			//System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para borrar una pregunta a la BD
	 */
	public void borrarPregunta(Pregunta p) {
		
		String query = "DELETE FROM preguntas WHERE pregunta='"+ p.getPregunta() +"'";
		try {
			//System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que recive una pregunta y edita la pregunta en la base de datos
	 * gracias a su cod_pr
	 * @param p - Objeto pregunta
	 */
	public void editarPregunta(Pregunta p){
		String query = "UPDATE preguntas SET "+
				"pregunta ='"+p.getPregunta() + "', " +
				"resp1 ='"+p.getResp1()+ "', " +
				"resp2 ='"+p.getResp2()+ "', " +
				"resp3 ='"+p.getResp3()+ "', " +
				"resp4 ='"+p.getResp4()+ "', " +
				"respOk ='"+p.getRespCorrecta()+ "', " +
				"nivel ="+p.getNivel()+ " " +
				"WHERE cod_pr="+p.getCod_pr();
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
	
	/**
	 * Metodo que crea las tablas de la base de datos. 
	 * @return Devuelve un true si se ha ejecutado correctamente
	 */
	public boolean crearTablas(){
		//Revisar autoincrement
		String queryP = "CREATE TABLE preguntas (cod_pr INTEGER PRIMARY KEY, pregunta string, resp1 string, resp2 string, resp3 string, resp4 string, respOk string, nivel integer)";
		String queryU = "CREATE TABLE usuario (cod_usr INTEGER PRIMARY KEY, user string, email string, pass string, record string, tipo string)";
		try {
			stmt.executeUpdate(queryU);
			stmt.executeUpdate(queryP);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	/**
	 * Metodo que borra las tablas de la base de datos si existe. 
	 * @return Devuelve un true si se ha ejecutado correctamente.
	 */
	public boolean BorrarTablas(){ 
		String queryP = "DROP TABLE if exists preguntas";
		String queryU = "DROP TABLE if exists usuario";
		try {
			stmt.executeUpdate(queryU);
			stmt.executeUpdate(queryP);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	

	//////////////	METODOS USUARIOS	///////////
	
	
	/**
	 * Método para obtener el objeto Usuario admin del que le hemos pasado el nombre.
	 * En este caso utilizamos para el login.
	 * 
	 * @param String nombre - Le pasamos un 'nombre' con el usuario a buscar en la base de datos.
	 * @return Usuario u - Nos devuelve el objeto usuario que habiamos consultado.
	 */
	public Usuario obtenerUsuarioAdmin(String nombre) {
		String query;
		Usuario u = null;
		// Preparamos la query
		query = "SELECT * FROM usuario WHERE user='" + nombre + "' AND tipo='admin'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next())
				u = new Usuario(rs.getInt("cod_usr"), rs.getString("user"), rs.getString("email"), rs.getString("pass"), rs.getInt("record"),
						rs.getString("tipo"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * Metodo que devuelve la lista completa de usuarios con sus puntuaciones.
	 * @return ArrayList<Usuario> aU - Devuelve un arraylist de usuarios con sus datos para poder crear la tabla de marcadores.
	 */
	public ArrayList<Usuario> obtenerUsuarioPuntuacion (){
		Usuario u=null;
		ArrayList<Usuario> aU=new ArrayList<>();
		String query = "SELECT * FROM usuarios";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Comprobamos si ha devuelto filas
				u = new Usuario(rs.getInt("cod_usr"), rs.getString("user"), rs.getString("email"), rs.getString("pass"), rs.getInt("record"),
						rs.getString("tipo"));
				aU.add(u);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aU;
	}
	
	/**
	 * Metodo que comprueba si hay un usuario administrador en la base de datos. 
	 * @return boolean - Devuelve 'true' si hay administrador en la Base de datos y 'false' si no hay.
	 */
	public boolean hayAdmin(){
		String query = "SELECT user FROM usuario WHERE tipo='admin'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next()){
				rs.close();
				return true; //hay admin
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //no hay admin
	}
	
	/**
	 * Metodo que se le pasa un usuario de tipo usuario para crear un administrador en la base de datos
	 * @param u - Se le pasa un objeto de tipo usuario. 
	 */
	public void insertarAdmin(Usuario u){
		
		String query = "INSERT INTO usuario (user,email,pass,record,tipo) VALUES ('"
				+ u.getUser() + "','" + u.getEmail() + "','" + u.getCon() + "'," + u.getRecord() + ",'"
				+ u.getTipoUser() + "')";
		try {
			//System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
