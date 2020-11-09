package com.itau.transacao.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.itau.transacao.entity.Cartao;
import com.itau.transacao.entity.Transacao1;

public class CartaoEventoResponse {

	private String id;
	
	@Email
	private String email;

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CartaoEventoResponse [id=" + id + ", email=" + email + "]";
	}

	public @NotNull Cartao toModel(Transacao1 transacao) {
		return new Cartao(id, email, transacao);
	}
	
}
