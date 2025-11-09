package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.logic_view_menu;

public class view_tienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_client_nombre;
	public JTextField txt_nombreProducto;
	public JTextField txt_client_email;
	public JTextField txt_client_cedula;
	public JTextField txt_client_telefono;
	public JButton btn_client_eliminar;
	public JButton btn_client_guardar;
	public JButton btn_client_editar;
	public JTextArea txt_descripcionProducto;
	public JSpinner spn_unidadesProducto;
	public JTextField txt_costo;
	public JButton btn_guardarP;
	public JTextField txt_sale_cedula;
	public JTextField txt_codigo_prod;
	public JButton btn_cliente;
	public JButton btn_producto;
	public JButton btn_compra;
	public JPanel panel_2;
	public JPanel panel_3;
	public JPanel panel_1;
	public JButton btn_editarP;
	public JButton btn_eliminar_product;
	public JTabbedPane tabla_pn;
	public JButton btn_añadirP;
	public JButton btn_guardar_sale;
	public JTextArea txt_client_direccion;
	public  JTextField txt_sale_product;
	public  JTable tbl_sale;
	public  JLabel lbl_sale_total;
	public  JLabel lblNewLabel_2;
	public  JLabel lblCedula_1_1_2;
	public  JLabel lblCedula_1_2;
	public  JLabel lblCedula_2;
	public  JTextField txt_sale_subtot;
	public  JTextField txt_sale_iva;
	public  JTextField txt_sale_total;
	public  JTable tbl_products;

	public DefaultTableModel modelProduct;
	public DefaultTableModel modelSale;
	public JButton btn_añadir_client;
	public JButton btn_sale_ced;
	public  JButton btn_sale_product;
	public JLabel lbl_email_client;
	public JLabel lbl_name_client_sale;
	public JLabel lbl_name_product_sale;
	public JLabel lbl_name_client_2;
	public JLabel lbl_stock_sale;
	public JLabel lbl_name_product_1;
	public JLabel lbl_precio_sale;
	public JSpinner spn_sale_cantidad;
	public JButton btn_sale_addProduct;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_tienda frame = new view_tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public view_tienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(130, 200, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 148, 125));
		panel.setBounds(10, 10, 122, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_cliente = new JButton("New button");
		btn_cliente.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/cliente.png")).getImage().getScaledInstance(113, 81, Image.SCALE_SMOOTH)));
		btn_cliente.setBounds(10, 10, 102, 81);
		panel.add(btn_cliente);

		
		btn_compra = new JButton("New button");
		btn_compra.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/compra.png")).getImage().getScaledInstance(113, 81, Image.SCALE_SMOOTH)));
		btn_compra.setBounds(10, 213, 102, 81);
		panel.add(btn_compra);

		
		btn_producto = new JButton("New button");
		btn_producto.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/producto.png")).getImage().getScaledInstance(113, 81, Image.SCALE_SMOOTH)));
		btn_producto.setBounds(10, 111, 102, 81);
		panel.add(btn_producto);

		
		tabla_pn = new JTabbedPane(JTabbedPane.TOP);
		tabla_pn.setBounds(163, 10, 461, 321);
		contentPane.add(tabla_pn);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 218, 235));
		tabla_pn.addTab("CLIENT", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(26, 21, 74, 13);
		panel_1.add(lblNewLabel);
		
		txt_client_nombre = new JTextField();
		txt_client_nombre.setBounds(110, 17, 241, 19);
		panel_1.add(txt_client_nombre);
		txt_client_nombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(26, 51, 56, 13);
		panel_1.add(lblEmail);
		
		txt_client_email = new JTextField();
		txt_client_email.setColumns(10);
		txt_client_email.setBounds(110, 47, 241, 19);
		panel_1.add(txt_client_email);
		
		JLabel lblCedula = new JLabel("CEDULA");
		lblCedula.setBounds(26, 88, 56, 13);
		panel_1.add(lblCedula);
		
		txt_client_cedula = new JTextField();
		txt_client_cedula.setColumns(10);
		txt_client_cedula.setBounds(110, 84, 241, 19);
		panel_1.add(txt_client_cedula);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(26, 129, 74, 13);
		panel_1.add(lblTelefono);
		
		txt_client_telefono = new JTextField();
		txt_client_telefono.setColumns(10);
		txt_client_telefono.setBounds(110, 125, 241, 19);
		panel_1.add(txt_client_telefono);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(26, 158, 74, 13);
		panel_1.add(lblDireccion);
		
		btn_client_guardar = new JButton("");
		btn_client_guardar.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/guardar.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_client_guardar.setBounds(393, 71, 40, 40);
		panel_1.add(btn_client_guardar);

		
		btn_client_editar = new JButton("");
		btn_client_editar.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/editar.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_client_editar.setBounds(393, 122, 40, 40);
		panel_1.add(btn_client_editar);

		
		btn_client_eliminar = new JButton("");
		btn_client_eliminar.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/regresar.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_client_eliminar.setBounds(393, 177, 40, 40);
		panel_1.add(btn_client_eliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 168, 228, 120);
		panel_1.add(scrollPane);
		
		txt_client_direccion = new JTextArea();
		scrollPane.setViewportView(txt_client_direccion);
		
		btn_añadir_client = new JButton("");
		btn_añadir_client.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/anadir.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_añadir_client.setBounds(393, 17, 40, 40);
		panel_1.add(btn_añadir_client);

		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(214, 244, 183));
		tabla_pn.addTab("PRODUCT", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE PRODUCTO");
		lblNewLabel_1.setBounds(36, 26, 141, 13);
		panel_2.add(lblNewLabel_1);
		
		txt_nombreProducto = new JTextField();
		txt_nombreProducto.setBounds(187, 23, 159, 19);
		panel_2.add(txt_nombreProducto);
		txt_nombreProducto.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("DESCRIPCION");
		lblNewLabel_1_1.setBounds(36, 56, 141, 13);
		panel_2.add(lblNewLabel_1_1);
		
		txt_descripcionProducto = new JTextArea();
		txt_descripcionProducto.setBounds(187, 52, 159, 52);
		panel_2.add(txt_descripcionProducto);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("UNIDADES");
		lblNewLabel_1_1_1.setBounds(36, 118, 96, 13);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("COSTO");
		lblNewLabel_1_1_1_1.setBounds(222, 118, 75, 13);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		spn_unidadesProducto = new JSpinner();
		spn_unidadesProducto.setBounds(124, 115, 58, 20);
		panel_2.add(spn_unidadesProducto);
		
		txt_costo = new JTextField();
		txt_costo.setBounds(267, 114, 96, 19);
		panel_2.add(txt_costo);
		txt_costo.setColumns(10);
		
		btn_guardarP = new JButton("");
		btn_guardarP.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/guardar.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_guardarP.setBounds(406, 56, 40, 40);
		panel_2.add(btn_guardarP);
		
		btn_editarP = new JButton("");
		btn_editarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_editarP.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/editar.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_editarP.setBounds(406, 106, 40, 40);
		panel_2.add(btn_editarP);

		
		btn_eliminar_product = new JButton("");
		btn_eliminar_product.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource("/imagenes/regresar.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_eliminar_product.setBounds(406, 156, 40, 40);
		panel_2.add(btn_eliminar_product);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("CODIGO DEL PRODUCTO");
		lblNewLabel_1_1_1_2.setBounds(36, 147, 202, 13);
		panel_2.add(lblNewLabel_1_1_1_2);
		
		txt_codigo_prod = new JTextField();
		txt_codigo_prod.setBackground(new Color(145, 193, 30));
		txt_codigo_prod.setEditable(false);
		txt_codigo_prod.setBounds(248, 143, 115, 20);
		panel_2.add(txt_codigo_prod);
		txt_codigo_prod.setColumns(10);
		
		btn_añadirP = new JButton("");
		btn_añadirP.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource("/imagenes/anadir.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn_añadirP.setBounds(406, 11, 40, 40);
		panel_2.add(btn_añadirP);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(23, 170, 377, 114);
		panel_2.add(scrollPane_2);
		
		tbl_products = new JTable();
		
		this.modelProduct= new DefaultTableModel();
		
		scrollPane_2.setViewportView(tbl_products);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(189, 201, 234));
		tabla_pn.addTab("SALE", null, panel_3, null);
		panel_3.setLayout(null);
		
		txt_sale_cedula = new JTextField();
		txt_sale_cedula.setColumns(10);
		txt_sale_cedula.setBounds(97, 20, 121, 19);
		panel_3.add(txt_sale_cedula);
		
		JLabel lblCedula_1 = new JLabel("CEDULA");
		lblCedula_1.setBounds(22, 23, 56, 13);
		panel_3.add(lblCedula_1);
		
		btn_guardar_sale = new JButton("");
		btn_guardar_sale.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource("/imagenes/verificar.png")).getImage().getScaledInstance(54, 54, Image.SCALE_SMOOTH)));
		btn_guardar_sale.setBounds(387, 230, 54, 54);
		panel_3.add(btn_guardar_sale);
		
		JLabel lblCedula_1_1 = new JLabel("PRODUCTO");
		lblCedula_1_1.setBounds(22, 52, 125, 13);
		panel_3.add(lblCedula_1_1);
		
		txt_sale_product = new JTextField();
		txt_sale_product.setColumns(10);
		txt_sale_product.setBounds(98, 49, 120, 19);
		panel_3.add(txt_sale_product);
		
		JLabel lblCedula_1_1_1 = new JLabel("CANTIDAD");
		lblCedula_1_1_1.setBounds(22, 78, 125, 13);
		panel_3.add(lblCedula_1_1_1);
		
		spn_sale_cantidad = new JSpinner();
		spn_sale_cantidad.setBounds(115, 75, 103, 20);
		panel_3.add(spn_sale_cantidad);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 116, 424, 104);
		panel_3.add(scrollPane_1);
		
		tbl_sale = new JTable();
		this.modelSale= new DefaultTableModel();
		
		scrollPane_1.setViewportView(tbl_sale);
		
		lbl_sale_total = new JLabel("0.0");
		lbl_sale_total.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbl_sale_total.setBounds(59, 230, 195, 54);
		panel_3.add(lbl_sale_total);
		
		lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_2.setBounds(32, 230, 45, 53);
		panel_3.add(lblNewLabel_2);
		
		lblCedula_1_1_2 = new JLabel("TOTAL:");
		lblCedula_1_1_2.setBounds(214, 271, 135, 13);
		panel_3.add(lblCedula_1_1_2);
		
		lblCedula_1_2 = new JLabel("IVA:");
		lblCedula_1_2.setBounds(214, 244, 125, 19);
		panel_3.add(lblCedula_1_2);
		
		lblCedula_2 = new JLabel("SUBTOTAL:");
		lblCedula_2.setBounds(202, 226, 86, 13);
		panel_3.add(lblCedula_2);
		
		txt_sale_subtot = new JTextField();
		txt_sale_subtot.setBounds(284, 223, 93, 19);
		panel_3.add(txt_sale_subtot);
		txt_sale_subtot.setColumns(10);
		
		txt_sale_iva = new JTextField();
		txt_sale_iva.setColumns(10);
		txt_sale_iva.setBounds(284, 244, 93, 19);
		panel_3.add(txt_sale_iva);
		
		txt_sale_total = new JTextField();
		txt_sale_total.setColumns(10);
		txt_sale_total.setBounds(284, 265, 93, 19);
		panel_3.add(txt_sale_total);
		
		btn_sale_ced = new JButton("");
		btn_sale_ced.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource("/imagenes/buscar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btn_sale_ced.setBounds(228, 19, 30, 21);
		panel_3.add(btn_sale_ced);
		
		btn_sale_product = new JButton("");
		btn_sale_product.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource("/imagenes/buscarP.png")).getImage().getScaledInstance(26, 20, Image.SCALE_SMOOTH)));
		btn_sale_product.setBounds(228, 48, 30, 21);
		panel_3.add(btn_sale_product);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(121, 147, 213));
		panel_4.setBounds(268, 10, 178, 89);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		lbl_name_client_sale = new JLabel("SIN DATOS DEL CLIENTE");
		lbl_name_client_sale.setBounds(10, 4, 168, 13);
		panel_4.add(lbl_name_client_sale);
		
		JLabel lbl_name_client_1 = new JLabel("EMAIL:");
		lbl_name_client_1.setBounds(10, 21, 41, 13);
		panel_4.add(lbl_name_client_1);
		
		lbl_email_client = new JLabel("SIN DATOS");
		lbl_email_client.setBounds(59, 21, 77, 13);
		panel_4.add(lbl_email_client);
		
		lbl_name_product_sale = new JLabel("SIN DATOS DEL PRODUCTO");
		lbl_name_product_sale.setBounds(10, 38, 185, 13);
		panel_4.add(lbl_name_product_sale);
		
		lbl_name_client_2 = new JLabel("STOCK:");
		lbl_name_client_2.setBounds(10, 66, 61, 13);
		panel_4.add(lbl_name_client_2);
		
		lbl_stock_sale = new JLabel("0");
		lbl_stock_sale.setBounds(66, 66, 70, 13);
		panel_4.add(lbl_stock_sale);
		
		lbl_name_product_1 = new JLabel("$");
		lbl_name_product_1.setBounds(10, 53, 16, 13);
		panel_4.add(lbl_name_product_1);
		
		lbl_precio_sale = new JLabel("0.0");
		lbl_precio_sale.setBounds(20, 53, 77, 13);
		panel_4.add(lbl_precio_sale);
		
		btn_sale_addProduct = new JButton("");
		this.btn_sale_addProduct.setIcon(new ImageIcon(new ImageIcon(view_tienda.class.getResource
				("/imagenes/add.png")).getImage().getScaledInstance(25, 15, Image.SCALE_SMOOTH)));
		btn_sale_addProduct.setBounds(228, 74, 30, 21);
		panel_3.add(btn_sale_addProduct);
		
		
		new logic_view_menu(this);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
}
