/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q06;

import q05.*;

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

	public void push(int v){
            System.out.println("Tamanho: " +tamanho);
            try {
                    valores[tamanho] = v;
                    tamanho++;
                    if(tamanho >= 100){
                            System.out.println("Valor máximo atingido! Sem espaço para inserção");
                            return;
                    }
            } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Erro de inserção");
                    System.exit(0);
            }
	}

	public int pop(){
		System.out.println("----------POP----------");
		int retorno = 0;
                
		if(tamanho == 0){
			System.out.println("Array vazio!");
			System.exit(0);
			return retorno;
		}
		retorno = valores[tamanho];
		valores[tamanho] = 0;
		tamanho--;
		return retorno;
	}
}
