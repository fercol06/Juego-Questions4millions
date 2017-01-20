package TiposDeDatos;

public class ConfiguracionJuego {

	private int dificultad; // 3 niveles de dificultad: 1- Baja; 2- Media; 3- Alta.
	private int numJugadores;
	private int segundosPreguntas; 
	private int numVidas; //Vidas inversas al nivel. // 3 Vidas, 2 Vidas, 1 vida, 0 vidas, -1 ha terminado
	
	/**
	 * Constructor de la configuración del juego con parametros
	 * @param dificultad
	 * @param numPreguntas
	 * @param segundosPreguntas
	 * @param numVidas
	 */
	public ConfiguracionJuego(int dificultad, int numJugadores, int segundosPreguntas) {
		this.dificultad = dificultad;
		this.numJugadores = numJugadores;
		this.segundosPreguntas = segundosPreguntas*1000;
		int vidas=0;
		switch(dificultad){
			case 1: vidas=3;break;
			case 2: vidas=2;break;
			case 3: vidas=1;break;
			default: vidas=0;
		}
		this.numVidas = vidas;
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
	public int getNumJugadores() {
		return numJugadores;
	}
	/**
	 * @return the minutosPreguntas
	 */
	public int getSegundosPreguntas() {
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
		String dif="";
		switch (dificultad) {
		case 1:
			dif="Fácil";
			break;
		case 2:
			dif="Media";
			break;
		case 3:
			dif="Dificil";
			break;
		default:
			dif="Media";
			break;
		}
		return (" Dificultad: "+dif
				+ "\n Número de Jugadores: "+(numJugadores)
				+ "\n Segundos Preguntas: "+segundosPreguntas/1000);
	}
	
}
