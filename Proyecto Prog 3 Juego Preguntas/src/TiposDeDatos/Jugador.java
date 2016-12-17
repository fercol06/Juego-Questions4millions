package TiposDeDatos;

public class Jugador extends Persona{
	
	private int record;

	/**
	 * 
	 */
	public Jugador() {
		super();
	}

	/**
	 * @param cod_user
	 * @param user
	 * @param con
	 * @param tipoUser
	 */
	public Jugador(int cod_user, String user, String con,int record) {
		super(cod_user, user, con, "jugador");
		this.record=record;
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

	public Jugador (String user){
		super(user);
	}
	

}
