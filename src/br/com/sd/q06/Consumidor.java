/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q06;

/**
 *
 * @author Hakkinen
 */
public class Consumidor extends Thread{
    
    private BoundedBuffer buffer;

    public Consumidor(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (buffer){
            for (int i = 0; i < 100; i++) {
                System.out.println(buffer.pop());
            }
            notify();
        }
    }
    
    
    
}
