package br.com.fiap.endpoint;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import br.com.fiap.endpoint.response.TaxesResponse;

@InInterceptors(interceptors = {"br.com.fiap.interceptors.LoginInterceptor" })
@WebService(name = "Taxes", targetNamespace = "http://br.com.fiap.government/")
public interface TaxesPort {
    
	@WebResult(name = "list", targetNamespace = "")
    @WebMethod(action = "urn:ListTaxes")
    TaxesResponse list(@WebParam(header=true, name="username") String username, 
			   		  @WebParam(header=true, name="password") String password);
}


