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
public enum EnumCombustivel {
    FLEX(1),
    GASNATURAL(2),
    GASOLINA(3),
    ALCOOL(4),
    DIESEL(5); 
    private int combustivel;
    private EnumCombustivel(int combustivel){
        this.combustivel = combustivel;
    }
}
