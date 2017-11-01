package br.com.fiap.financial.charge;

public class Teste1 {

	/*public static void main(String[] args) {
		FinanceiroWebService port = new FinanceiroWebServiceService().getFinanceiroWebServicePort();

		Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Usuario", Collections.singletonList("governo"));
		headers.put("Senha", Collections.singletonList("governo123"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		try {
			CobrancaRequestPojo requestPojo = new CobrancaRequestPojo();
			requestPojo.setCpfCnpj("50286427885");
			requestPojo.setValor(1.0);
			CobrancaRequest request = new CobrancaRequest();
			request.setCobranca(requestPojo);
			CobrancaResponse response = port.cobranca(request);
			
			System.out.println(response.getResultadoCobranca().isResultado());
		} catch (FinanceiraException e1) {
			e1.printStackTrace();
		}
		
		

	}*/

}
