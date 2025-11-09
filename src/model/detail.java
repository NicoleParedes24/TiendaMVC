package model;

import lib_genericP65v0.Generic;

public class detail {

	private Generic<Integer,Integer>d1;
	private Generic<Double,Double>d2;
	
	public detail() {
		this.d1= new Generic<>();
		this.d2= new Generic<>();	
	}
	public detail(int id_detail,int id_sale,int id_product,int units, double total) {
		this.d1= new Generic<>(id_detail,id_sale,id_product,units);
		this.d2= new Generic<>(total);
	}
	
	public int getIDdetail() {
		return this.d1.getAttribute1();
	}
	public void setIDdetail(int i) {
		this.d1.setAttribute1(i);
	}
	public int getIDSale() {
		return this.d1.getAttribute2();
	}
	public void setIDsale(int i) {
		this.d1.setAttribute2(i);
	}
	
	public int getIDproduct() {
		return this.d1.getAttribute3();
	}
	public void setIDproduct(int i) {
		this.d1.setAttribute3(i);
	}
	
	public double getTotal() {
		return this.d2.getAttribute1();
	}
	public void setTotal(double i) {
		this.d2.setAttribute1(i);
	}
	
}
