package TiposDeDatos;

public class Pregunta {

	private int cod_pr;
	private String pregunta;
	private String resp1;
	private String resp2;
	private String resp3;
	private String resp4;
	private String respCorrecta;
	private int nivel;
	
	/**
	 * Constructor con parametros clase pregunta
	 * @param pregunta
	 * @param resp1
	 * @param resp2
	 * @param resp3
	 * @param resp4
	 * @param respCorrecta
	 * @param nivel
	 */
	public Pregunta(String pregunta, String resp1, String resp2, String resp3, String resp4, String respCorrecta, int nivel) {
		this.cod_pr=0; //Inicializamos a 0 porque no vale.
		this.pregunta = pregunta;
		this.resp1 = resp1;
		this.resp2 = resp2;
		this.resp3 = resp3;
		this.resp4 = resp4;
		this.respCorrecta = respCorrecta;
		this.nivel = nivel; 
	}
	/**
	 * Constructor con parametros clase pregunta
	 * @param cod_pr
	 * @param pregunta
	 * @param resp1
	 * @param resp2
	 * @param resp3
	 * @param resp4
	 * @param respCorrecta
	 * @param nivel
	 */
	public Pregunta(int cod_pr, String pregunta, String resp1, String resp2, String resp3, String resp4, String respCorrecta, int nivel) {
		this.cod_pr=cod_pr; 
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
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	/**
	 * @param resp1 the resp1 to set
	 */
	public void setResp1(String resp1) {
		this.resp1 = resp1;
	}
	/**
	 * @param resp2 the resp2 to set
	 */
	public void setResp2(String resp2) {
		this.resp2 = resp2;
	}
	/**
	 * @param resp3 the resp3 to set
	 */
	public void setResp3(String resp3) {
		this.resp3 = resp3;
	}
	/**
	 * @param resp4 the resp4 to set
	 */
	public void setResp4(String resp4) {
		this.resp4 = resp4;
	}
	/**
	 * @param respCorrecta the respCorrecta to set
	 */
	public void setRespCorrecta(String respCorrecta) {
		this.respCorrecta = respCorrecta;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * @param cod_pr the cod_pr to set
	 */
	public void setCod_pr(int cod_pr) {
		this.cod_pr = cod_pr;
	}
	/**
	 * @return the cod_pr
	 */
	public int getCod_pr() {
		return cod_pr;
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
	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		/*
		return "Pregunta [cod_pr=" + cod_pr + ", pregunta=" + pregunta + ", resp1=" + resp1 + ", resp2=" + resp2
				+ ", resp3=" + resp3 + ", resp4=" + resp4 + ", respCorrecta=" + respCorrecta + ", nivel=" + nivel + "]";
		*/
		return cod_pr + ". " + pregunta + " ; " + respCorrecta + " [" + nivel + "]";
	}
	
	
	
}
