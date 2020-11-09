package com.itau.transacao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.itau.transacao.consultaCompras.EstabelecimentoResponse;

@Entity
@Table(name = "estabelecimento1")
public class Estabelecimento1 {

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
	
	@NotBlank
	private String nome;

	@NotBlank
	private String cidade;

	@NotBlank
	private String endereco;
	
	@OneToOne
	private Transacao1 transacao;

	public Estabelecimento1() {
		super();
	}

	public Estabelecimento1(String nome, String cidade, String endereco, Transacao1 transacao) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
		this.transacao = transacao;
	}

	public @NotNull EstabelecimentoResponse toResponse() {
		return new EstabelecimentoResponse(id, nome, cidade, endereco);
	}

}
