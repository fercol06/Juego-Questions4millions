package TiposDeDatos;

public class ConfiguracionJuego {

	private int dificultad; // 3 niveles de dificultad: 1- Baja; 2- Media; 3- Alta.
	private int numJugadores;
	private int segundosPreguntas; 
	private int numVidas;
	
	/**
	 * Constructor de la configuración del juego con parametros
	 * @param dificultad
	 * @param numPreguntas
	 * @param segundosPreguntas
	 * @param numVidas
	 */
	public ConfiguracionJuego(int dificultad, int numPreguntas, int minutosPreguntas) {
		this.dificultad = dificultad;
		this.numJugadores = numPreguntas;
		this.segundosPreguntas = minutosPreguntas;
		numVidas = dificultad;
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
		return dificultad*2/100;
	}
	/**
	 * @return the numPreguntas
	 */
	public int getNumJugadores() {
		return 2+ numJugadores*4/100;
	}
	/**
	 * @return the minutosPreguntas
	 */
	public int getMinutosPreguntas() {
		return segundosPreguntas;
	}
	/**
	 * @return the numVidas
	 */
	public int getNumVidas() {
		return numVidas;
	}
	
	@Override
	public String toString(){
		return (" Dificultad: "+dificultad*2/100
				+ "\n Numero de Jugadores: "+(2 +numJugadores*4/100)
				+ "\n Segundos Preguntas: "+(20 + segundosPreguntas*40/100));
	}
	
}
