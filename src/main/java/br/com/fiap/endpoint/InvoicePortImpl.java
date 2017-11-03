package br.com.fiap.endpoint;

import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;
import br.com.fiap.endpoint.response.InvoicesResponse;
import br.com.fiap.financial.FinanceiraException;
import br.com.fiap.financial.charge.Charge;
import br.com.fiap.model.Invoice;
import br.com.fiap.model.User;
import br.com.fiap.repository.InvoiceRepository;
import br.com.fiap.repository.TaxesRepository;
import br.com.fiap.repository.UserRepository;
import br.com.fiap.util.SoapUtil;

@WebService(serviceName = "Invoice", portName = "InvoicePort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.InvoicePort")
public class InvoicePortImpl implements InvoicePort {

	@Override
	public InvoiceResponse generate(@WebParam(header = false) InvoiceRequest body,
			@WebParam(header = true, name = "username") String username,
			@WebParam(header = true, name = "password") String password) throws Exception {
		Message message = PhaseInterceptorChain.getCurrentMessage();
        SoapMessage soapMessage = (SoapMessage) message;
        
        username = username == null ? SoapUtil.valueFromHeader(soapMessage, "username") : username;
        password = password == null ? SoapUtil.valueFromHeader(soapMessage, "password") : password;
        
        User user = UserRepository.findByUsername(username);
		if (user == null || (user != null && !password.equals(user.getPassword()))) {
			throw new Fault("Usuario e senha invalidos", Logger.getAnonymousLogger());
		}

		Invoice invoice = new Invoice(user, body, TaxesRepository.findAll());
		double tax = invoice.getValueWithTax() - invoice.getValue();

		try {
			if (tax > 0) {
				Charge charge = new Charge();
				boolean result = charge.doCharge(invoice.getRecipient().getValue(), tax);
				if (result) {
					invoice.setIssued(true);
					InvoiceRepository.save(user.getUsername(), invoice);
				} else {
					throw new Exception("Saldo Zerado!");
				}
			}
		} catch (FinanceiraException e) {
			invoice = null;
			invoice = new Invoice();
			invoice.setDetail(e.getMessage());
			throw new Exception(e.getMessage());
		}

		return new InvoiceResponse(invoice);
	}

	@Override
	public InvoicesResponse list(@WebParam(header = true, name = "username") String username,
								@WebParam(header = true, name = "password") String password) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
        SoapMessage soapMessage = (SoapMessage) message;
        
        username = username == null ? SoapUtil.valueFromHeader(soapMessage, "username") : username;
        password = password == null ? SoapUtil.valueFromHeader(soapMessage, "password") : password;
		
		User user = UserRepository.findByUsername(username);
		if (user == null || (user != null && !password.equals(user.getPassword()))) {
			throw new Fault("Usuario e senha invalidos", Logger.getAnonymousLogger());
		}
		
		List<Invoice> invoices = InvoiceRepository.findByUsername(username);
		InvoicesResponse invoicesResponse = new InvoicesResponse();
		invoicesResponse.setInvoices(invoices);

		return invoicesResponse;
	}
}