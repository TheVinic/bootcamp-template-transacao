package com.itau.transacao.consultaCompras;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itau.transacao.entity.Transacao1;

@RestController
public class ConsultaComprasController {
	
	@Autowired
	private TransacaoJpaRepository transacaoJpaRepository;
	
	@GetMapping("/api/transacoes/{id_cartao}")
	public ResponseEntity<?> ConsultaCompras(@PathVariable("id_cartao") @NotBlank String id_cartao){
		
		List<Transacao1> listaTransacoes = transacaoJpaRepository.findFirst10ByOrderByEfetivadaEm();
		
		List<TransacaoResponse> response = StreamSupport.stream(listaTransacoes.spliterator(), false)
				.map(transacao -> transacao.toResponse()).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
}
