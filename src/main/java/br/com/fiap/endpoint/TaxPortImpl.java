package br.com.fiap.endpoint;

import java.util.List;

import javax.jws.WebService;

import br.com.fiap.endpoint.request.TaxRequest;
import br.com.fiap.endpoint.response.TaxResponse;
import br.com.fiap.model.Tax;
import br.com.fiap.repository.TaxRepository;

@WebService(serviceName = "Tax", portName = "TaxPort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.TaxPort")
public class TaxPortImpl implements TaxPort {
	
	@Override
	public TaxResponse generate(TaxRequest body) {
		List<Tax> taxes = TaxRepository.findAll();
		return new TaxResponse(taxes);
	}
}
