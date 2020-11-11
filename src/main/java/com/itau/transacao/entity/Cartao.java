package com.itau.transacao.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.itau.transacao.consultaCompras.CartaoResponse;
import com.itau.transacao.consultaCompras.TransacaoResponse;

@Entity
@Table(name = "cartao_transacoes")
public class Cartao {

	@NotBlank
	@Id
	private String id;

	@NotBlank
	@Email
	private String email;
	@OneToMany(mappedBy = "cartao")
	private Set<Transacao1> transacao = new HashSet<>();

	public Cartao() {
		super();
	}

	public Cartao(String id, @Email String email, Transacao1 transacao) {
		this.id = id;
		this.email = email;
		this.transacao.add(transacao);
	}

	public void novaTransacao(Transacao1 transacao1) {
		transacao.add(transacao1);
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Set<Transacao1> getTransacao() {
		return transacao;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + ", transacao=" + transacao + "]";
	}

	public List<TransacaoResponse> transacoesToResponse() {
		List<TransacaoResponse> listaTransacoes = StreamSupport.stream(transacao.spliterator(), false)
				.map(transacao -> transacao.toResponse()).collect(Collectors.toList());
		return listaTransacoes;
	}

	public CartaoResponse toResponse() {
		return new CartaoResponse(id, email);
	}

}
