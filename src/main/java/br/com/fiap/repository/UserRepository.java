package br.com.fiap.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.fiap.model.Document;
import br.com.fiap.model.Type;
import br.com.fiap.model.User;

public class UserRepository {
	
	private final static Map<String, User> USERS = new HashMap<>();
	
	private static User createUser(String username, String password, 
								  String documentValue, Type type) {
		Document document = new Document();
		document.setType(type);
		document.setValue(documentValue);
		
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setDocument(document);
		
		return user;
	}
	
	static {
		USERS.put("financeiro", createUser("financeiro", "financeiro", "123.456.789-01", Type.CPF));
		USERS.put("estabelecimento", createUser("estabelecimento", "estabelecimento", "223.456.789-01", Type.CPF));
	}
	
	public static User findByUsername(final String username) {
		return USERS.get(username);
	}
}
