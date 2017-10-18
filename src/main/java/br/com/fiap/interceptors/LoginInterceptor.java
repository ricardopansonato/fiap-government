package br.com.fiap.interceptors;

import java.util.List;
import java.util.logging.Logger;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class LoginInterceptor extends AbstractSoapInterceptor {

	public LoginInterceptor() {
    		super(Phase.PRE_INVOKE);
    }

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = message.getHeaders();
		String user = null, password = null;
		
		for (Header header : headers) {
			Element element = (Element) header.getObject();
			
			if (element.getLocalName().equals("user")) {
				user = element.getTextContent();
			} else if (element.getLocalName().equals("password")) {
				password = element.getTextContent();
			} 
		}
		
		if (!"ricardo".equals(user) || !"123".equals(password)) {
			throw new Fault("Usuario e senha invalidos", Logger.getAnonymousLogger());
		}
	}

	
}
