/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q09;

import br.com.sd.q08.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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

		Socket cliente = new Socket(this.host, this.porta);
		System.out.println("O cliente "+this.nome+" se conectou ao servidor!");
		Scanner entrada = new Scanner(cliente.getInputStream());

		while (entrada.hasNextLine()) { System.out.print(entrada.nextLine() + "\n");
		}
		entrada.close();
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
            new Cliente2("Cliente que Recebe", "127.0.0.2", 54400).rodar();
	}
}
