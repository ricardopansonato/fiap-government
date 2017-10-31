package br.com.fiap.financial;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Teste {
	
	public static void main(String[] args) {

		FinanceiroWebService port = new FinanceiroWebServiceService().getFinanceiroWebServicePort();

		Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		//headers.put("Usuario", Collections.singletonList("clienteTestePedro"));
		//headers.put("Senha", Collections.singletonList("TestePedro123"));
		headers.put("Usuario", Collections.singletonList("clienteMarcelo-2018"));
		headers.put("Senha", Collections.singletonList("Marcelo-2018123"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		SaldoRequest srequest = new SaldoRequest();
		
		try {
			SaldoResponse sresponse = port.saldo(srequest);
			
			System.out.println(sresponse.getSaldo().getSaldo());
		} catch (FinanceiraException e1) {
			e1.printStackTrace();
		}

	}

}
