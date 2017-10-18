package br.com.fiap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import br.com.fiap.endpoint.request.InvoiceRequest;
import br.com.fiap.endpoint.response.InvoiceResponse;

@InInterceptors(interceptors = {"br.com.fiap.interceptors.LoginInterceptor" })
@WebService(name = "Invoice", targetNamespace = "http://br.com.fiap.government/")
public interface InvoicePort {
	
    @WebResult(name = "return", targetNamespace = "")
    @WebMethod(action = "urn:GenerateInvoice")
    InvoiceResponse generate(InvoiceRequest body);
	
}
