package br.com.fiap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;
import br.com.fiap.endpoint.response.InvoicesResponse;

@InInterceptors(interceptors = {"br.com.fiap.interceptors.LoginInterceptor" })
@WebService(name = "Invoice", targetNamespace = "http://br.com.fiap.government/")
public interface InvoicePort {
	
    @WebResult(name = "generate", targetNamespace = "")
    @WebMethod(action = "urn:GenerateInvoice")
    InvoiceResponse generate(@WebParam(header=false) InvoiceRequest body, 
    							@WebParam(header=true, name="username") String username, 
    						    @WebParam(header=true, name="password") String password) throws Exception;

    
    @WebResult(name = "list", targetNamespace = "")
    @WebMethod(action = "urn:ListInvoice")
    InvoicesResponse list(@WebParam(header=true, name="username") String username, 
			   			 @WebParam(header=true, name="password") String password);
}