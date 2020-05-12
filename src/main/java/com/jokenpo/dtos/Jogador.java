package com.jokenpo.dtos;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jokenpo.dtos.enums.TiposJogadas;

public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;

	private static AtomicInteger ID_GENERATOR = new AtomicInteger();
	private long id;
	private String nome;
	private TiposJogadas jogada;
	
	@JsonIgnore
	private Boolean venceu;

	public Jogador() {
		id = ID_GENERATOR.getAndIncrement();
		this.venceu = false;
	}

	public Jogador(String nome) {
		id = ID_GENERATOR.getAndIncrement();
		this.nome = nome;
		this.venceu = false;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TiposJogadas getJogada() {
		return jogada;
	}

	public void setJogada(TiposJogadas jogada) {
		this.jogada = jogada;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

}