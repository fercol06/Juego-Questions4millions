package TiposDeDatos;

import java.util.ArrayList;

public class Partida {

	

	private ConfiguracionJuego config;
	private ArrayList<Jugador> aUsuario;
	// private ArrayList<Pregunta> aPregunta;
	

	public Partida(ConfiguracionJuego config, ArrayList<Jugador> aUsuario) {
		this.config = config;
		this.aUsuario = aUsuario;
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
	
	

}
