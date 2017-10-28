package br.com.fiap.endpoint.response;

import java.util.List;

import br.com.fiap.model.Invoice;

public class InvoicesResponse {
	
	private List<Invoice> invoices;
	
	public InvoicesResponse() {
	}

	public InvoicesResponse(List<Invoice> invoices) {
		super();
		this.invoices = invoices;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
}