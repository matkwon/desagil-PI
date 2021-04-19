package br.edu.insper.desagil.PI.matkwon;

import java.util.HashMap;
import java.util.Map;

public class Video {
	
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;

	public Video(int id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacao(Usuario usuario, int avaliacao) {
		if (usuario != this.usuario && avaliacao >= 1 && avaliacao <= 5) {
			this.avaliacoes.put(usuario.getNome(), avaliacao);
		}
	}
	
	public int mediaAvaliacoes() {
		double media = 0;
		for (int avaliacao : this.avaliacoes.values()) {
			media += avaliacao;
		}
		if (this.avaliacoes.size() > 0) {
			media = Math.round(media/this.avaliacoes.size());
		}
		return (int) media;
	}

}
