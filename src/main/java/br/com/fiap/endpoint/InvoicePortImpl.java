package br.com.fiap.endpoint;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;
import br.com.fiap.endpoint.response.InvoicesResponse;
import br.com.fiap.model.Invoice;
import br.com.fiap.model.User;
import br.com.fiap.repository.InvoiceRepository;
import br.com.fiap.repository.UserRepository;
import br.com.fiap.util.SoapUtil;

@WebService(serviceName = "Invoice", portName = "InvoicePort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.InvoicePort")
public class InvoicePortImpl implements InvoicePort {

	@Override
	public InvoiceResponse generate(InvoiceRequest body) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
        SoapMessage soapMessage = (SoapMessage) message;
        
        String username = SoapUtil.valueFromHeader(soapMessage, "username");
		User user = UserRepository.findByUsername(username);
		
		Invoice invoice = new Invoice(user, body);
        InvoiceRepository.save(user.getUsername(), invoice);
		
        return new InvoiceResponse(invoice);
	}

	@Override
	public InvoicesResponse list() {
		
		Message message = PhaseInterceptorChain.getCurrentMessage();
        SoapMessage soapMessage = (SoapMessage) message;
        
        String username = SoapUtil.valueFromHeader(soapMessage, "username");
		
        List<Invoice> invoices = InvoiceRepository.findByUsername(username);
        InvoicesResponse invoicesResponse = new InvoicesResponse();
        invoicesResponse.setInvoices(invoices);
		
		return invoicesResponse;
	}
}
