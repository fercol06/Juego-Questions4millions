package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TiposDeDatos.Administrador;
import TiposDeDatos.Jugador;
import TiposDeDatos.Pregunta;


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
	
	////////////////	Metodos generales tablas	/////////////////
	
	/**
	 * Metodo que crea las tablas de la base de datos. 
	 * @return Devuelve un true si se ha ejecutado correctamente
	 */
	public boolean crearTablas(){
		//INTEGER AUTOINCREMENT
		//https://www.tutorialspoint.com/sqlite/sqlite_using_autoincrement.htm
		String queryP = "CREATE TABLE preguntas (cod_pr INTEGER PRIMARY KEY, pregunta string, resp1 string, resp2 string, resp3 string, resp4 string, respOk string, nivel integer)";
		String queryU = "CREATE TABLE usuario (cod_usr INTEGER PRIMARY KEY, user string, email string, pass string, record string, tipo string)";
		String queryR = "CREATE TABLE preguntasUsuario (user string, pregunta string, acertado string)";
		try {
			stmt.executeUpdate(queryU);
			stmt.executeUpdate(queryP);
			stmt.executeUpdate(queryR);
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
		String queryR = "DROP TABLE if exists preguntasUsuario";
		try {
			stmt.executeUpdate(queryU);
			stmt.executeUpdate(queryP);
			stmt.executeUpdate(queryR);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	
	////////////// METODOS TABLA PREGUNTAS	///////////
	
	/**
	 * Metodo que comprueba si hay preguntas en la base de datos.
	 * @return Devuelve un true si hay preguntas en la BD.
	 */
	public boolean hayPreguntas(){
		String query = "SELECT * FROM preguntas";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next()){
				rs.close();
				return true; //hay preguntas
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //no hay preguntas
	}
	
	
	
	/**
	 * Método para obtener preguntas
	 */
	public ArrayList<Pregunta> obtenerPreguntas() {
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
	 * Metodo que le pasamos un arrayList de preguntas, lo recorremos y vamos llamando a la funcion
	 * aniadirPregunta para que las vaya añadiendo a la base de datos.
	 * @param aP -ArrayList de tipo preguntas que recibimos.
	 */
	public void aniadirArrayPreguntas(ArrayList<Pregunta> aP){
		
		for(Pregunta p: aP){	
			aniadirPregunta(p);
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
	 * Nos devuelve el numero de preguntas de la BD
	 * @return
	 */
	/*public int numPreguntas(){
		int num=0;
		String query ="SELECT * FROM preguntas";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				num++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}*/
	
	/**
	 * Método que obtiene una pregunta aleatoria de la base de datos
	 * @return pregunta - Objeto Pregunta.
	 */
	/*public Pregunta obtenerPreguntaAleatoria(){
		Pregunta p=null;
		ArrayList<Pregunta> aP;
		
		//obtenemos todas las preguntas en arrayList
		aP=obtenerPreguntas();
		
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		int numAleatorio= rnd.nextInt(aP.size()-1);
		
		p=aP.get(numAleatorio);
		
		return p;
	}
*/
	

	//////////////	METODOS TABLA USUARIOS	///////////
	
	
	/**
	 * Metodo que obtiene el objeto usuario administrador de la Base De Datos
	 * @param nombre - Nombre del administrador
	 * @return Administrador- Devuelve un objeto administrador
	 */
	public Administrador obtenerUsuarioAdmin(String nombre) {
		String query;
		Administrador u = null;
		// Preparamos la query
		query = "SELECT * FROM usuario WHERE user='" + nombre + "' AND tipo='admin'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next())
				u = new Administrador(rs.getInt("cod_usr"), rs.getString("user"), rs.getString("email"), rs.getString("pass"),
						rs.getString("tipo"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * Metodo que obtiene todos los usuarios de la base de datos y los devuelve en un arra list.
	 * @return ArrayList <Jugador>
	 */
	public ArrayList<Jugador> obtenerUsuarios (){
		Jugador u=null;
		ArrayList<Jugador> aU=new ArrayList<Jugador>();
		String query = "SELECT * FROM usuario";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Comprobamos si ha devuelto filas
				u = new Jugador(rs.getInt("cod_usr"), rs.getString("user"), rs.getString("pass"), rs.getInt("record"));
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
	 * Metodo que inserta un administrador en la base de datos. 
	 * @param u
	 */
	public void insertarAdmin(Administrador u){
		
		String query = "INSERT INTO usuario (user,email,pass,record,tipo) VALUES ('"
				+ u.getUser() + "','" + u.getEmail() + "','" + u.getCon() + "', 0" +", '"
				+ u.getTipoUser() + "')";
		try {
			//System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que comprueba si un usuario está en la base de datos. Para ello hay que pasarle el nombre del usuario.
	 * @param jugador - String del nombre del usuario.
	 * @return true - si está en la Base de Datos, false si no esta.
	 */
	public boolean comprobarUsuario(Jugador jugador){
		String query = "SELECT * FROM usuario WHERE user='"+jugador.getUser()+"' AND tipo='jugador'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next()){
				rs.close();
				return true; //Esta jugador
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //no está jugador
	}
	
	/**
	 * Método que borra un usuario de la Base de datos
	 * @param jug - Le pasamos un obeto Jugador con su nombre. 
	 */
	public void borrarUsuario(Jugador jug){
		String query="DELETE FROM usuario WHERE user='"+jug.getUser()+"'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que inserta un usuario en la base de datos. Se le pasa un obeto jugador y lo añade. 
	 * @param j - Objeto jugador a añadir en la base de datos. 
	 */
	public void insertarUsuario(Jugador j){
		
		String query = "INSERT INTO usuario (user,email,pass,record,tipo) VALUES ('"
				+ j.getUser() + "','" + null + "','" + null + "',"+j.getRecord()+ ",'"
				+ j.getTipoUser() + "')";
		try {
			//System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Método que obtiene un jugador de la Base de datos. 
	 * @param jugador - Le pasamos un obejto Jugador
	 * @return Devuelve un Jugador completo
	 */
	public Jugador ObtenerUsuario(Jugador jugador){
		Jugador j=null;
		String query = "SELECT * FROM usuario WHERE user='"+jugador.getUser()+"' AND tipo='jugador'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			// Comprobamos si ha devuelto filas
			if (rs.next()) {
				// Comprobamos si ha devuelto filas
				j = new Jugador(rs.getInt("cod_usr"), rs.getString("user"), rs.getString("pass"), rs.getInt("record"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}
	
	
	
	
	//////////////	METODOS TABLA PREGUNTAS USUARIO	///////////
	
	/**
	 * Metodo que inserta una pregunta que se le ha hecho a un usuario.
	 * @param j - Obeto jugador
	 * @param p - Objeto Pregunta
	 * @param acertado - Booleano si que marca si ha acertado o no. 
	 */
	public void inertarPreguntaContestada (Jugador j, Pregunta p, boolean acertado){
		
		String query = "INSERT INTO preguntasUsuario (user, pregunta, acertado) VALUES ('"
				+ j.getUser() + "','" + p.getPregunta() + "','" + acertado + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que comprueba si a un jugador se le ha hecho una prgunta
	 * @param p - Pregunta
	 * @param j - Jugador
 	 * @return true si se le ha hecho la pregunta
	 */
	public boolean comprobarPregunta(Pregunta p, Jugador j){

		String query = "SELECT * FROM preguntasUsuario WHERE pregunta='"+p.getPregunta()+"' AND user='" +j.getUser()+"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				rs.close();
				return true; //se ha dicho la pregunta al user
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
