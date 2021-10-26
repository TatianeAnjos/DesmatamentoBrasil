package com.tatiane.DesmatamentoBrasil.mapper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.tatiane.DesmatamentoBrasil.entities.DadosDesmatamento;
import com.tatiane.DesmatamentoBrasil.entities.dto.RetornoApiProdes;

@Component
public class MapperDadosDesmatamento {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

	private DecimalFormat d = new DecimalFormat("#,###");
	public List<DadosDesmatamento> mapearDados(RetornoApiProdes rs) {
		List<DadosDesmatamento> lsDados = new ArrayList<>();

		logger.info("Mapeando dados obtidos...");
		rs.getFeatures().forEach(feature -> {
			if (feature.getAttributes().getAreameters() > 0000 
					&& feature.getAttributes().getAreameters() < 9999) {
				
				DadosDesmatamento dt = new DadosDesmatamento();
				dt.setId(feature.getAttributes().getObjectid());
				dt.setAno(feature.getAttributes().getAno());
				dt.setAreaForma(Double.parseDouble(d.format(feature.getAttributes().getShape_Area())));
				dt.setAreaMetros(Double.parseDouble(d.format(feature.getAttributes().getAreameters())));
				dt.setTamanhoForma(Double.parseDouble(d.format(feature.getAttributes().getShape_Length())));
				dt.setUf(feature.getAttributes().getUf());
//				dt.setAreaForma(feature.getAttributes().getShape_Area());
//				dt.setAreaMetros(feature.getAttributes().getAreameters());
//				dt.setTamanhoForma(feature.getAttributes().getShape_Length());

				lsDados.add(dt);
			}
		});

		return lsDados;
	}
}
