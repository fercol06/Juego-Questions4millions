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
	 * Constructor con paramtros de obejto Persona. 
	 * @param cod_user - Código persona.
	 * @param user - Nombre de la persona.
	 * @param con - Contraseña de la persona.
	 * @param tipoUser - Tipo de usuario a crear. 
	 */
	public Persona(int cod_user, String user, String con, String tipoUser) {
		this.cod_user = cod_user;
		this.user = user;
		this.con = con;
		this.tipoUser = tipoUser;
	}
	
	/**
	 * Constructor con 3 parametros. Inicaializa el nombre de usuario, la contraseña y el tipo de usuario. 
	 * @param user - Nombre de la persona.
	 * @param con - Contraseña de la Persona.
	 * @param tipoUser - Tipo de usuario de la persona. 
	 */
	public Persona (String user, String con, String tipoUser){
		this.user = user;
		this.con = con;
		this.tipoUser = tipoUser;
	}
	/**
	 * Constructor con 2 parametros que inicializa el nombre del jugador y el tipo de usuario. 
	 * @param user - Nombre de la persona. 
	 * @param tipoUser - Tipo de usuario de la persona. 
	 */
	public Persona(String user, String tipoUser) {
		//Para meter solo un nombre
		this.user = user;
		this.tipoUser= tipoUser;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [cod_user=" + cod_user + ", user=" + user + ", tipoUser=" + tipoUser + "]";
	}
	
	
}
