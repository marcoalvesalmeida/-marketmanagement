/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author marco
 */
public enum EnumModoPagamento {
    DINHEIRO("DINHEIRO"),
    CARNÊ("CARNÊ"),
    CRÉDITO("CARTÃO DE CRÉDITO"),
    DÉBITO("CARTÃO DE DÉBITO"); 
    
    private final String modos;
    EnumModoPagamento(String modos){
        this.modos = modos;
    }
    public String getEnumModoPagamento(){
        return modos;
    }
}
