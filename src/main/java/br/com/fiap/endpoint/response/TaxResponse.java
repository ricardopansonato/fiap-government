package br.com.fiap.endpoint.response;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Tax;

public class TaxResponse {
	private List<Tax> taxes = new ArrayList<>();

	public TaxResponse() {
	}
	
	public TaxResponse(List<Tax> taxes) {
		super();
		this.taxes = taxes;
	}

	public List<Tax> getTaxes() {
		return taxes;
	}
	
}
