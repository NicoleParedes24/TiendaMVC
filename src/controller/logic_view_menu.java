package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.client;
import model.clientDAO;
import model.configurable;
import model.product;
import model.productDAO;
import model.sale;
import model.saleDAO;
import view.view_tienda;

public class logic_view_menu implements ActionListener, configurable{
	private view_tienda vt;
	private int type,typeP;
	private int idSale=0;

	private List<product>lp=new ArrayList();
	public logic_view_menu(view_tienda vt) {
		super();
		this.vt = vt;
		vt.btn_cliente.addActionListener(this);
		vt.btn_compra.addActionListener(this);
		vt.btn_producto.addActionListener(this);
		
		//cliente
		vt.btn_client_guardar .addActionListener(this);
		vt.btn_client_editar .addActionListener(this);
		vt.btn_client_eliminar .addActionListener(this);
		vt.btn_añadir_client.addActionListener(this);
		//producto
		vt.btn_guardarP.addActionListener(this);
		vt.btn_editarP.addActionListener(this);
		vt.btn_añadirP.addActionListener(this);
		vt.btn_eliminar_product.addActionListener(this);
		//sale
		vt.btn_sale_ced.addActionListener(this);
		vt.btn_sale_product.addActionListener(this);
		vt.btn_guardar_sale.addActionListener(this);
		vt.btn_sale_addProduct.addActionListener(this);
		
		vt.txt_sale_cedula.setEnabled(false);
		vt.tabla_pn.setVisible(false);
		stateFields(false, 1);
		stateFields(false,2);
		stateFields(false,3);
		
		//cargar tbls
		try {
			tblProducts();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vt.tabla_pn.setVisible(true);
		if(e.getSource()==vt.btn_cliente) {
	        vt.tabla_pn.setSelectedIndex(0); 
		}else if(e.getSource()==vt.btn_compra) {
			vt.tabla_pn.setSelectedIndex(2);
		}else if(e.getSource()==vt.btn_producto) {
			vt.tabla_pn.setSelectedIndex(1);
			
		}else if(e.getSource()==vt.btn_añadirP) {
			//generar codigo
			Thread generarCode=new process_code("000",vt);
			generarCode.start();
			stateFields(true, 1);
			type=1;
		}else if(e.getSource()==vt.btn_guardarP) {
			
			//productDAO pdao= new productDAO(loadfieldProduct());
			
				if(saveProduct(type)) {
					JOptionPane.showMessageDialog(vt, "Registro Exitoso","Registro Producto",JOptionPane.INFORMATION_MESSAGE);
					stateFields(false,1);
					
				}else {
					JOptionPane.showMessageDialog(vt, "Registro Fallido","Registro Producto",JOptionPane.INFORMATION_MESSAGE);
				}
			
				try {
					tblProducts();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		else if(e.getSource()==vt.btn_editarP ) {
			try {
				loadDataFieldsProduct(pdao.searchProduct(getValueSearch("codigo del producto")));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(e.getSource()==vt.btn_editarP) {
				type=2;
				
			}
			
			saveProduct(type);
			
			
		}else if(e.getSource()==vt.btn_eliminar_product) {
			String codigo=JOptionPane.showInputDialog("Codigo del producto: ");
			productDAO pdao= new productDAO();
			try {
				if(pdao.deleteByCodeProdcut(codigo)) {
					JOptionPane.showMessageDialog(vt, "Producto eliminado con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(vt, "Error al eliminar el producto","Informacion",JOptionPane.ERROR_MESSAGE);
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		//clienteeeBOTONES
		if(e.getSource()==vt.btn_añadir_client) {
			stateFields(true,2);
			typeP=1;
			
		}else if(e.getSource()==vt.btn_client_guardar) {
			if(saveClients(typeP)) {
				JOptionPane.showMessageDialog(vt, "Registro Exitoso","Registro Cliente",JOptionPane.INFORMATION_MESSAGE);
				stateFields(false,2);
			}else {
				JOptionPane.showMessageDialog(vt, "Registro Fallido","Registro Cliente",JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource()==vt.btn_client_editar) {
			try {
				loadDataFieldsClient(cdao.searchByDni(Integer.valueOf(getValueSearch("Cedula del cliente: "))));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("fff");
			typeP=2;
			saveClients(2);
		}else if(e.getSource()==vt.btn_client_eliminar) {
			Integer dni=Integer.valueOf(JOptionPane.showInputDialog("Digite la cedula del cliente: "));
			clientDAO cda= new clientDAO();
			
			try {
				boolean band=false;
				for(var a:cdao.allClient()) {
					if(a.getCedula()==dni) {
						band=true;
					}
				}
				if(!band) {
					JOptionPane.showMessageDialog(vt, "Cliente inexistente","Informaicon",JOptionPane.ERROR_MESSAGE);
					return ;
				}else if(cdao.deleteClient(dni)) {
					System.out.println("ee");
					JOptionPane.showMessageDialog(vt, "Cliente eliminado con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		//saleeeee
		if(e.getSource()==vt.btn_sale_ced) {
			int cedula=Integer.valueOf(getValueSearch("Ingrese su cedula: "));
			try {
				if(cdao.searchByDni(cedula)==null) {
					JOptionPane.showMessageDialog(vt, "Cedula NO existente","Informacion",JOptionPane.ERROR_MESSAGE);
					
				}else if(cdao.searchByDni(cedula)!=null) {
					if(cedula==cdao.searchByDni(cedula).getCedula()) {
						datosSalelblClient(cedula);
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==vt.btn_sale_product) {
			
			try {
				datosSaleProduct(vt.txt_sale_product.getText());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()==vt.btn_sale_addProduct) {
		
			System.out.println("antes");
			int n= (int) (vt.spn_sale_cantidad.getValue());
				guardarDetail(idSale,vt.txt_sale_product.getText(),
						n);
				tblSale();
				try {
					tblProducts();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		
		//si se guarda ya se borra todoSALE
		if(e.getSource()==vt.btn_guardar_sale) {
			
			JOptionPane.showMessageDialog(vt, "COMPRA REALIZADA CON EXITO","compra",JOptionPane.INFORMATION_MESSAGE);
			cleanDatosSale();
			limpiarSale();
			stateFields(false,3);
		}
	}
	
	private void limpiarSale() {
		this.vt.modelSale.setRowCount(0);
		this.vt.modelSale.setColumnCount(0);
		
		
		this.vt.tbl_sale.setModel(vt.modelSale);
		vt.modelSale.addColumn("Producto");
		vt.modelSale.addColumn("Unidades");
		vt.modelSale.addColumn("PVP");
		vt.modelSale.addColumn("Total");
	}
	private void limpiarProducto() {
		vt.lbl_name_product_sale.setText("SIN DATOS DEL PRODUCTO");
		vt.spn_sale_cantidad.setValue(0);
		vt.txt_sale_product.setText("");
		vt.lbl_stock_sale.setText("");
		vt.lbl_precio_sale.setText("");
	}
	
	public void tblSale() {

		this.vt.modelSale.setRowCount(0);
		this.vt.modelSale.setColumnCount(0);
		
		
		this.vt.tbl_sale.setModel(vt.modelSale);
		vt.modelSale.addColumn("Producto");
		vt.modelSale.addColumn("Unidades");
		vt.modelSale.addColumn("PVP");
		vt.modelSale.addColumn("Total");

		
		
		
		List<product>prs= lp;
		System.out.println("tma"+lp.size());
		Object[]fila= new Object[4]; //vt.model.addRow(fila);
		double subtotal=0;
		for(product po:prs) {
			if(po.getState()==true) {
				fila[0]=po.getNameProduct();
				fila[1]=po.getStock();
				fila[2]=String.format("%.2f",po.getPrice());
				double total=Double.valueOf(fila[2].toString())*po.getStock() ;
				subtotal+=total;
				fila[3]=total;
				vt.modelSale .addRow(fila);
			}
			
		}
		System.out.println("subt"+subtotal);
		
		vt.txt_sale_subtot.setText( String.valueOf(subtotal));
		double iva=subtotal*12/100;
		vt.txt_sale_iva.setText(String.format("%.2f", iva));
		double total= iva+subtotal;
		vt.txt_sale_total.setText(String.format("%.2f", total));
		vt.lbl_sale_total.setText(String.format("%.2f", total));
		
		
	}
	
	
	public void lstProductosADD(product pq){
		this.lp.add(pq);		
	}
	//guardarNuevoStock(int stock, String code)
	private void guardarDetail(int idSale, String code, int cantidad) {
		System.out.println("llego aqui");
		
		product prod;
		try {
			prod = pdao.searchProduct(code);
			if(cantidad>prod.getStock()) {
				JOptionPane.showMessageDialog(vt, "No hay suficiente stock","informacion",JOptionPane.ERROR_MESSAGE);
			}else {
				if(pdao.guardarNuevoStock(cantidad, code)) {
					
					
					JOptionPane.showMessageDialog(vt, "Stock actualizado","informacion",JOptionPane.INFORMATION_MESSAGE);
					prod.setStock(cantidad);
					lstProductosADD(prod);
					limpiarProducto();
					
				}
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	//datos lblProduct
	private void datosSaleProduct(String code) throws ClassNotFoundException, SQLException {
		product pr=pdao.searchProduct(code);
		if(pr!=null) {
			vt.lbl_name_product_sale.setText(pr.getNameProduct());
			vt.lbl_precio_sale.setText( String.valueOf(pr.getPrice()));
			vt.lbl_stock_sale.setText(String.valueOf(pr.getStock()));
			
		}else {
			JOptionPane.showMessageDialog(vt, "Codigo No existente","Error",JOptionPane.ERROR_MESSAGE);
			vt.txt_sale_product.setText("");
		}
		
	}
	
	private void añadirSale(client c) {
		sale s= new sale();
		s.setcreateSale(LocalDate.now());		
		s.setIDclient(c.getId()); 		
		saleDAO sdao= new saleDAO(s);
		try {
			sdao.addSale();
			idSale=s.getIDsale();
			idSale=sdao.getUltimoId()+1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//cargar datos del lblClientSale
	private void datosSalelblClient(int cedula) {
		client a= new client();
		
		try {
			a=cdao.searchByDni(cedula);
			
			vt.txt_sale_cedula.setText(String.valueOf(a.getCedula()));
			vt.lbl_email_client.setText(a.getEmail());
			vt.lbl_name_client_sale.setText(a.getName());
			stateFields(true,3);
			
			//añadir sale
			añadirSale(a);
		
			
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	private void cleanDatosSale() {
		vt.lbl_name_client_sale.setText("SIN DATOS DEL CLIENTE");
		limpiarProducto() ;
		this.vt.lbl_email_client.setText("SIN DATOS");
		vt.lbl_sale_total.setText("0.0");
		vt.lbl_sale_total.setText("0.0");
		vt.txt_sale_cedula.setText("");
		vt.txt_sale_iva.setText("0.0");
		vt.txt_sale_subtot.setText("0.0");
		vt.txt_sale_total.setText("0.0");
		
	}
	
	//cargar la tabla de productos
	private void tblProducts() throws ClassNotFoundException, SQLException {
		
		this.vt.modelProduct.setRowCount(0);
		this.vt.modelProduct.setColumnCount(0);
		
		
		this.vt.tbl_products.setModel(vt.modelProduct);
		vt.modelProduct.addColumn("Producto");
		vt.modelProduct.addColumn("Descripcion");
		vt.modelProduct.addColumn("Codigo");
		vt.modelProduct.addColumn("Stock");
		vt.modelProduct.addColumn("Precio");

		
		
		
		List<product>prs= pdao.allproducts();
		
		Object[]fila= new Object[5]; //vt.model.addRow(fila);
		for(product po:prs) {
			if(po.getState()==true) {
				fila[0]=po.getNameProduct();
				fila[1]=po.getdescProduct();
				fila[2]=po.getCode();
				fila[3]=po.getStock();
				fila[4]=String.format("%.2f",po.getPrice());
				vt.modelProduct.addRow(fila);
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param type si type =1 añade,2 edita, 3 borra
	 * @return
	 */
	private boolean saveClients(int type) {
		clientDAO cdao= new clientDAO(loadfielClient());
		try {
			switch(type) {
			case 1:
					return cdao.addClient();	
			
			case 2:
				return cdao.updateClient();
				
			case 3:
				return cdao.deleteClient();
				
			default:
				break;
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean saveProduct(int type) {
		productDAO pdao= new productDAO(loadfieldProduct());
		try {
			switch(type) {
			case 1:
				//add product
					return pdao.addProduct();

			case 2:
				return pdao.updateProduct();
			case 3:
				
				
				return pdao.deleteByCodeProdcut(loadfieldProduct().getCode());
				
			default:
			break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Permite bloquear la edicion de los campos
	 * @param state sirve true-> activa los campos y false desactiva
	 * @param type sirve para saber que opcion se esta ejecutando type=1(product) type=2(client)
	 */
	private void stateFields(boolean state,int type) {
		switch (type) {
		case 1: 
			vt.txt_nombreProducto.setEnabled(state);
			vt.txt_descripcionProducto.setEnabled(state);
			vt.spn_unidadesProducto.setEnabled(state);
			vt.txt_costo.setEnabled(state);
			vt.btn_guardarP.setEnabled(state);
			cleanFields(1); 
			break;
		case 2:
			vt.txt_client_cedula.setEnabled(state);
			vt.txt_client_direccion.setEnabled(state);
			vt.txt_client_email.setEnabled(state);
			vt.txt_client_nombre.setEnabled(state);
			vt.txt_client_telefono.setEnabled(state);
			vt.btn_client_guardar.setEnabled(state);
			cleanFields(2);
			break;
		case 3:
			vt.btn_guardar_sale.setEnabled(state);
			vt.btn_sale_product.setEnabled(state);
			vt.spn_sale_cantidad.setEnabled(state);
			vt.txt_sale_product.setEnabled(state);
			vt.btn_sale_addProduct.setEnabled(state);
			break;
		}
	}
	private product loadfieldProduct() {
		product p =new product();
		p.setcode(vt.txt_codigo_prod .getText());
		p.setCreate(LocalDate.now());
		p.setdesProduct(vt.txt_descripcionProducto.getText());
		p.setNameProduct(vt.txt_nombreProducto.getText());
		p.setPrice(Double.parseDouble(vt.txt_costo.getText()));
		p.setStock((int)vt.spn_unidadesProducto.getValue());
		
		return p;
	}
	
	private client loadfielClient() {
		 client ct= new client();
		 ct.setAdress(vt.txt_client_direccion.getText());
		 ct.setCedula(Integer.valueOf(vt.txt_client_cedula.getText()));
		 ct.setEmail(vt.txt_client_email.getText());
		 ct.setFecha(LocalDate.now());
		 ct.setName(vt.txt_client_nombre.getText());
		 ct.setPhone(Integer.valueOf(vt.txt_client_telefono.getText()));
		 return ct;
		
	}
	
	/**
	 * Permiste limpiar los campos segun el tipo a ejecutar
	 * @param type
	 */
	private void cleanFields(int type) {
		switch(type) {
		case 1:
			vt.txt_codigo_prod.setText("");
			vt.txt_descripcionProducto.setText("");
			vt.txt_nombreProducto.setText("");
			vt.txt_costo.setText("");
			vt.spn_unidadesProducto.setValue(0);
			break;
		case 2:
			//campos del cliente
			vt.txt_client_cedula.setText("");
			vt.txt_client_direccion.setText("");
			vt.txt_client_email.setText("");
			vt.txt_client_nombre.setText("");
			vt.txt_client_telefono.setText("");
			break;
		}
		
		
	}
	
	/**
	 * permite obtener la cadena de caracteres que ingrese el usuario sea
	 * para codigo de producto o para numero de cedula
	 * @param msg
	 * @return
	 */
	private String getValueSearch(String msg) {
		return JOptionPane.showInputDialog(vt,msg,"Consultar inf",JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * permite cargar los datos consultados de un producto de los campos de la GUI
	 * @param p
	 */
	private void loadDataFieldsProduct(product p) {
		if(p!=null) {
		stateFields(true,1);
			vt.txt_nombreProducto.setText(p.getNameProduct());
			vt.txt_descripcionProducto.setText(p.getdescProduct());
			vt.txt_costo.setText(String.valueOf(p.getPrice()));
			vt.spn_unidadesProducto.setValue(p.getStock());
			vt.txt_codigo_prod.setText(p.getCode());
		}else {
			JOptionPane.showMessageDialog(vt, "Producto no existente","Consulta informacion",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadDataFieldsClient(client c) {
		if(c!=null) {
			stateFields(true,2);
			vt.txt_client_cedula.setText(String.valueOf(c.getCedula()));
			vt.txt_client_direccion.setText(c.getAddres());
			vt.txt_client_email.setText(c.getEmail());
			vt.txt_client_nombre.setText(c.getName());
			vt.txt_client_telefono.setText(String.valueOf(c.getPhone()));
		}else {
			JOptionPane.showMessageDialog(vt, "Cliente no existente","Consulta informacion",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean guardar() throws ClassNotFoundException, SQLException {
		product p= new product();
		int unidades=(int)vt.spn_unidadesProducto.getValue();
		String producto=vt.txt_nombreProducto.getText();
		String descripcion=vt.txt_descripcionProducto.getText();
		String codigo=vt.txt_codigo_prod .getText();
		double costo= Double.valueOf(vt.txt_costo.getText());
		p.setNameProduct(producto);
		p.setStock(unidades);
		p.setdesProduct(descripcion);
		p.setcode(codigo);
		p.setPrice(costo);
		p.setCreate(LocalDate.now());
		
		productDAO pda=new productDAO(p);
		return pda.addProduct();
		
		
	}
	
}
