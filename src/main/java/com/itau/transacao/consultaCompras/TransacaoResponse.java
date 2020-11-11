package com.itau.transacao.consultaCompras;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.transacao.entity.Cartao;
import com.itau.transacao.entity.Estabelecimento1;

public class TransacaoResponse {

	@JsonProperty("id")
	@NotBlank
	private String id;

	@JsonProperty("idEvento")
	@NotBlank
	private String idEvento;

	@JsonProperty("valor")
	@NotNull
	private BigDecimal valor;

	@JsonProperty("efetivadaEm")
	@NotNull
	private LocalDateTime efetivadaEm;

	@JsonProperty("estabelecimento")
	@NotNull
	private EstabelecimentoResponse estabelecimento;
	
	@JsonProperty("cartao")
	private CartaoResponse cartao;

	public TransacaoResponse(String id, @NotBlank String idEvento, @NotNull BigDecimal valor,
			@NotNull LocalDateTime efetivadaEm, Estabelecimento1 estabelecimento, Cartao cartao) {
		this.id = id;
		this.idEvento = idEvento;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		if (estabelecimento != null) {
			this.estabelecimento = estabelecimento.toResponse();
		}
		if(cartao != null)
			this.cartao = cartao.toResponse();
	}
}
