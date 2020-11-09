package com.itau.transacao.DTO;

import javax.validation.constraints.NotNull;

import com.itau.transacao.entity.Estabelecimento1;
import com.itau.transacao.entity.Transacao1;

public class EstabelecimentoEventoResponse {

	private String nome;
	
	private String cidade;
	
	private String endereco;

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "EstabelecimentoEventoResponse [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}

	public @NotNull Estabelecimento1 toModel(Transacao1 transacao) {
		return new Estabelecimento1(nome, cidade, endereco, transacao);
	}
	
}
