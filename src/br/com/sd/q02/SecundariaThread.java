/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q02;

import java.util.ArrayList;

/**
 *
 * @author Hakkinen
 */
public class SecundariaThread extends Thread{
    
    private int minimo, maximo;
    
    private ArrayList<Integer> valores = new ArrayList<>();

    public SecundariaThread(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
        
        start();
    }
    
    public void buscar(){
        for(int j = minimo; j < maximo; j++){
         if(isPrimo(j)){
             valores.add(j);
         }
        }
    }
    
    public boolean isPrimo (int i){
        if((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 7)){
            return true;
        } else if((Math.floorMod(i, 2) >= 1) && (Math.floorMod(i, 3) >= 1) && 
                (Math.floorMod(i, 5) >= 1) && (Math.floorMod(i, 7) >= 1)){
                return true;
        }
        return false;
    }

    @Override
    public void run() {
        buscar();
    }
    
    

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }
    
    
    
}
