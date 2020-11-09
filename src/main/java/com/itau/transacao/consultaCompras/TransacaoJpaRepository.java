package com.itau.transacao.consultaCompras;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.transacao.entity.Transacao1;

public interface TransacaoJpaRepository extends JpaRepository<Transacao1, Long>{

	public List<Transacao1> findFirst10ByOrderByEfetivadaEm();
	
}
