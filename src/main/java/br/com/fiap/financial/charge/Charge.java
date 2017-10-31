package br.com.fiap.financial.charge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import br.com.fiap.financial.CobrancaRequest;
import br.com.fiap.financial.CobrancaRequestPojo;
import br.com.fiap.financial.CobrancaResponse;
import br.com.fiap.financial.FinanceiraException;
import br.com.fiap.financial.FinanceiroWebService;
import br.com.fiap.financial.FinanceiroWebServiceService;

public class Charge {
	
	public boolean doCharge(String cpf, double value) throws FinanceiraException {
		
		FinanceiroWebService port = new FinanceiroWebServiceService().getFinanceiroWebServicePort();

		Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Usuario", Collections.singletonList("governo"));
		headers.put("Senha", Collections.singletonList("governo123"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		try {
			CobrancaRequestPojo requestPojo = new CobrancaRequestPojo();
			requestPojo.setCpfCnpj(cpf);
			requestPojo.setValor(value);
			CobrancaRequest request = new CobrancaRequest();
			request.setCobranca(requestPojo);
			CobrancaResponse response = port.cobranca(request);
			
			return response.getResultadoCobranca().isResultado();
			
		} catch (FinanceiraException e1) {
			throw new FinanceiraException(e1.getMessage(),e1.getFaultInfo());
		} catch (Exception e1) {
			throw new FinanceiraException(e1.getMessage(),null);
		}
	}
}