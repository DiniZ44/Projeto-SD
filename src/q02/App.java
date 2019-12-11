/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q02;

/**
 *
 * @author Hakkinen
 */
public class App {
    
public static void main(String[] args) {


        PrincipalThread t = new PrincipalThread(30, 5);
        t.start();
}

    
}
