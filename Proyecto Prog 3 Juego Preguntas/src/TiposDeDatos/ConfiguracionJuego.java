package TiposDeDatos;

public class ConfiguracionJuego {

	private int dificultad; // 3 niveles de dificultad: 1- Baja; 2- Media; 3- Alta.
	private int numPreguntas;
	private int minutosPreguntas; 
	private int numVidas;
	
	/**
	 * Constructor de la configuración del juego con parametros
	 * @param dificultad
	 * @param numPreguntas
	 * @param minutosPreguntas
	 * @param numVidas
	 */
	public ConfiguracionJuego(int dificultad, int numPreguntas, int minutosPreguntas, int numVidas) {
		this.dificultad = dificultad;
		this.numPreguntas = numPreguntas;
		this.minutosPreguntas = minutosPreguntas;
		this.numVidas = numVidas;
	}
	/**
	 * Constructor sin parametros de la configuracion del juego.
	 */
	public ConfiguracionJuego(){

	}
	/**
	 * @return the dificultad
	 */
	public int getDificultad() {
		return dificultad;
	}
	/**
	 * @return the numPreguntas
	 */
	public int getNumPreguntas() {
		return numPreguntas;
	}
	/**
	 * @return the minutosPreguntas
	 */
	public int getMinutosPreguntas() {
		return minutosPreguntas;
	}
	/**
	 * @return the numVidas
	 */
	public int getNumVidas() {
		return numVidas;
	}
	
	
}
