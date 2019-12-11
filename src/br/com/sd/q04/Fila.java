/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q04;

import java.util.ArrayList;

/**
 *
 * @author Hakkinen
 */
public class Fila {
    
    	private int n ,x;
	private ArrayList<Contador> c = new ArrayList<>();
	
	public Fila(int n, int x, ArrayList<Contador> c) {
		this.n = n;
		this.x = x;
		this.c = c;
	}

	public void filaControle(){
		for(int i = 0; i < n; i++){
			c.add(new Contador(x, i));
		}
	}

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ArrayList<Contador> getC() {
        return c;
    }

    public void setC(ArrayList<Contador> c) {
        this.c = c;
    }
    
}
