package com.itau.transacao.consultaCompras;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartaoResponse {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("email")
	private String email;

	public CartaoResponse(@NotBlank String id, @NotBlank @Email String email) {
		this.id = id;
		this.email = email;
	}
	
}
