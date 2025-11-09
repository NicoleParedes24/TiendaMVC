package model;

import java.time.LocalDate;

import lib_genericP65v0.Generic;

public class client {//id int nameString , emalString, dniInt, adresString, fechacreate LocalDate, state bool
	Generic<Integer,String> c1;
	Generic<String, LocalDate> c2;
	Generic<Boolean,Integer>c3;
	
	public client() {
		this.c1= new Generic<>();
		this.c2= new Generic<>();
		this.c3= new Generic<>();
		
	}
	
	public client(int id, String name, String email, int cedula,int phone, String address, LocalDate fecha, boolean state) {
		this.c1= new Generic<>(id,cedula,name,email);
		this.c2= new Generic<>(address,fecha);
		this.c3= new Generic<>(state,phone);
	}
	public int getPhone() {
		return this.c3.getAttribute3();
	}
	
	public void setPhone(int p) {
		this.c3.setAttribute3(p);
	}
	
	public String getAddres() {
		return this.c2.getAttribute1();
	}
	public void setAdress(String a) {
		this.c2.setAttribute1(a);
	}
	
	public LocalDate getFecha() {
		return this.c2.getAttribute3();
	}
	public void setFecha(LocalDate s) {
		this.c2.setAttribute3(s);
	}
	public boolean getState() {
		return this.c3.getAttribute1();
	}
	public void setState(boolean s) {
		this.c3.setAttribute1(s);
	}
	
	public int getId() {
		return 	this.c1.getAttribute1();
	}
	public void setId(int id) {
		this.c1.setAttribute1(id);
	}
	
	public int getCedula() {
		return 	this.c1.getAttribute2();
	}
	public void setCedula(int id) {
		this.c1.setAttribute2(id);
	}
	
	public String getName() {
		return this.c1.getAttribute3();
	}
	public void setName(String n) {
		this.c1.setAttribute3(n);
	}
	
	
	public String getEmail() {
		return this.c1.getAttribute4();
	}
	public void setEmail(String n) {
		this.c1.setAttribute4(n);
	}
	

}
