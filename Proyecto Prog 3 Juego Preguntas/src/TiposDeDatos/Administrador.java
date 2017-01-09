package TiposDeDatos;

public class Administrador extends Persona{
	
	
	private String email;

	/**
	 * Constructor por defecto del Administrador
	 */
	public Administrador() {
		super();
	}

	/**
	 * Constructor con parametros del Administrador. 
	 * @param cod_user - Codigo del usuario
	 * @param user - Nombre del usuario 
	 * @param email - Email que debe inicializar.
	 * @param con - COntraseña del usuario
	 * @param tipoUser - Tipo de usuario que se crea. 
	 */
	public Administrador(int cod_user, String user, String email, String con, String tipoUser) {
		super(cod_user, user, con, tipoUser);
		this.email=email;
	}
	
	/**
	 * COnstructor con 2 parametros. 
	 * @param user - Nombre del usuario. 
	 * @param pass - COntraseña del usuario. 
	 */
	public Administrador(String user,String pass){
		super(user,pass,"admin");

	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
