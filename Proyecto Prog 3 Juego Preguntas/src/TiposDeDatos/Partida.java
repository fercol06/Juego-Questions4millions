package TiposDeDatos;

import java.util.ArrayList;
import java.util.Random;

import Ventanas.VentanaCargarPregunta;
import Ventanas.VentanaPregunta;
import Ventanas.VentanaPrincipal;

public class Partida {

	

	private ConfiguracionJuego config;
	private ArrayList<Jugador> aUsuario;
	//ArrayList de vidas 
	private ArrayList<Integer> aVidas;
	//Arraylist de Preguntas hechas
	private ArrayList<Pregunta> aPreguntas;
	//ArrayList de preguntas de BD
	private ArrayList<Pregunta> aPreguntasBD;
	public static Jugador jugadorTurno;
	
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
		this.aPreguntasBD = VentanaPrincipal.bd.obtenerPreguntas();
	}

	
	
	//Mecanica del juego
	public void jugarPartida(){
		
		Pregunta preguntaAleatoria=null; 
	    jugadorTurno=null;
		
		//Recorro el array de vidas y mientras haya alguno diferente de -1
		//while()
		
		//Recorro array x dnd me he quedado para 1 usuario
		for(int i=0; i<aUsuario.size(); i++){
			jugadorTurno=aUsuario.get(i);//usuario del que es el turno 
			
			if(aVidas.get(i)!= -1){ //Miro si ha terminado la partida (-1 FIN PARTIDA)
				//NO HA TERMINADO LA PARTIDA EL JUGADOR 

				boolean enElJuego;
				boolean alUsuario;
				int busquedaPregunta=0;
				
				do{
					//Extraigo una pregunta
					preguntaAleatoria = obtenerPreguntaAleatoria();
					
					//comprobando que no haya salido (en el array de preguntas)
					enElJuego = buscarPreguntaDicha(preguntaAleatoria);
					
					//ni que le haya tocado anteriormente (base de datos)
					//Mejor en BD por si hay mucho jugadores y muchas preguntas
					alUsuario = VentanaPrincipal.bd.comprobarPregunta(preguntaAleatoria,jugadorTurno);
				
					//busquedapregunta incremento para que no se quede mirando siempre
					//Si al de 100 sigue saliendo repetida, se pregunta una cualquiera.
					busquedaPregunta++;
					
				}while((!enElJuego && !alUsuario)|| busquedaPregunta<100);	
					
				//Mandar pregunta y usuario a la ventana pregunta
					//hay que pasar por cargar pregunta. 
				VentanaCargarPregunta vcp = new VentanaCargarPregunta(preguntaAleatoria);
				vcp.setVisible(true);
				
				
				//Dependiendo la respuesta de ventanaPregunta
					//actualizamos base de datos
				//VentanaPrincipal.bd.inertarPreguntaContestada(jugadorTurno,preguntaAleatoria,acertado);
					//mandamos ventana solucion
				
			}else{
				//FIN PARTIDA PARA JUGADOR
				//NO tiene que hacer nada xke le tokará al proximo. 
			}
			//termino una ronda.
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
			if(au.compareTo(p)==1){ //implementar comparable:  compare to? //codigo y nivel da igual //1 - misma pregunta
				encontrado=true;
			}
		}
		
		return encontrado;
	}
	
	/**
	 * Metodo que genera una pregunta aleatoria.
	 * @return
	 */
	private Pregunta obtenerPreguntaAleatoria(){
		
		Pregunta p;
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		int numAleatorio= rnd.nextInt(aPreguntasBD.size()-1);
		p=aPreguntasBD.get(numAleatorio);
		return p;
	}
	
	/*private boolean haTerminadoJuego(){
		for(Integer vi: aVidas){	
			if(au.compareTo(p)==1){ //implementar comparable:  compare to? //codigo y nivel da igual //1 - misma pregunta
				encontrado=true;
			}
		}
	}*/
}
