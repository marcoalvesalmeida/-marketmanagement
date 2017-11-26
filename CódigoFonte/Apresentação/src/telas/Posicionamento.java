/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author marco
 */
public class Posicionamento {
    protected Dimension tamanho;

    public Posicionamento() {
    }
    
    public void setTamanho(JInternalFrame tela) {
        tamanho = tela.getDesktopPane().getSize();
        tela.setLocation((tamanho.width - tela.getSize().width) / 2, (tamanho.height - tela.getSize().height) / 2);
    }
}
