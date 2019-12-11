/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q06;

/**
 *
 * @author Hakkinen
 */
public class ProdutorConsumidorMOD {
    
    public static BoundedBuffer buffer = new BoundedBuffer(100); 
	
	public static void main(String[] args) {
		Runnable produtor = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 100000; i++){
					buffer.push(i);
				}

			}
		};
		Runnable consumidor = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 100; i++){
					System.out.println(buffer.pop());
				}
			}
		};

		new Thread(produtor).start();
		new Thread(consumidor).start();
	}
    
}
