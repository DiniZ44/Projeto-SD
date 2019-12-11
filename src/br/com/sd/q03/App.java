/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q03;

import java.util.ArrayList;

/**
 *
 * @author Hakkinen
 */
public class App {
    public static void main(String[] args) {
    
    int n = 2, x = 4, global = 0;
    
        ArrayList<Contador> c = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            c.add(new Contador(x, i));
        }
        
     ArrayList<Global> g = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            g.add(new Global(x, n, global));
            
        }
    }
    
}
