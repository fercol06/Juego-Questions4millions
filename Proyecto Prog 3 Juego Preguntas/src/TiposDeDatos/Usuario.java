package TiposDeDatos;

public class Usuario {
	
	private String user;
	private String email;
	private String con;
	private static int record;
	
	
	/**
	 * Contructor con parametros
	 * @param user
	 * @param email
	 * @param con
	 */
	
	public Usuario(String user, String email, String con) {
		this.user = user;
		this.email = email;
		this.con = con;
	}
	/**
	 * Contructor sin parametros
	 */
	
	public Usuario() {
		
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
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
	/**
	 * @return the con
	 */
	public String getCon() {
		return con;
	}
	/**
	 * @param con the con to set
	 */
	public void setCon(String con) {
		this.con = con;
	}
	/**
	 * @return the record
	 */
	public static int getRecord() {
		return record;
	}
	/**
	 * @param record the record to set
	 */
	public static void setRecord(int record) {
		Usuario.record = record;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", email=" + email + ", con=" + con + "]";
	}
	

}
