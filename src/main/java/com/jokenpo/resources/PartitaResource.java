package com.jokenpo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jokenpo.dtos.Jogador;
import com.jokenpo.services.impl.JogadorServiceImpl;

@RestController
@RequestMapping
public class PartitaResource {

	@Autowired
	private JogadorServiceImpl jogadorServiceImpl;

	public PartitaResource() {
	}

	@GetMapping(value = "/players")
	public List<Jogador> getAllPlayers() {
		return jogadorServiceImpl.findAll();
	}

	@GetMapping(value = "/player/{id}")
	public Jogador findOne(@PathVariable("id") Integer id) {
		return jogadorServiceImpl.find(id);		
	}

	@PostMapping(value = "/newPlayer")
	public ResponseEntity<?> criaJogador(@RequestBody Jogador jogador) {
		jogadorServiceImpl.save(jogador);
		return ResponseEntity.ok("Jogador inserido com Sucesso!");
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> removeJogador(@PathVariable("id") int id) {
		jogadorServiceImpl.delete(id);
		return ResponseEntity.ok("Jogador deletado com sucesso!");
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterarJogador(@PathVariable("id") int id, @RequestBody Jogador obj) {
		Jogador jogadorAlterado = jogadorServiceImpl.find(id);
		jogadorAlterado.setJogada(obj.getJogada());
		jogadorAlterado.setNome(obj.getNome());
		return ResponseEntity.ok("Aletaração realizada com sucesso!");
	}

	@GetMapping(value = "/winner")
	public Jogador winner() {
		return jogadorServiceImpl.winner();
	}
}
