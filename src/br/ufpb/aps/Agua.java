package br.ufpb.aps;
public class Agua implements ItemTabuleiro {

	private String nome;
	
	public Agua(){
		this.nome = "AGUA";
	}
	
	public String getNome(){
		
		return this.nome;
	}

	@Override
	public String levarTiro() {
		return "";
	}
}
