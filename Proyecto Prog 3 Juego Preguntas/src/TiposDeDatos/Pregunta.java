package TiposDeDatos;

public class Pregunta {

	private String pregunta;
	private String resp1;
	private String resp2;
	private String resp3;
	private String resp4;
	private String respCorrecta;
	private int nivel;
	
	/**
	 * Constructor clase pregunta
	 * @param pregunta
	 * @param resp1
	 * @param resp2
	 * @param resp3
	 * @param resp4
	 * @param respCorrecta
	 */
	public Pregunta(String pregunta, String resp1, String resp2, String resp3, String resp4, String respCorrecta, int nivel) {
		this.pregunta = pregunta;
		this.resp1 = resp1;
		this.resp2 = resp2;
		this.resp3 = resp3;
		this.resp4 = resp4;
		this.respCorrecta = respCorrecta;
		this.nivel = nivel; 
	}
	/**
	 * Constructor por defecto de clase Pregunta
	 */
	public Pregunta() {
	}
	
	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}
	/**
	 * @return the resp1
	 */
	public String getResp1() {
		return resp1;
	}
	/**
	 * @return the resp2
	 */
	public String getResp2() {
		return resp2;
	}
	/**
	 * @return the resp3
	 */
	public String getResp3() {
		return resp3;
	}
	/**
	 * @return the resp4
	 */
	public String getResp4() {
		return resp4;
	}
	/**
	 * @return the respCorrecta
	 */
	public String getRespCorrecta() {
		return respCorrecta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pregunta [pregunta=" + pregunta + ", resp1=" + resp1 + ", resp2=" + resp2 + ", resp3=" + resp3
				+ ", resp4=" + resp4 + ", respCorrecta=" + respCorrecta + ", nivel=" + nivel + "]";
	}

	
	
}
