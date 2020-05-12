package com.jokenpo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jokenpo.dtos.Empate;
import com.jokenpo.dtos.Jogador;
import com.jokenpo.repositories.JogadorRepository;
import com.jokenpo.services.JogadorService;
import com.jokenpo.services.exception.ObjectNotFoundException;

@Service
public class JogadorServiceImpl implements JogadorService {

	@Autowired
	private JogadorRepository repo;

	public List<Jogador> findAll() {
		Optional<List<Jogador>> list = repo.findAll();
		return list.orElseThrow(
				() -> new ObjectNotFoundException("Jogadores não encontrado! , Tipo: " + Jogador.class.getName()));
	}

	public Jogador find(Integer id) {
		Optional<Jogador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Jogador não encontrado! Id: " + id + ", Tipo: " + Jogador.class.getName()));
	}

	public void save(Jogador jogador) {
		repo.save(jogador);
	}

	public void delete(Integer id) {
		Optional<Jogador> obj = repo.findById(id);
		repo.delete(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Jogador não encontrado! Id: " + id + ", Tipo: " + Jogador.class.getName())));
	}

	public Jogador winner(Jogador playerUm, Jogador playerDois) {
		if (playerUm.getJogada().equals(playerDois.getJogada()))
			return new Empate();

		boolean resultado = playerUm.getJogada().compara(playerDois.getJogada());
		playerUm.setVenceu(resultado);
		return resultado ? playerUm : playerDois;
	}

	public Jogador winner() {
		Stack<Jogador> vencedor = new Stack<Jogador>();
		List<Jogador> list = this.findAll();
		list.forEach(jogador -> {
			if (vencedor.empty())
				vencedor.push(jogador);
			else {
				Jogador ultimoVencedor = vencedor.peek();
				Jogador vencedorDaRodada = this.winner(jogador, ultimoVencedor);
				if (!vencedorDaRodada.equals(ultimoVencedor)) {
					vencedor.pop();
					vencedor.push(vencedorDaRodada);
				}
			}
		});
		return vencedor.peek();

	}
}
