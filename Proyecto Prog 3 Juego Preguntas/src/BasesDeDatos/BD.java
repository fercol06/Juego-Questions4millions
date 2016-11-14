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
	 * Metodo establecer la conexi�n a la base de datos
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
	 * Constructor de la base de datos. Se establece la conexi�n dentro.
	 */

	public BD() {
		conectar();
	}

	/////////////////////////////////////////////////////////////////
	////////////			Metodos con datos			////////////
	/////////////////////////////////////////////////////////////////
	
	//////////////METODOS PREGUNTAS	///////////
	
	/**
	 * M�todo para obtener preguntas
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
	 * M�todo para a�adir pregunta
	 */
	public void aniadirPregunta(Pregunta p) {

		/*
		 * Preparamos la query
		 * CUIDADO con el cod_pr que es autoincremental
		 * @param pregunta
		 * @param resp1
		 * @param resp2
		 * @param resp3
		 * @param resp4
		 * @param respCorrecta
		 * @param nivel
		 */
		String query = "INSERT INTO preguntas (pregunta,resp1,resp2,resp3,resp4,respOk,nivel) VALUES ('"
				+ p.getPregunta() + "','" + p.getResp1() + "'," + p.getResp2() + ",'" + p.getResp3() + ",'"
				+ p.getResp4() + "','" + p.getRespCorrecta() + ",'" + p.getNivel() + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//////////////	METODOS USUARIOS	///////////
	
	
	/**
	 * M�todo para obtener Usuario Admin
	 * 
	 * @param dni
	 * @return
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

}
