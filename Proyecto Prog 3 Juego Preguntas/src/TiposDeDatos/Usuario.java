package TiposDeDatos;

public class Usuario {
	
	private String user;
	private String email;
	private String con;
	private int record;
	private String tipoUser; //1-admin ;  2-user
	
	
	/**
	 * Contructor con parametros
	 * @param user
	 * @param email
	 * @param con
	 * @param record
	 * @param tipoUser
	 */
	
	public Usuario(String user, String email, String con, int record, String tipouser) {
		this.user = user;
		this.email = email;
		this.con = con;
		this.record = record;
		this.tipoUser = tipouser;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the con
	 */
	public String getCon() {
		return con;
	}
	/**
	 * @return the record
	 */
	public int getRecord() {
		return record;
	}
	/**
	 * @return the tipoUser
	 */
	public String getTipoUser() {
		return tipoUser;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param con the con to set
	 */
	public void setCon(String con) {
		this.con = con;
	}
	/**
	 * @param record the record to set
	 */
	public void setRecord(int record) {
		this.record = record;
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
		return "Usuario [user=" + user + ", email=" + email + ", con=" + con + ", record=" + record + ", tipoUser="
				+ tipoUser + "]";
	}
	

}
