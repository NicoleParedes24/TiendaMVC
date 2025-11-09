package model;

import java.sql.SQLException;
import java.time.LocalDate;

public class test_model {
	/*public static void main(String[] args) {
		sale b= new sale(6,3,LocalDate.now(),"4");
		
		saleDAO s= new saleDAO(b);
		
		try {
			s.addSale();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		product p = new product(1, "Teclado", "Teclado inalambrico", 15, 8.5, "125-125", LocalDate.now(), true);
//		System.out.println(p.toString());
//		connectionBBDD q = new connectionBBDD();
//		try {
//			q.openConn();
//			q.setQuery(String.format("INSERT INTO shop.cliente values (null,'%s','%s','%s','%s','%s','%s',true);",
//					"pepe", "pepes.com", "1752809705", "0984744033", "villanueva", "2025-09-10", false));
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		productDAO pdao=new productDAO(
//				new product(1, "Monitos curvo", "monitor de 21 marca del",2,359.99,"12-147",LocalDate.now(),true));
//		try {
//			pdao.addProduct();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		productDAO pdao=new productDAO();
//		try {
//			pdao.deleteCodeProdcut("12-147");
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
//		try {
//			pdao.deleteIdProdcut(6);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		productDAO pdao1=new productDAO();
//		try {
//			List <product>products=pdao1.allproducts();
//			for(var p:products) {
//				
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		productDAO pdao2=new productDAO();
		
		try {
			product p=pdao2.searchProduct("12-147");
			if(p!=null) {
				System.out.println(p.getNameProduct()+"\t"+p.getPrice());
			}else {
				System.out.println("producto no existente");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
