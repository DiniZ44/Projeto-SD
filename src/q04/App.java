/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q04;

import java.util.ArrayList;

/**
 *
 * @author Hakkinen
 */
public class App {
       
    @Deprecated
     public static void main(String[] args) {
         
        int n =2  ,x = 4;
         ArrayList<Contador> c = new ArrayList<>();
         
         Fila f = new Fila(n, x, c);
         f.filaControle();
        
         
         while (true) {             
             for (int i = 0; i < c.size(); i++) {
                 if(!c.get(i).isAlive()){
                     System.out.println("Ta parada");
                     for(int j = 0; i < c.size(); j++){
                         //c.get(j).destroy();
                     }
                     break;
                 }
             }
         }
     }
    
}
