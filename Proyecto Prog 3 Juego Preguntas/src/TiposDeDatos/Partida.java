package TiposDeDatos;

import java.util.ArrayList;

import Ventanas.VentanaPrincipal;

public class Partida {

	

	private ConfiguracionJuego config;
	private ArrayList<Jugador> aUsuario;
	//ArrayList de vidas 
	private ArrayList<Integer> aVidas;
	//Arraylist de Preguntas hechas
	private ArrayList<Pregunta> aPreguntas;
	
	
	/**
	 * COnstructor que inicializa la partida dependiendo de los parametros que se le han pasado.
	 * @param config - Se le pasa un objeto config con la configuracion de la partida
	 * @param aUsuario - Se pasa un array de usuarios con los integrantes de la partda
	 */
	public Partida(ConfiguracionJuego config, ArrayList<Jugador> aUsuario) {
		this.config = config;
		this.aUsuario = aUsuario;
		//Reservo tantas posiciones de un arrayVidas como usuarios participen. 
		this.aVidas = new ArrayList<Integer>(config.getNumJugadores());
		//Inicializo a las vidas designadas en configuracion
		for(int i=0; i<config.getNumJugadores(); i++){
			aVidas.add(config.getNumVidas());
		}
		//Reservo memoria para el arraylist de preguntas
		this.aPreguntas = new ArrayList<Pregunta>();
	}

	
	
	//Mecanica del juego
	public void jugarPartida(){
		
		//obtengo el numero total de preguntas en la BD
		int numPreguntas = VentanaPrincipal.bd.numPreguntas(); 
		Pregunta preguntaAleatoria=null; 
		Jugador jugadorTurno=null;
		
		//Recorro array x dnd me he quedado para 1 usuario
		for(int i=0; i<aUsuario.size(); i++){
			jugadorTurno=aUsuario.get(i);//usuario del que es el turno 
			
			if(aVidas.get(i)!= -1){ //Miro si ha terminado la partida (-1 FIN PARTIDA)
				//NO HA TERMINADO LA PARTIDA EL JUGADOR 
				
				//preguntaAleatoria = VentanaPrincipal.bd.obtenerPreguntaAleatoria();
				
				
				//Extraigo una pregunta
					//comprobando que no haya salido (en el array de preguntas)
					//ni que le haya tocado anteriormente (base de datos)
				
				//Si al de 100 sigue saliendo repetida, se pregunta una cualquiera.
				
			}else{
				//FIN PARTIDA PARA JUGADOR
			}
		}
		
		
		
		
		//Extraigo una pregunta
			//comprobando que no haya salido (en el array de preguntas)
			//ni que le haya tocado anteriormente
		//Dependiendo si gana o no puntos o resto vida.
			//añado pregunta a arraylist
			//añado a la base de datos la pregunta.
		
	}
	
	//Busco en el array de preguntas si ha salido. 
	private boolean buscarPreguntaDicha(Pregunta p){
		boolean encontrado=false;
		//recorro todo el arraylist aPreguntas a ver si ha salido. 
		for(Pregunta au: aPreguntas){	
			if(au.equals(p)){ //crear compare to? //codigo y nivel da igual
				encontrado=true;
			}
		}
		
		return encontrado;
	}
	
}
