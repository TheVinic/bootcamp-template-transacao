package com.itau.transacao.consumerKafka;

import javax.validation.constraints.Email;

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
	
}
