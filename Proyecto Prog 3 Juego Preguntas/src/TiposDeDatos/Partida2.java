package TiposDeDatos;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

import Ventanas.VentanaPrincipal;

public class Partida2 {


	private Pregunta preguntaAleatoria;
	public static boolean siguiente;
	private int ronda;
	
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
	 * COnstructor que inicializa la partida dependiendo de los parametros que se le han pasado.
	 * @param config - Se le pasa un objeto config con la configuracion de la partida
	 * @param aUsuario - Se pasa un array de usuarios con los integrantes de la partda
	 */
	public Partida2(ConfiguracionJuego config, ArrayList<Jugador> aUsuario) {
	
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
		
		preguntaAleatoria=null; 
	    jugadorTurno=null;
	    ronda=0;
	   
		//Recorro el array de vidas y mientras haya alguno diferente de -1
	//	while(!haTerminadoJuego()&& ronda==0){ //SE ME CREAN MILES DE VENTANAS
			
	    	
			int i=0;
			siguiente=true;
			while(true){
				//while(siguiente && i<aUsuario.size()){
				if(siguiente){	
					System.out.println("A JUGAR");
				    jugadorTurno=aUsuario.get(i);//usuario del que es el turno 
					siguiente=false;
					//if(aVidas.get(i).intValue()!= -1){ //Miro si ha terminado la partida (-1 FIN PARTIDA)
						//NO HA TERMINADO LA PARTIDA EL JUGADOR 
						VentanaPrincipal.logger.log( Level.INFO,"Jugador: "+jugadorTurno.getUser()+" / Vidas:"+aVidas.get(i));
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
							
						}while((!enElJuego && !alUsuario) && busquedaPregunta<100);	
							
						
						//Añadimos la preguntaAleatoria que ha salido en este turno al juego.
						//Para ello, añadimos al ArrayList de aPreguntas. 
						aPreguntas.add(preguntaAleatoria);
						//Mandar pregunta y usuario a la ventana pregunta
						//hay que pasar por cargar pregunta. 
					
								// TODO Auto-generated method stub
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/*VentanaCargarPregunta vcp = new VentanaCargarPregunta(preguntaAleatoria);
						vcp.setVisible(true);
						System.out.println("Pregunta cargada");*/
						//Ventana2 v2 = new Ventana2();
					//}				
					//termino con un usuario.
					i++;
					ronda++;
			
					
				}
				
			}
			
			//Cuando termino con la primera ronda inicializao a 0 para empezar otra ronda. 
			/*if(ronda==aUsuario.size()){
				ronda=0;
			}*/
		//}
		
		//HA TERMINADO PARTIDA. 
		//Actualizo los usuarios.
		//ActualizarUsuariosEnBD();
		
		//Mostrar tabla marcadores.
			//Sin ordenarlos
		
		
	}
	
	 
	/**
	 * Metodo que busca en el array de preguntas si ha salido una pregunta que se le pasa por parametro. 
	 * @param p
	 * @return
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
	
	/**
	 * Metod que nos devuelve un true si ha terminado el juego
	 * @return
	 */
	private boolean haTerminadoJuego(){
		boolean encontrado=false;
		int numUsers=aUsuario.size();
		int numEnJuego=0;
		
		for(Integer vi: aVidas){	
			if(vi==-1){ 
				numEnJuego++;
			}
		}
		if(numEnJuego == numUsers){
			encontrado=true; //Ha finalizado el juego
		}
		return encontrado;
	}
	
	
	private void ActualizarUsuariosEnBD (){
		
		ArrayList<Jugador> aJugadoresBD = null;
		aJugadoresBD=VentanaPrincipal.bd.obtenerUsuarios();
		Jugador jug=null; 
		
		//Recorre a todos los usuarios de la partida
		for(int i=0; i<aUsuario.size(); i++){
			jug=aUsuario.get(i);
			if(VentanaPrincipal.bd.comprobarUsuario(jug)){//Preguntar BD
				//EXISTE
				//Comprobamos puntuacion.
				Jugador jugBD=VentanaPrincipal.bd.ObtenerUsuario(jug);
				if(jugBD.getRecord()>=jug.getRecord()){
					jug=jugBD;
				}
			}
			//actualizo al usuario en la BD.
			VentanaPrincipal.bd.insertarUsuario(jug);
		}
	}
	
}