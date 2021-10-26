package com.tatiane.DesmatamentoBrasil.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.tatiane.DesmatamentoBrasil.entities.DadosDesmatamento;
import com.tatiane.DesmatamentoBrasil.mapper.MapperDadosDesmatamento;

@Service
public class DadosDesmatamentoService {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
	
	@Value("${url}")
	private String url;

	@Autowired
	private ApiService apiService;

	@Autowired
	private MapperDadosDesmatamento mapper;

	public List<DadosDesmatamento> buscarDadosDesmatamento() {

		logger.info("Preparando Service Para Chamada De Api Externa");
		List<DadosDesmatamento> lsDadosDesmatamento = mapper.mapearDados(apiService.integracaoApiProdes(url));
		return lsDadosDesmatamento;
	}

	public List<DadosDesmatamento> buscarDadosDesmatamentoComFiltro(String ano, String uf) {

		logger.info("Preparando Service Para Chamada De Api Externa");
		List<DadosDesmatamento> lsDadosDesmatamento = 
				mapper.mapearDados(apiService.integracaoApiProdes(concatenarUrl(ano,uf,url)));
		return lsDadosDesmatamento;
	}

	public String concatenarUrl(String ano, String uf, String url) {
		
		if (!ano.equals("") ) {
			url += "ano%20%3D%20'" + ano + "'";
		}
		
		if ( !uf.equals("") && !ano.equals("")) {
			url += "%20AND%20uf%20%3D%20'" + uf + "'";
		}else if(!uf.equals("") && ano.equals("")) {
			url += "uf%20%3D%20'" + uf + "'";
		}		
		return url+="&outFields=*&returnGeometry=false&outSR=4326&f=json";
	}

}
