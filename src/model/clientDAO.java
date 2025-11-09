package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class clientDAO {
	private connectionBBDD conn= new connectionBBDD();
	private client c;
	
	public clientDAO() {
		this.c= new client();
	}
	
	public clientDAO(client c) {
		this.c= c;
	}
	
	public boolean addClient() throws ClassNotFoundException, SQLException {
		return conn.setQuery(String.format("insert into shop.client  values(null,'%s','%s','%d','%d','%s','%s',true);", 
				c.getName(),
				c.getEmail(),
				c.getCedula(),
				c.getPhone(),
				c.getAddres().toString(),
				c.getFecha()
				,null));
	}
	
	
	public boolean updateClient() throws ClassNotFoundException, SQLException {
		System.out.println(c.getName());
		return conn.setQuery(String.format("update shop.client set name_client='%s', email='%s',phone='%d',address='%s' where dni='%s'",
				c.getName(),c.getEmail(),c.getPhone(),c.getAddres(),c.getCedula()
				));
	}
	
	public boolean deleteClient() throws ClassNotFoundException, SQLException {
		return conn.setQuery(String.format("update shop.client set state=false where dni='%d';",c.getCedula(), null));
	}
	public boolean deleteClient(int dni) throws ClassNotFoundException, SQLException {
		return conn.setQuery(String.format("update shop.client set state=false where dni='%d';",dni, null));
	}
	
	public List<client> allClient() throws ClassNotFoundException, SQLException{
		List<client> c=new ArrayList();	
		ResultSet res=conn.getQuery("SELECT * FROM shop.client;");
			while(res.next()) {
				client cl= new client();
				cl.setId(res.getInt(1));
				cl.setName(res.getString(2));
				cl.setEmail(res.getString(3));
				cl.setCedula(res.getInt(4));
				cl.setPhone(res.getInt(5));
				cl.setAdress(res.getString(6));
				cl.setFecha(LocalDate.parse(res.getString(7)));
				cl.setState(res.getBoolean(8));
				
				c.add(cl);
			}	
		return c;
	}
	public client getClient(ResultSet res) throws SQLException {
		client cl= new client();
		cl.setId(res.getInt(1));
		cl.setName(res.getString(2));
		cl.setEmail(res.getString(3));
		cl.setCedula(res.getInt(4));
		cl.setPhone(res.getInt(5));
		cl.setAdress(res.getString(6));
		cl.setFecha(LocalDate.parse(res.getString(7)));
		cl.setState(res.getBoolean(8));
		return cl;
	}
	public client searchByDni(int dni) throws ClassNotFoundException, SQLException {
		ResultSet res= conn.getQuery(String.format("select * from shop.client where dni='%d';",dni, null) );
		if(res.next()) {
			this.c= getClient(res);
		}else {
			c=null;
		}
		conn.closeConn();
		return c;
		
	}
}
