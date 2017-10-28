package br.com.fiap.endpoint;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import br.com.fiap.endpoint.request.TaxRequest;
import br.com.fiap.endpoint.response.TaxResponse;

@InInterceptors(interceptors = {"br.com.fiap.interceptors.LoginInterceptor" })
@WebService(name = "Tax", targetNamespace = "http://br.com.fiap.government/")
public interface TaxPort {
    @WebResult(name = "return", targetNamespace = "")
    @WebMethod(action = "urn:GenerateTax")
    TaxResponse generate(TaxRequest body);
}


