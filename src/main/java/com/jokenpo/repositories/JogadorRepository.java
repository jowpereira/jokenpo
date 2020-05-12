package com.jokenpo.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jokenpo.dtos.Jogador;

@Repository
public class JogadorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public void save(Jogador jogador) {
		this.jogadores.add(jogador);
	}

	public Optional<List<Jogador>> findAll() {
		return Optional.ofNullable(this.jogadores.isEmpty()?null:this.jogadores);
	}

	public Optional<Jogador> findById(Integer id) {
		return Optional.ofNullable(this.jogadores.stream().filter(jogador -> id == jogador.getId()).findAny().orElse(null));
	}

	public void delete(Jogador jogador) {
		this.jogadores.remove(jogador);
	}

}
