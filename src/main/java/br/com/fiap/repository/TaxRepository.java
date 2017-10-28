package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Tax;

public class TaxRepository {
	private final static List<Tax> TAXES = new ArrayList<>();
	
	public static List<Tax> findAll() {
		return TAXES;
	}
	
	static {
		Tax tax1 = new Tax();
		tax1.setName("PIS");
		tax1.setPercent(2.0);
		TAXES.add(tax1);
		
		Tax tax2 = new Tax();
		tax2.setName("COFINS");
		tax2.setPercent(4.0);
		TAXES.add(tax2);

		Tax tax3 = new Tax();
		tax3.setName("ISS");
		tax3.setPercent(6.0);
		TAXES.add(tax3);
	}
}
