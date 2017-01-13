package TiposDeDatos;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;


import Ventanas.VentanaCargarPregunta;
import Ventanas.VentanaPrincipal;


public class Partida {


	private Pregunta preguntaAleatoria;
	public static boolean siguiente;
	
	private ConfiguracionJuego config;
	public static ArrayList<Jugador> aUsuario;
	//ArrayList de vidas 
	public static ArrayList<Integer> aVidas; // para poder pasarlo por ventanas
	//Arraylist de Preguntas hechas
	private ArrayList<Pregunta> aPreguntas;
	//ArrayList de preguntas de BD
	private ArrayList<Pregunta> aPreguntasBD;
	public static Jugador jugadorTurno; //para poder pasarlo por ventanas
	
	/**
	 * Constructor que inicializa la partida dependiendo de los parametros que se le han pasado.
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

	
	/**
	 * Método que incluye toda la mecánica del juego con todas las condiciones que se deben de cumplir para que
	 * el usuario siga jugando. 
	 */
		public void jugarPartida(){
			siguiente=true;
			int i=0;
			
			while(!haTerminadoJuego()){

				//No se ejecuta en el último xke si el usuario 1  ha terminado, no cambia la variable siguiente a true.
				if(siguiente){
					siguiente=false;
					jugadorTurno=aUsuario.get(i);
					
					//Miro si ha terminado la partida (0 FIN PARTIDA)
					if(aVidas.get(i).intValue()!= 0){ 
						//NO HA TERMINADO LA PARTIDA EL JUGADOR 
						VentanaPrincipal.logger.log( Level.INFO,"Jugador: "+jugadorTurno.getUser()+" / Vidas:"+aVidas.get(i));
						boolean enElJuego;
						boolean alUsuario;
						int busquedaPregunta=0;
						
						//METODO COMPROBAR PREGUNTAS y OBTENER ALEATORIAS
						long semilla= System.currentTimeMillis();
						do{
							//Para que vaya cambiando la semilla. 
							semilla+=1;
							//Extraigo una pregunta
							preguntaAleatoria = obtenerPreguntaAleatoria(semilla);
							
							//comprobando que no haya salido (en el array de preguntas)
							enElJuego = buscarPreguntaDicha(preguntaAleatoria);
							
							//ni que le haya tocado anteriormente (base de datos)
							//Mejor en BD por si hay mucho jugadores y muchas preguntas
							alUsuario = VentanaPrincipal.bd.comprobarPregunta(preguntaAleatoria,jugadorTurno);
							
							//busquedapregunta incremento para que no se quede mirando siempre
							//Si al del tamaño maximo del array de preguntas sigue saliendo repetida, se pregunta una cualquiera.
							busquedaPregunta++;
							
						}while((enElJuego && alUsuario) && busquedaPregunta<aPreguntasBD.size());	
							

						//Añadimos la preguntaAleatoria que ha salido en este turno al juego.
						//Para ello, añadimos al ArrayList de aPreguntas. 
						aPreguntas.add(preguntaAleatoria);
						//Mandar pregunta y usuario a la ventana pregunta
						//hay que pasar por cargar pregunta. 
					
						VentanaCargarPregunta vcp = new VentanaCargarPregunta(preguntaAleatoria,config.getSegundosPreguntas());
						vcp.setVisible(true);
						//termino con un usuario.	
					}else{
						siguiente=true;
					}
					i++;
					
				}
				if(i==aUsuario.size()){
					i=0;
				}
				
				
				
				
					
			}
				
			//HA TERMINADO PARTIDA. 
			//Actualizo los usuarios.
			ActualizarUsuariosEnBD();
			
		}
	 
	/**
	 * Metodo que busca en el array de preguntas si ha salido una pregunta que se le pasa por parametro. 
	 * @param p - Le pasamos un obeto Pregunta
	 * @return true - SI la pregunta que le hemos pasado se ha dicho en la partida. 
	 */
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
	 * Método que genera una pregunta aleatoria en base a una semilla y la devuelve.
	 * @return p - Obeto pregunta con la pregunta aleatoria. 
	 */
	private Pregunta obtenerPreguntaAleatoria(long semilla){
		
		Pregunta p;
		Random rnd = new Random();
		rnd.setSeed(semilla);
		int numAleatorio= rnd.nextInt(aPreguntasBD.size()-1);
		p=aPreguntasBD.get(numAleatorio);
		return p;
	}
	
	/**
	 * Metod que nos devuelve un true si ha terminado el juego
	 * @return true - Si el juego ha terminado. 
	 */
	private boolean haTerminadoJuego(){
		boolean encontrado=false;
		int numUsers=aUsuario.size();
		int numEnJuego=0;
		
		for(Integer vi: aVidas){	
			if(vi.intValue()==0){ 
				numEnJuego++;
			}
		}
		if(numEnJuego == numUsers){
			encontrado=true; //Ha finalizado el juego
		}
		return encontrado;
	}
	
	/**
	 * Metodo que actualiza los datos de los usuarios en la base de datos. 
	 */
	private void ActualizarUsuariosEnBD (){
		
		Jugador jug=null;
		Jugador jugBD=null;
		
		//Recorre a todos los usuarios de la partida
		for(int i=0; i<aUsuario.size(); i++){
			jug=aUsuario.get(i);
			if(VentanaPrincipal.bd.comprobarUsuario(jug)){//Preguntar BD si existe
				//EXISTE
				//Comprobamos puntuacion.
				jugBD=VentanaPrincipal.bd.ObtenerUsuario(jug);
				if(jugBD.getRecord()>=jug.getRecord()){
					jug=jugBD;
				}
				VentanaPrincipal.bd.borrarUsuario(jug);
			}
			//actualizo al usuario en la BD.
			VentanaPrincipal.bd.insertarUsuario(jug);
		}
	}
	
}
