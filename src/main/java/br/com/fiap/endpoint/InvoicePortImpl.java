package br.com.fiap.endpoint;

import javax.jws.WebService;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;

@WebService(serviceName = "Invoice", portName = "InvoicePort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.InvoicePort")
public class InvoicePortImpl implements InvoicePort {

	@Override
	public InvoiceResponse generate(InvoiceRequest body) {
		return new InvoiceResponse();
	}
}
