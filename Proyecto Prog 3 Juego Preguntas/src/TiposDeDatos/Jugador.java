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
	public Jugador(int cod_user, String user, String con,int record, String tipoUser) {
		super(cod_user, user, con, tipoUser);
		this.record=record;
	}
	public Jugador (String user){
		super(user);
	}
	

}
