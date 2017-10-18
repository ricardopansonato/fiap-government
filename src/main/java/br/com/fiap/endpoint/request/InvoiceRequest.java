package br.com.fiap.endpoint.request;

import br.com.fiap.model.Document;

public class InvoiceRequest {

	private Double value;
	private Document document;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
