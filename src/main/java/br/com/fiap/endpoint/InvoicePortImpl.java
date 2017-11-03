package br.com.fiap.endpoint;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;
import br.com.fiap.endpoint.response.InvoicesResponse;
import br.com.fiap.model.Invoice;
import br.com.fiap.model.User;
import br.com.fiap.repository.InvoiceRepository;
import br.com.fiap.repository.TaxesRepository;
import br.com.fiap.repository.UserRepository;

@WebService(serviceName = "Invoice", portName = "InvoicePort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.InvoicePort")
public class InvoicePortImpl implements InvoicePort {

	@Override
	public InvoiceResponse generate(@WebParam(header=false) InvoiceRequest body, 
								   @WebParam(header=true, name="username") String username, 
								   @WebParam(header=true, name="username") String password) {
		User user = UserRepository.findByUsername(username);
		
		Invoice invoice = new Invoice(user, body, TaxesRepository.findAll());
        InvoiceRepository.save(user.getUsername(), invoice);
		
        return new InvoiceResponse(invoice);
	}

	@Override
	public InvoicesResponse list(@WebParam(header=true, name="username") String username, 
			   				    @WebParam(header=true, name="username") String password) {
		List<Invoice> invoices = InvoiceRepository.findByUsername(username);
        InvoicesResponse invoicesResponse = new InvoicesResponse();
        invoicesResponse.setInvoices(invoices);
		
		return invoicesResponse;
	}
}
