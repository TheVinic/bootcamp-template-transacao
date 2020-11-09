package com.itau.transacao.consumerKafka;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.itau.transacao.DTO.EventoDeTransacaoResponse;
import com.itau.transacao.entity.Cartao;
import com.itau.transacao.entity.Transacao1;

@Component
@Transactional
public class ListenerDeTransacao {

	@PersistenceContext
	private EntityManager manager;
	
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacaoResponse eventoDeTransacao) {
        System.out.println(eventoDeTransacao.toString());
        
        Transacao1 transacao = eventoDeTransacao.toModel();
          
        Cartao cartao = manager.find(Cartao.class, eventoDeTransacao.getCartao().getId());

        if(cartao == null) {
        	cartao = eventoDeTransacao.getCartao().toModel(transacao);
            manager.persist(cartao);
        } else {
        	cartao.novaTransacao(eventoDeTransacao.toModel());
        	manager.merge(cartao);
        }
        
        transacao.adicionaCartao(cartao);
        manager.persist(transacao.getEstabelecimento());
        manager.persist(transacao);
    }

}