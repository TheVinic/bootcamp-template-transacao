package com.itau.transacao.consumerKafka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
	
}
