package com.jokenpo.dtos;

import com.jokenpo.dtos.enums.TiposJogadas;

public class Empate extends Jogador {
	private static final long serialVersionUID = 2971641608277050319L;

	private String nome;
	private TiposJogadas jogada;

	public Empate() {
		this.nome = "empate";
		this.jogada = TiposJogadas.empate;
	}
	
	public String getNome() {
		return nome;
	}
	
	public TiposJogadas getTiposJogadas() {
		return jogada;
	}
	
}