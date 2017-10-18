package br.com.fiap.application;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.endpoint.InvoicePortImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
    private Bus bus;
	
	@Bean
	public Endpoint invoice() {
		EndpointImpl endpoint = new EndpointImpl(bus, new InvoicePortImpl());
		endpoint.publish("/Invoice");
		return endpoint;
	}
}
