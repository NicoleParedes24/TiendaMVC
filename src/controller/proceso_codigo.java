package controller;

public class proceso_codigo implements Runnable{

	private String code="0000-";
	private int numeros=0;
	
	@Override
	public void run() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(int i=1;i<=4;i++) {
			int n=(int) (Math.random()*10);
			code+=n;
		}
	}
	
	public String getCodigo() {
		return code;
	}

}
