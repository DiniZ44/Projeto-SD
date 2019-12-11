/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q07;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Hakkinen
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException{
        
        Socket cliente = new Socket("127.0.0.1", 54400);
        System.out.println("Conexão com o servidor, estabelecida com sucesso!");
        
        
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner entrada = new Scanner(cliente.getInputStream());

        while(true) {
            if(teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
            if(entrada.hasNextLine()) {
                System.out.print("\n Servidor - Cliente disse: "+entrada.nextLine()+"\n");
            }
        }


	}
    }
