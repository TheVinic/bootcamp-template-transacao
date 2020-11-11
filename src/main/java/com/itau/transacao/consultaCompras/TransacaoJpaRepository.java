package com.itau.transacao.consultaCompras;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itau.transacao.entity.Transacao1;

public interface TransacaoJpaRepository extends JpaRepository<Transacao1, Long>{

	
	@Query(value="select * from Transacao1 p where p.cartao_id = :idCartao order by p.efetivada_em limit 10", nativeQuery = true)
	public List<Transacao1> encontra10UltimasTransacoesPorCartaoId(@Param("idCartao") String cartao);
	
}
