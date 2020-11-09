package com.itau.transacao.consumerKafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacaoResponse eventoDeTransacao) {
        System.out.println("ID: " + eventoDeTransacao.getId() + "; Valor: " + eventoDeTransacao.getValor());
    }

}