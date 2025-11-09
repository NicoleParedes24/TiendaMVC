package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class test {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		// connection c= new connection ();
		// c.openConn();

		connectionBBDD q = new connectionBBDD();

		/*
		 * INSERTAR q.setQuery(String.
		 * format("INSERT INTO shop.client values (null,'%s','%s','%s','%s','%s','%s',true);"
		 * , "Charlote","charlote.com","122222","0984744033","villaflora","2025-09-9",
		 * false));
		 */

		/* borrar */
		// q.setQuery("DELETE FROM shop.client where id_client=5;");

		// CAMBIAR UN CAMPO cambiar el email y se pone de que id se quiere cambiar
		// q.setQuery(String.format("UPDATE shop.client SET email='%s ' where
		// id_client=%d","kenneth.gmail",3));
/*
		ResultSet res=null;;
		try {
			res = q.getQuery("SELECT * FROM shop.client;");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
//					int id=res.getInt("id_client");
//					String name=res.getString("name_client");
//					System.out.println("ID: "+id+" Name "+name);	
				System.out.println(res.getString(1) + "     " + res.getString(2) + "     " + res.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en el next del resultset");
			e.printStackTrace();
		}/
		
		productDAO pdao=new productDAO();
		try {
			for(var a: pdao.allproducts()) {
				System.out.println(a.getNameProduct());
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
