package TiposDeDatos;

public class Persona {

	
	private int cod_user;
	private String user;
	private String con;
	private String tipoUser;
	
	/**
	 * Constructor sin parametros
	 */
	public Persona() {
		tipoUser="jugador";
	}

	/**
	 * @param cod_user
	 * @param user
	 * @param con
	 * @param tipoUser
	 */
	public Persona(int cod_user, String user, String con, String tipoUser) {
		this.cod_user = cod_user;
		this.user = user;
		this.con = con;
		this.tipoUser = tipoUser;
	}
	public Persona (String user, String con, String tipoUser){
		this.user = user;
		this.con = con;
		this.tipoUser = tipoUser;
	}
	public Persona(String user) {
		//Para meter solo un nombre
		this.user = user;
	}

	/**
	 * @return the cod_user
	 */
	public int getCod_user() {
		return cod_user;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the con
	 */
	public String getCon() {
		return con;
	}

	/**
	 * @return the tipoUser
	 */
	public String getTipoUser() {
		return tipoUser;
	}

	/**
	 * @param cod_user the cod_user to set
	 */
	public void setCod_user(int cod_user) {
		this.cod_user = cod_user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(String con) {
		this.con = con;
	}

	/**
	 * @param tipoUser the tipoUser to set
	 */
	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	
	
}
