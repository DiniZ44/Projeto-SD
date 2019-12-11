/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q05;

/**
 *
 * @author Hakkinen
 */
public class BoundedBuffer {
    
    	public static int[] valores;
	public static int tamanho;
	
	public BoundedBuffer(int tamanho) {
		valores = new int[tamanho];
	}

	public void put(int v){
		try {
                        valores[tamanho] = v;
			tamanho++;
			System.out.println("Tamanho: " + tamanho);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro de inserção! Lista cheia");
		}
	}

	public int get(){
		if(tamanho == 0){
			System.out.println("Array vazio!");
			return 0;
		}
		return valores[tamanho];
	}
}
