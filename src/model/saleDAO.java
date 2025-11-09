package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class saleDAO {

	private connectionBBDD conn= new connectionBBDD();
	private sale s;
	
	public saleDAO() {
		this.s= new sale();
	}

	public saleDAO(sale s) {
		super();
		this.s = s;
	}
	
	public boolean addSale() throws ClassNotFoundException, SQLException {
		return conn.setQuery(String.format("INSERT INTO shop.sale VALUES (NULL, '%S', '%s', '000-%05d');",
				s.getIDclient(),s.getcreateSale(), getUltimoId()+1,null));
	}
	
	public int getUltimoId() {
		String query = "SELECT MAX(id_sale) AS last_id FROM shop.sale";
		ResultSet res;
		try {
			res = conn.getQuery(query);
			if (res.next()) {
			    int lastId = res.getInt("last_id");
			    System.out.println("Último ID en la tabla: " + lastId);
			    return lastId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
