package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.model.Invoice;

public class InvoiceRepository {
	private final static Map<String, List<Invoice>> INVOICES = new HashMap<>();
	
	public static List<Invoice> findByUsername(final String username) {
		return INVOICES.get(username);
	}
	
	public static void save(final String username, final Invoice invoice) {
		List<Invoice> invoices = INVOICES.get(username);
		if (invoices == null) {
			invoices = new ArrayList<>();
		}
		invoices.add(invoice);
		INVOICES.put(username, invoices);
	}
	
	public static Invoice findByUsernameCPF(final String username, final String cpf) {
		
		for(Invoice invoice :  INVOICES.get(username)) {
			if(invoice.getSource().getValue().equals(cpf)) {
				return invoice;
			}
		}
		return null;
	}
}
