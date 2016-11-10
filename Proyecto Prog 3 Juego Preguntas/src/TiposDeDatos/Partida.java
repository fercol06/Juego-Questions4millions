package TiposDeDatos;

import java.util.ArrayList;

public class Partida {

	

	private ConfiguracionJuego config;
	private ArrayList<Usuario> aUsuario;
	// private ArrayList<Pregunta> aPregunta;
	

	public Partida(ConfiguracionJuego config, ArrayList<Usuario> aUsuario) {
		this.config = config;
		this.aUsuario = aUsuario;
	}

	public ConfiguracionJuego getConfig() {
		return config;
	}

	public void setConfig(ConfiguracionJuego config) {
		this.config = config;
	}

	public ArrayList<Usuario> getaUsuario() {
		return aUsuario;
	}

	public void setaUsuario(ArrayList<Usuario> aUsuario) {
		this.aUsuario = aUsuario;
	}

}
