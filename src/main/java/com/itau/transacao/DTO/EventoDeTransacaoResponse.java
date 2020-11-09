package com.itau.transacao.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.itau.transacao.entity.Transacao1;

public class EventoDeTransacaoResponse {

	private String id;

    private BigDecimal valor;
    
    private CartaoEventoResponse cartao;
    
    private EstabelecimentoEventoResponse estabelecimento;
    
    private LocalDateTime efetivadaEm;

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public CartaoEventoResponse getCartao() {
		return cartao;
	}

	public EstabelecimentoEventoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "EventoDeTransacaoResponse [id=" + id + ", valor=" + valor + ", cartao=" + cartao.toString() + ", estabelecimento="
				+ estabelecimento.toString() + ", efetivadaEm=" + efetivadaEm + "]";
	}

	public Transacao1 toModel() {
		return new Transacao1(id, valor, cartao, estabelecimento, efetivadaEm);
	}
	
}
