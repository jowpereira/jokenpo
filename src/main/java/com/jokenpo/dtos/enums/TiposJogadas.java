package com.jokenpo.dtos.enums;

public enum TiposJogadas {

	pedra("pedra"), papel("papel"), tesoura("tesoura"), lagarto("lagarto"), spock("spock"), empate("empate");

	private String descricao;
	private static boolean PERDE = false;
	private static boolean GANHA = true;

	private TiposJogadas(String descricao) {
		this.descricao = descricao;
	}

	@SuppressWarnings("static-access")
	public boolean compara(TiposJogadas TiposJogadas) {
		switch (this) {
		case pedra:
			if (TiposJogadas == TiposJogadas.tesoura || TiposJogadas == TiposJogadas.lagarto || TiposJogadas == TiposJogadas.empate) {
				return GANHA;
			} else
				return PERDE;
		case papel:
			if (TiposJogadas == TiposJogadas.pedra || TiposJogadas == TiposJogadas.spock || TiposJogadas == TiposJogadas.empate) {
				return GANHA;
			} else
				return PERDE;
		case tesoura:
			if (TiposJogadas == TiposJogadas.papel || TiposJogadas == TiposJogadas.lagarto || TiposJogadas == TiposJogadas.empate) {
				return GANHA;
			} else
				return PERDE;
		case lagarto:
			if (TiposJogadas == TiposJogadas.papel || TiposJogadas == TiposJogadas.spock || TiposJogadas == TiposJogadas.empate) {
				return GANHA;
			} else
				return PERDE;
		case spock:
			if (TiposJogadas == TiposJogadas.pedra || TiposJogadas == TiposJogadas.tesoura || TiposJogadas == TiposJogadas.empate) {
				return GANHA;
			} else
				return PERDE;

		default:
			return PERDE;
		}
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}