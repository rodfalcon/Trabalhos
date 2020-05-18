package negocio;

public class Morador extends Condominio {

	private String morador, sobrenome;

	public void setMorador(String morador) {
		this.morador = morador;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Override
	public String MostrarAtributos() {
		return atributos = morador + " " + sobrenome;
		
	}


}
