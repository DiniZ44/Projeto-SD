/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q06;

/**
 *
 * @author Hakkinen
 */
public class Produtor {
    public static void main(String[] args) {
            int valorInserir = 6;
            BoundedBuffer buffer = new BoundedBuffer(100);
            Consumidor consumidor = new Consumidor(buffer);
            buffer.push(valorInserir);
            consumidor.start();

            while(true){
            synchronized (consumidor) {
                try {
                        buffer.push(valorInserir);
                        buffer.wait();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        }
    }
}
