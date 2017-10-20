package br.com.fiap.interceptors;

import java.util.logging.Logger;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import br.com.fiap.model.User;
import br.com.fiap.repository.UserRepository;
import br.com.fiap.util.SoapUtil;

public class LoginInterceptor extends AbstractSoapInterceptor {
	
	public LoginInterceptor() {
    		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		String username = SoapUtil.valueFromHeader(message, "username");
		String password = SoapUtil.valueFromHeader(message, "password");
		User user = UserRepository.findByUsername(username);
		
		if (user == null || (user != null && !password.equals(user.getPassword()))) {
			throw new Fault("Usuario e senha invalidos", Logger.getAnonymousLogger());
		}
	}
}
