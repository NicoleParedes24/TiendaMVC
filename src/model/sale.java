package model;

import java.time.LocalDate;

import lib_genericP65v0.Generic;

public class sale {
	private Generic<Integer,LocalDate> sale1;
	private Generic<String,String>sale2;
	
	public sale() {
		this.sale1= new Generic<>();
		this.sale2= new Generic<>();
	}
	
	public sale(int idSale, int idClient, LocalDate createSale,String saleNumber) {
		this.sale1= new Generic<>(idSale,idClient,createSale);
		this.sale2= new Generic<>(saleNumber,"");
	}
	public String getSaleNumber() {
		return this.sale2.getAttribute1();
	}
	public void setSaleNumber(String s) {
		this.sale2.setAttribute1(s);
	}

	public int getIDsale() {
		return this.sale1.getAttribute1();
	}
	public void setIDsale(int s) {
		this.sale1.setAttribute1(s);
	}
	
	public int getIDclient() {
		return this.sale1.getAttribute2();
	}
	public void setIDclient(int s) {
		this.sale1.setAttribute2(s);
	}
	
	public LocalDate getcreateSale() {
		return this.sale1.getAttribute3();
	}
	public void  setcreateSale(LocalDate s) {
		this.sale1.setAttribute3(s);
	}
}
