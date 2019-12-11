/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q10_8;

/**
 *
 * @author Hakkinen
 */
public class Converter {
    
    	public static String converterMensagem(String msg) {
		String msgTrans = "";
		int inicio = msg.indexOf(":");

		for (int i = 0; i < msg.length(); i++) {
			char aux = msg.charAt(i);

			if (i <= inicio)
				msgTrans += aux;

			else if (aux == " ".charAt(0) || aux == "?".charAt(0) || aux == ".".charAt(0) || aux == ",".charAt(0)
					|| aux == "!".charAt(0))
				msgTrans += aux;

			else if (aux == "z".charAt(0))
				msgTrans += "a";

			else
				msgTrans += (++aux);

		}
		return msgTrans;
	}
    
}
