/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q03;

/**
 *
 * @author Hakkinen
 */
public class Global extends Thread{
    
    private int global, limite, threads;

    public Global(int global, int limite, int threads) {
        this.global = global;
        this.limite = limite;
        this.threads = threads;
        
        start();
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= limite) {            
             System.out.println("Esta Thread de número: "+threads+" Com valor Global: "+global);
             global++;
             i++;
        }
    }
    
    
    
}
