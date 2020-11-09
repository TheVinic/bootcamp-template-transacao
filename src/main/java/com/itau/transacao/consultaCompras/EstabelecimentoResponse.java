package com.itau.transacao.consultaCompras;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstabelecimentoResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("nome")
	@NotBlank
	private String nome;

	@JsonProperty("cidade")
	@NotBlank
	private String cidade;

	@JsonProperty("endereco")
	@NotBlank
	private String endereco;

	public EstabelecimentoResponse(String id, @NotBlank String nome, @NotBlank String cidade,
			@NotBlank String endereco) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

}
