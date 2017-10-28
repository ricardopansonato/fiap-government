package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.endpoint.request.InvoiceRequest;

public class Invoice {
	private Document source;
	private Document recipient;
	private Double value;
	private Double valueWithTax;
	private List<Tax> taxes = new ArrayList<>();
	
	public Invoice() {
	}
	
	public Invoice(User user, InvoiceRequest request) {
		this.source = user.getDocument();
		this.recipient = request.getDocument();
		this.value = request.getValue();
	}
	
	public Invoice(User user, InvoiceRequest request, List<Tax> taxes) {
		this(user, request);
		this.taxes = taxes;
		this.valueWithTax = request.getValue();
		for (final Tax tax : this.taxes) {
			this.valueWithTax = this.valueWithTax + ((this.value * tax.getPercent()) / 100);
		}
	}	
	
	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
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

	public Double getValueWithTax() {
		return valueWithTax;
	}

	public void setValueWithTax(Double valueWithTax) {
		this.valueWithTax = valueWithTax;
	}
}
