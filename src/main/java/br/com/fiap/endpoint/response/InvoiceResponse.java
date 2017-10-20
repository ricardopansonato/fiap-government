package br.com.fiap.endpoint.response;

import br.com.fiap.model.Invoice;

public class InvoiceResponse {
	private Invoice invoice;

	public InvoiceResponse() {
		
	}
	
	public InvoiceResponse(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
