package com.tatiane.DesmatamentoBrasil.Resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.DesmatamentoBrasil.Service.ApiService;
import com.tatiane.DesmatamentoBrasil.Service.DadosDesmatamentoService;
import com.tatiane.DesmatamentoBrasil.entities.DadosDesmatamento;
import com.tatiane.DesmatamentoBrasil.entities.dto.RetornoApiProdes;

@RestController
@RequestMapping(value= "/dadosDesmatamento")
public class DadosDesmatamentoResource {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

	@Autowired
	private DadosDesmatamentoService service;
	
	
	@GetMapping(value = "/filtrar")	
	public ResponseEntity<List<DadosDesmatamento>> buscarDadosDesmatamentoComFiltro
	(@RequestParam String ano, @RequestParam String uf ){
		
		logger.info("Iniciando Chamada Na Api Local");	
		List<DadosDesmatamento> lsDadosDesmatamento = service.buscarDadosDesmatamentoComFiltro(ano, uf);
		
		logger.info("Api Local -> Retornando dados tratados");	
		logger.info("SUCESSO!!!");	
		return ResponseEntity.ok().body(lsDadosDesmatamento);
	}
	
}
