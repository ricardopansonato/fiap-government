package br.com.fiap.endpoint;

import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;

import br.com.fiap.endpoint.response.TaxesResponse;
import br.com.fiap.model.Tax;
import br.com.fiap.model.User;
import br.com.fiap.repository.TaxesRepository;
import br.com.fiap.repository.UserRepository;
import br.com.fiap.util.SoapUtil;

@WebService(serviceName = "Taxes", portName = "TaxesPort", targetNamespace = "http://br.com.fiap.government/", endpointInterface = "br.com.fiap.endpoint.TaxesPort")
public class TaxesPortImpl implements TaxesPort {
	
	@Override
	public TaxesResponse list(@WebParam(header=true, name="username") String username, 
			   				 @WebParam(header=true, name="password") String password) {
		
		Message message = PhaseInterceptorChain.getCurrentMessage();
        SoapMessage soapMessage = (SoapMessage) message;
        
        username = username == null ? SoapUtil.valueFromHeader(soapMessage, "username") : username;
        password = password == null ? SoapUtil.valueFromHeader(soapMessage, "password") : password;
		
		User user = UserRepository.findByUsername(username);
		if (user == null || (user != null && !password.equals(user.getPassword()))) {
			throw new Fault("Usuario e senha invalidos", Logger.getAnonymousLogger());
		}
		List<Tax> taxes = TaxesRepository.findAll();
		TaxesResponse response = new TaxesResponse();
		response.setTaxes(taxes);
		return new TaxesResponse(taxes);
	}
}
