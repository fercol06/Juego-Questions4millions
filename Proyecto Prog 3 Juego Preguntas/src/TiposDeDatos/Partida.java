package TiposDeDatos;

import java.util.ArrayList;

public class Partida {

	

	private ConfiguracionJuego config;
	private ArrayList<Jugador> aUsuario;
	//ArrayList de vidas por sus metodos
	private ArrayList<Integer> aVidas;
	
	//NO porque hay que comprobar una tabla
	//private ArrayList<Pregunta> aPregunta;
	
	/**
	 * 
	 * @param config
	 * @param aUsuario
	 */
	public Partida(ConfiguracionJuego config, ArrayList<Jugador> aUsuario) {
		this.config = config;
		this.aUsuario = aUsuario;
		//Reservo tantas posiciones de un arrayVidas como usuarios participen. 
		aVidas = new ArrayList<Integer>(config.getNumJugadores());
		//Inicializo a las vidas designadas en configuracion
		for(int i=0; i<config.getNumJugadores(); i++){
			aVidas.add(config.getNumVidas());
		}
		
	}

	public ConfiguracionJuego getConfig() {
		return config;
	}

	public void setConfig(ConfiguracionJuego config) {
		this.config = config;
	}

	public ArrayList<Jugador> getaUsuario() {
		return aUsuario;
	}

	public void setaUsuario(ArrayList<Jugador> aUsuario) {
		this.aUsuario = aUsuario;
	}
	
	//MEcanica del juego
	public void jugarPartida(){
		//Recorro array x dnd me he quedado para 1 usuario
		//miro si el usuario tiene vidas
		//Extraigo una pregunta
			//comprobando que no haya salido 
			//ni que le haya tocado anteriormente
		//Dependiendo si gana o no puntos o resto vida.
		
	}
}
