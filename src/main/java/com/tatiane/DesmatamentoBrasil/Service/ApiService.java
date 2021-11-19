package com.tatiane.DesmatamentoBrasil.Service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tatiane.DesmatamentoBrasil.entities.dto.RetornoApiProdes;

@Service
public class ApiService {
	

	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

		
	public RetornoApiProdes integracaoApiProdes(String url){
		Gson gson = new Gson();	
		HttpClient httpclient = HttpClients.createDefault();
	
		HttpGet httpget = new HttpGet(url);

		try {
			logger.info("Iniciando a busca na API Prodes URL: {}", url);
			HttpResponse response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				RetornoApiProdes dto = gson.fromJson(content, RetornoApiProdes.class);
				logger.info("Dados encontrados, retornando");
				return dto;
				//teste 
				
				
			}

		} catch (ClientProtocolException e) {
			logger.error("Erro ao tentar se conectar com o Client");
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			httpget.releaseConnection();
		}
		return null;
	}
	
}
