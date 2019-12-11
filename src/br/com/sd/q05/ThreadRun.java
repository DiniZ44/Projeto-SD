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
public class ThreadRun extends Thread{
    
    private BoundedBuffer boundedBuffer;
    private int thread;

    public ThreadRun(BoundedBuffer boundedBuffer, int thread) {
        this.boundedBuffer = boundedBuffer;
        this.thread = thread;
        
        start();
    }

    @Override
    public void run() {
        while(true){
        try {
                sleep(1000);
                System.out.println("Thread: " + thread);
                boundedBuffer.put(4);
                //buffer.get();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

}
    }
    
    
}
