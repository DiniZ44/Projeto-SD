/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q09;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hakkinen
 */
public class Servidor {
    
	private int porta;
	private List<PrintStream> clientes;

	public Servidor(int porta) {
		this.porta = porta;
		this.clientes = new ArrayList<PrintStream>();
	}

	public void rodar() throws IOException {
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta " + this.porta + " aberta!");

		Socket cliente1 = servidor.accept();
		System.out.println("Nova conexão com o cliente estabelecida: " + cliente1.getInetAddress().getHostAddress());
		System.out.println("Porta 54400 aberta " + cliente1.getInetAddress().getHostAddress() + " porta "+ cliente1.getPort());
		Scanner mensagemRecebida = new Scanner(cliente1.getInputStream());

		Socket cliente2 = servidor.accept();
		System.out.println("Nova conexão com o cliente estabelecida: " + cliente2.getInetAddress().getHostAddress());
		System.out.println("Porta 54400 aberta " + cliente2.getInetAddress().getHostAddress() + " porta "+ cliente2.getPort());
		PrintStream mensagemEnviada = new PrintStream(cliente2.getOutputStream());

		String msgCliente = "";

		while (mensagemRecebida.hasNextLine()) {
			msgCliente = mensagemRecebida.nextLine();
			String msgTransformada = incrementar(msgCliente);
			mensagemEnviada.println(msgTransformada);
		}

		mensagemRecebida.close();
		mensagemEnviada.close();
		servidor.close();
		cliente1.close();
	}

	public static String incrementar(String msg) {
		int numero = 0;
		int inicio = msg.indexOf(" ");
		String msgInc = msg.substring(0, inicio);
		String msgNum = msg.substring(inicio);

		if (msg.isEmpty())
			throw new RuntimeException("Mensagem vázia");
		try {
			numero = Integer.parseInt(msgNum);
			msgNum = String.valueOf(--numero);
			msgInc += msgNum;
		} catch (NumberFormatException e) {
			msgInc = "A mensagem '" + msgNum + "' não é um número!";
		}
		return msgInc;
	}

	public void executarBroadcast() throws IOException {
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta " + this.porta + " aberta!");

		while (true) {

			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress() + " porta "+ cliente.getLocalPort() + " " + cliente.getPort());

			PrintStream saida = new PrintStream(cliente.getOutputStream());
			this.clientes.add(saida);

			TrataCliente tratador = new TrataCliente(cliente.getInputStream(), this);
			new Thread(tratador).start();
		}
	}

	public void distribuirMensagem(String msg) {
		for (PrintStream cliente : this.clientes) {
			cliente.println(msg);
		}
	}

	public class TrataCliente implements Runnable {
		private InputStream cliente;
		private Servidor servidor;

		public TrataCliente(InputStream cliente, Servidor servidor) {
			this.cliente = cliente;
			this.servidor = servidor;
		}

		@Override
		public void run() {
			Scanner s = new Scanner(this.cliente);
			String msg = "";
			while (s.hasNextLine()) {
				msg = servidor.incrementar(s.nextLine());
				servidor.distribuirMensagem(msg);
			}
			s.close();
		}
	}
        
    public static void main(String[] args) throws IOException {
        new Servidor(54400).rodar();
    }

    
}

