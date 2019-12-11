/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q10_9;

import br.com.sd.q10_8.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

/**
 *
 * @author Hakkinen
 */
public class Cliente2 {


	private String nome;
	private String host;
	private int porta;

	public Cliente2(String nome, String host, int porta) {
		this.nome = nome;
		this.host = host;
		this.porta = porta;
	}

	public void rodar() throws IOException {
            DatagramSocket cliente = new DatagramSocket(this.porta);
            System.out.println("O cliente " + this.nome + " esperando pacote na porta "+ cliente.getLocalPort());			
            byte[] dadosRecebidos = new byte[1024];			
            while(true){
            String mensagemRecebida = "";
            DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);			
            cliente.receive(pacoteRecebido);			
            mensagemRecebida = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
            System.out.println(mensagemRecebida);
            }

	}
        public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
            new Cliente2("Cliente2", "localhost", 6789).rodar();

	}

    
}
