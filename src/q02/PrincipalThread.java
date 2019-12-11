/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q02;

import java.util.ArrayList;

/**
 *
 * @author Hakkinen
 */
public class PrincipalThread extends Thread{
    
    private int primo, threads;
    
    private ArrayList<Integer> numerosPrimos = new ArrayList<>();
    private ArrayList<SecundariaThread> secundarias = new ArrayList<>();

    public PrincipalThread(int primo, int threads) {
        this.primo = primo;
        this.threads = threads;
    }

    @Override
    public void run() {
        
        int i = 0;
        int salto = (primo/threads);
        for (int j = 1; j+1 <= primo; j = (salto *i) + 1) {
            i++;
            secundarias.add(new SecundariaThread(j, (i*salto)));
        }
        
        
        while (true) {            
            boolean finall = false;
            for(SecundariaThread s: secundarias){
                if(s.isAlive()){
                    finall = false;
                    break;
                }else{
                finall = true;
                }
            }
            
            if(finall){
                for(int j = 0; j < secundarias.size(); j++){
                numerosPrimos.addAll(secundarias.get(j).getValores());
            }

            for(int valor : numerosPrimos){
                    System.out.println("Segue o(s) Número(s) primo(s): " + valor);
            }
            break;
            }
        }
    }
    
    
    
}
