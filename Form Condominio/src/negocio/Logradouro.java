package negocio;

public class Logradouro extends Condominio {

	private String nomeCondominio, nomeRua;
	


	public void setNomeCondominio(String nomeCondominio) {
		this.nomeCondominio = nomeCondominio;
	}
	
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	@Override
	public String MostrarAtributos() {
		return atributos = nomeCondominio + "\n" + nomeRua;
		
	}

}
