package br.com.fiap.application;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.endpoint.InvoicePortImpl;
import br.com.fiap.endpoint.TaxPortImpl;

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
	
	@Bean
	public Endpoint tax() {
		EndpointImpl endpoint = new EndpointImpl(bus, new TaxPortImpl());
		endpoint.publish("/Tax");
		return endpoint;
	}
}
