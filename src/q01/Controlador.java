/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Hakkinen
 */
public class Controlador extends Thread implements ActionListener{
    
    private Tela tela;
    
    private static Contador contador;
    private JTextField field;

    public Controlador() {
            tela = new Tela();
          tela.setVisible(true);
            control();
    }
    
    void control(){
        tela.getConfirmar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(tela.getConfirmar() == ae.getSource()){
            tela.getConfirmar().setVisible(false);
            tela.getTextField().setVisible(false);
            tela.getLabel_texto().setVisible(false);
            contador = new Contador(Integer.parseInt(tela.getTextField().getText()));
            start();
        }
    }

    @Override
    public void run() {
        while(true){
        contador.decrementar();
        
        if(contador.getTempo() == 0){
        tela.getLabel_livre().setText("Livre");
        tela.getLabel_tempo().setText(" ");
        tela.getConfirmar().setVisible(true);
        tela.getTextField().setVisible(true);
        tela.getLabel_texto().setVisible(true);
        Util.limparText(tela.getjPanel1());
        }else{
        tela.getLabel_livre().setText("Bloqueado");
        tela.getLabel_tempo().setText("O App vai desbloquear em "+ contador.getTempo()+ " segundos");
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
  
}
