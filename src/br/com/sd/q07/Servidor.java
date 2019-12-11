/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q07;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Hakkinen
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException {
        
    ServerSocket servidor = new ServerSocket(54400);
    System.out.println("Porta 54400 aberta!");

    Socket cliente = servidor.accept();
    System.out.println("Conexão com o cliente, estabelecida com sucesso!");
    System.out.println("Bem vindo cliente: "+cliente.getInetAddress().getHostAddress());

    Scanner mensagem = new Scanner(cliente.getInputStream());
    PrintStream saida = new PrintStream(cliente.getOutputStream());
    String msgCliente = "";
    while(mensagem.hasNextLine()) {
            msgCliente = mensagem.nextLine();
            System.out.println("Cliente mandou: "+ msgCliente);
            saida.println(msgCliente);
    }

    mensagem.close();
    saida.close();
    servidor.close();
    cliente.close();
}
    
}
