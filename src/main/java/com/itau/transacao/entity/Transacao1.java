package com.itau.transacao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itau.transacao.DTO.CartaoEventoResponse;
import com.itau.transacao.DTO.EstabelecimentoEventoResponse;
import com.itau.transacao.consultaCompras.TransacaoResponse;

@Entity
public class Transacao1 {

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
	
	@NotBlank
	private String idEvento;

	@NotNull
    private BigDecimal valor;
    
    @NotNull
    private LocalDateTime efetivadaEm;

	@ManyToOne
	@JsonIgnore
    private Cartao cartao;
    
	@OneToOne
    private Estabelecimento1 estabelecimento1;
    
    public Transacao1() {
		super();
	}
    
	public Transacao1(String id, BigDecimal valor, CartaoEventoResponse cartao,
			EstabelecimentoEventoResponse estabelecimento, LocalDateTime efetivadaEm) {
		this.idEvento = id;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento1 = estabelecimento.toModel(this);
	}

	public void adicionaCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	@Override
	public String toString() {
		return "Transacao1 [id=" + id + ", idEvento=" + idEvento + ", valor=" + valor + ", efetivadaEm=" + efetivadaEm
				+ "]";
	}

	public String getId() {
		return id;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Estabelecimento1 getEstabelecimento() {
		return estabelecimento1;
	}

	public TransacaoResponse toResponse() {
		return new TransacaoResponse(id, idEvento, valor, efetivadaEm, estabelecimento1, cartao);
	}
	
}
