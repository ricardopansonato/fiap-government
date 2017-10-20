package br.com.fiap.model;

import br.com.fiap.endpoint.request.InvoiceRequest;

public class Invoice {
	private Document source;
	private Document recipient;
	private Double value;
	
	public Invoice() {
	}
	
	public Invoice(User user, InvoiceRequest request) {
		this.source = user.getDocument();
		this.recipient = request.getDocument();
		this.value = request.getValue();
	}
	
	public Document getSource() {
		return source;
	}

	public void setSource(Document source) {
		this.source = source;
	}

	public Document getRecipient() {
		return recipient;
	}

	public void setRecipient(Document recipient) {
		this.recipient = recipient;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
