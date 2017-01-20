package TiposDeDatos;

public class Jugador extends Persona{
	
	private int record;

	/**
	 * Constructor por defecto.
	 */
	public Jugador() {
		super();
	}

	/**
	 * Constructor con parametros del Jugador. 
	 * @param cod_user - Codigo de usuario. 
	 * @param user - Nombre del usuario. 
	 * @param con - Contraseña del usuario.
	 * @param tipoUser - Tipo del usuario.
	 */
	public Jugador(int cod_user, String user, String con,int record) {
		super(cod_user, user, con, "jugador");
		this.record=record;
	}
	
	/**
	 * Constructor del obeto jugador con un parametro. 
	 * @param user - Nombre del usuario. 
	 */
	public Jugador (String user){
		super(user,"jugador");
	}
	
	/**
	 * @return the record
	 */
	public int getRecord() {
		return record;
	}

	/**
	 * CUIDADO CON ESTE SET RECORD. SUMA
	 * @param record the record to set
	 */
	public void setRecord(int record) {
		this.record =this.record + record;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+record;
	}

	

	
	

}
