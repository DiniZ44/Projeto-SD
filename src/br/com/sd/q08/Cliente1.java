/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q08;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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

		Socket cliente = new Socket(this.host, this.porta);
		System.out.println("O cliente "+this.nome+" se conectou ao servidor!");

		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (teclado.hasNextLine()) {
			saida.println(this.nome+": "+teclado.nextLine());
		}

		saida.close();
		teclado.close();
		cliente.close();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public static void main(String[] args) throws IOException {
		new Cliente1("Cliente Que envia", "127.0.0.1", 54400).rodar();

	}


}
