/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sd.q10_9;

import br.com.sd.q10_8.*;

/**
 *
 * @author Hakkinen
 */
public class Converter {
    
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
    
}
