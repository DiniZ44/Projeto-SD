/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q06;

import java.util.Stack;

/**
 *
 * @author Hakkinen
 */
public class ProdutorConsumidor {
    
    public static Stack<Integer> buffer = new Stack<Integer>();
	
	public static void main(String[] args) {
		Runnable produtor = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++){
					buffer.push(i);
				}
			}
		};
		Runnable cons = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++){
					System.out.println(buffer.pop());
				}
				
			}
		};
		
		new Thread(produtor).start();
		new Thread(cons).start();
	}
}
