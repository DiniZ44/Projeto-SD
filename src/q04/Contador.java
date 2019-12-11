/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q04;

import java.util.logging.Level;
import java.util.logging.Logger;
import q03.*;

/**
 *
 * @author Hakkinen
 */
public class Contador extends Thread{
    
    private int valor, limite, threads;

    public Contador(int limite, int threads) {
        this.limite = limite;
        this.threads = threads;
        
        start();
    }

    @Override
    public void run() {
        while(valor <= limite){
            try { 
                sleep(1);
                System.out.println("Esta Thread de número: "+threads+" Com valor: "+valor);
                valor++;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }
    
    
    
    
    
    
    
}
