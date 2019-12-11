/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q01;

/**
 *
 * @author Hakkinen
 */
public class Contador {
    
    private static int tempo;

    public Contador(int tempo) {
        this.tempo = tempo;
    }
    
    public void decrementar (){
        if(tempo > 0){
            tempo --;
        }
    }

    public static int getTempo() {
        return tempo;
    }

    
}
