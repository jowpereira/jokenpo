package com.jokenpo.services;

import java.util.List;

import com.jokenpo.dtos.Jogador;

public interface JogadorService {

	List<Jogador> findAll();
	Jogador find(Integer id);
	void save(Jogador jogador);
	void delete(Integer id);
	public Jogador winner(Jogador playerUm, Jogador playerDois);
	public Jogador winner();
}
