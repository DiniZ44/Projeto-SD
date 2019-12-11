/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q10_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.jcp.xml.dsig.internal.dom.Utils;

/**
 *
 * @author Hakkinen
 */
public class Cliente1 {
	private String nome;
	private String host;
	private int porta;

	public Cliente1(String nome, String host, int porta) {
		this.nome = nome;
		this.host = host;
		this.porta = porta;
	}

	public void rodar() throws IOException {

		DatagramSocket cliente = new DatagramSocket();
		System.out.println("O cliente " + this.nome + " está na porta "+cliente.getLocalPort());
		InetAddress endereco = InetAddress.getByName(this.host);
		byte[] dadosEnvio = new byte[1024];
                while (true) {                
		BufferedReader mensagemCliente = new BufferedReader(new InputStreamReader(System.in));
		String mensagemEnviada = this.nome+": "+mensagemCliente.readLine();
                mensagemEnviada = Converter.converterMensagem(mensagemEnviada);
		dadosEnvio = mensagemEnviada.getBytes();
		DatagramPacket pacoteEnvio = new DatagramPacket(dadosEnvio, dadosEnvio.length, endereco, this.porta);		
		cliente.send(pacoteEnvio);
                }
	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new Cliente1("Cliente1", "localhost", 6789 ).rodar();

	}
}
