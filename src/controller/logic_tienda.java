package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.view_tienda;

public class logic_tienda implements KeyListener{

	private view_tienda vt;
	
	
	
	public logic_tienda(view_tienda vt) {
		super();
		this.vt = vt;
		
		this.vt.txt_nombreProducto.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e!=null) {
			System.out.println("se presiono una tecla");
			
			proceso_codigo proceso= new proceso_codigo();
			Thread hilo= new Thread(proceso);
			
		
		//	System.out.println("d");
			
				
				hilo.start();
				
				try {
					hilo.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			this.vt.txt_codigo_prod .setText(proceso.getCodigo());
		
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
