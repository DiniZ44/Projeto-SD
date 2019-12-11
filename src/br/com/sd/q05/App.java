/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q05;

/**
 *
 * @author Hakkinen
 */
public class App {
    
    public static void main(String[] args) {
        
        BoundedBuffer buffer = new BoundedBuffer(10);
        
        ThreadRun r1 = new ThreadRun(buffer, 1);
        ThreadRun r2 = new ThreadRun(buffer, 2);
        ThreadRun r3 = new ThreadRun(buffer, 3);
        ThreadRun r4 = new ThreadRun(buffer, 4);
    }
    
}
