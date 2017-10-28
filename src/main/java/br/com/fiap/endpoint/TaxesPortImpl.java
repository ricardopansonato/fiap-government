package br.com.fiap.endpoint;

import java.util.List;

import javax.jws.WebService;

import br.com.fiap.endpoint.request.TaxesRequest;
import br.com.fiap.endpoint.response.TaxesResponse;
import br.com.fiap.model.Tax;
import br.com.fiap.repository.TaxesRepository;

@WebService(serviceName = "Taxes", portName = "TaxesPort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.TaxesPort")
public class TaxesPortImpl implements TaxesPort {
	
	@Override
	public TaxesResponse list() {
		List<Tax> taxes = TaxesRepository.findAll();
		return new TaxesResponse(taxes);
	}
}
