package br.com.fiap.common;

public class RespostaVO {
	private static final long serialVersionUID = 113L;

	private int id;

	private String descricao;


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
