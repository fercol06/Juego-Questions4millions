package TiposDeDatos;

public class Administrador extends Persona{
	
	
	private String email;

	/**
	 * 
	 */
	public Administrador() {
		super();
	}

	/**
	 * @param cod_user
	 * @param user
	 * @param con
	 * @param tipoUser
	 */
	public Administrador(int cod_user, String user, String email, String con, String tipoUser) {
		super(cod_user, user, con, tipoUser);
		this.email=email;
	}
	
	
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
