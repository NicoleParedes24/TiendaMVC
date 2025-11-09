package controller;

import java.sql.SQLException;

import model.configurable;
import view.view_tienda;

public class process_code extends Thread implements configurable {
	private String codeProduct="";
	private view_tienda vm;
	public process_code(String msg,view_tienda vm) {
		super(msg);
		this.vm=vm;
	}
	
	private int getvalue() {
		return(int)(Math.random()*10);
	}
	public void run() {
		int aux=0;
		while(true) {
			if(aux==0) 
				codeProduct=getName()+"-";
			codeProduct+=String.valueOf(getvalue());
			aux++;
			if(aux==4) {
				try {
					if(pdao.searchProduct(codeProduct)==null) {
						//System.out.println(codeProduct);
						vm.txt_codigo_prod .setText(codeProduct);
						break;
					}else {
						aux=0;
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
