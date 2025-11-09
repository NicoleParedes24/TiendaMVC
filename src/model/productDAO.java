package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class productDAO {
	private product p;
	private connectionBBDD conn = new connectionBBDD();

	public productDAO(product p) {
		super();
		this.p = p;
	}
	
	public productDAO() {
		super();
		p=new product();
	}

	public boolean guardarNuevoStock(int stock, String code) {
		try {
			return conn.setQuery(String.format("update shop.product set stock=stock-'%d' where code='%s';",
					stock,code, null));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addProduct() throws ClassNotFoundException, SQLException {
		return conn.setQuery(String.format("INSERT INTO shop.product values (null,'%s','%s','%d','%s','%s','%s',true);",
				p.getNameProduct(),
				p.getdescProduct(),
				p.getStock(),
				String.valueOf(p.getPrice()),
				p.getCreate().toString(),
				p.getCode()
				));
	}
	public boolean updateProduct() throws ClassNotFoundException, SQLException {		 
		 return conn.setQuery(String.format("update shop.product set name_product ='%s',description='%s',stock=%d,price='%s' where code='%s';",
				 																	p.getNameProduct(),
			 																	p.getCode()));
	 }
	
	public boolean deleteProduct() throws ClassNotFoundException, SQLException {
		 // delete from shop.product where id_product='%s';
		//System.out.println("ddd");
		System.out.println(p.getIdProduct()+"id");
		 return conn.setQuery(String.format("delete from shop.product where id_product='%s';",p.getIdProduct()
				 ));
	 }
	
	public boolean deleteByCodeProdcut(String code) throws ClassNotFoundException, SQLException {
		return conn.setQuery(
				String.format("update shop.product set state =false where code ='%s';",code));
	}
	public boolean deleteByIdProdcut(int digit) throws ClassNotFoundException, SQLException {
			return conn.setQuery(
					String.format("update shop.product set state =false where id_product ='%d';",digit));
	}
	public List<product> allproducts() throws ClassNotFoundException, SQLException{
		List<product> products=new ArrayList<product>();	
		ResultSet res=conn.getQuery("SELECT * FROM shop.product;");
			while(res.next()) {
				product pro= new product();
				pro.setIdproduct(res.getInt(1));
				pro.setNameProduct(res.getString(2));
				pro.setdesProduct(res.getString(3));
				pro.setStock(res.getInt(4));
				pro.setPrice(res.getDouble(5));
				pro.setCreate(LocalDate.parse(res.getString(6)));
				//pro.setCreate(res.getDate(6).toLocalDate());//alternativa a fechas
				pro.setcode(res.getString(7));
				pro.setState(res.getBoolean(8));
				products.add(pro);
			}	
		return products;
	}
	public product getProduct(ResultSet res) throws ClassNotFoundException, SQLException{
				product pro= new product();
				pro.setIdproduct(res.getInt(1));
				pro.setNameProduct(res.getString(2));
				pro.setdesProduct(res.getString(3));
				pro.setStock(res.getInt(4));
				pro.setPrice(res.getDouble(5));
				pro.setCreate(LocalDate.parse(res.getString(6)));
				//pro.setCreate(res.getDate(6).toLocalDate());//alternativa a fechas
				pro.setcode(res.getString(7));
				pro.setState(res.getBoolean(8));			
		return pro;
	}
	public  synchronized product searchProduct(String code) throws ClassNotFoundException, SQLException {	 
		ResultSet res=conn.getQuery(String.format("SELECT*FROM shop.product where code='%s';", code));
		if(res.next()) {
			p=getProduct(res);
		}else {
			p=null;
		}
		conn.closeConn();
		return p;
	 }
	
	
}
