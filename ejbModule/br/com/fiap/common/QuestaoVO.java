package br.com.fiap.common;

import java.util.List;

import javax.persistence.Transient;

public class QuestaoVO {
	
	private static final long serialVersionUID = 112L;

	private Integer id;
	
	private Integer codigoAvaliacao;
	
	private String descricao;
	
	private List<RespostaVO> respostas;
	

	public List<RespostaVO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaVO> respostas) {
		this.respostas = respostas;
	}

	@Transient
	private Resposta respostaSelecionada;
	
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public Integer getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Integer codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resposta getRespostaSelecionada() {
		return respostaSelecionada;
	}

	public void setRespostaSelecionada(Resposta respostaSelecionada) {
		this.respostaSelecionada = respostaSelecionada;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
	

}
