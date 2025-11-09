package model;
import java.time.LocalDate;

import lib_genericP65v0.Generic;
public class product {
	private Generic<Integer,String> dt1_p;
	private Generic<Double,String> dt2_p;
	private Generic<LocalDate,Boolean> dt3_p;
	
	public product() {
		
		super();
		this.dt1_p = new Generic<>();
		this.dt2_p = new Generic<>();
		this.dt3_p = new Generic<>();
	}
	public product(Generic<Integer, String> dt1_p, Generic<Double, String> dt2_p, Generic<LocalDate, Boolean> dt3_p) {
		super();
		this.dt1_p = dt1_p;
		this.dt2_p = dt2_p;
		this.dt3_p = dt3_p;
	}
	public product(int id_product,String nameProduct, String descproduct,int stock,
			double price,String code,LocalDate create,boolean state) {
		dt1_p=new Generic<>(id_product,stock,nameProduct,descproduct);
		dt2_p=new Generic<>(price,code);
		dt3_p=new Generic<>(create,state);
		
	}
	public int getIdProduct() {
		return dt1_p.getAttribute1();
	}
	public void setIdproduct(int id_) {
		dt1_p.setAttribute1(id_);
	}
	public String getNameProduct() {
		return dt1_p.getAttribute3();
	}
	public void setNameProduct(String name) {
		dt1_p.setAttribute3(name);
	}
	public String getdescProduct() {
		return dt1_p.getAttribute4();
	}
	public void setdesProduct(String desc) {
		dt1_p.setAttribute4(desc);
	}
	public int getStock() {
		return dt1_p.getAttribute2();
	}
	public void setStock(int stock) {
		dt1_p.setAttribute2(stock);
	}
	/////////////////////
	public double getPrice() {
		return dt2_p.getAttribute1();
	}
	public void setPrice(double price) {
		dt2_p.setAttribute1(price);
	}
	public String getCode() {
		return dt2_p.getAttribute3();
	}
	public void setcode(String code) {
		dt2_p.setAttribute3(code);
	}
	/////////////////////////
	public LocalDate getCreate() {
		return dt3_p.getAttribute1();
	}
	public void setCreate(LocalDate create) {
		dt3_p.setAttribute1(create);
	}
	public boolean getState() {
		return dt3_p.getAttribute3();
	}
	public void setState(boolean state) {
		dt3_p.setAttribute3(state);
	}
	@Override
	public String toString() {
		return "product [getIdProduct()=" + getIdProduct() + ", getNameProduct()=" + getNameProduct()
				+ ", getdescProduct()=" + getdescProduct() + ", getStock()=" + getStock() + ", getPrice()=" + getPrice()
				+ ", getCode()=" + getCode() + ", getCreate()=" + getCreate() + ", getState()=" + getState() + "]";
	}
	
	
	
}
