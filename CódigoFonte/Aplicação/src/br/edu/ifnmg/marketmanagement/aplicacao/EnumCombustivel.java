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
    FLEX("FLEX"),
    GASNATURAL("GASNATURAL"),
    GASOLINA("GASOLINA"),
    ALCOOL("ALCOOL"),
    DIESEL("DIESEL"); 
    
    private final String combustiveis;
    EnumCombustivel(String combustivel){
        this.combustiveis = combustivel;
    }
    public String getEnumCombustivel(){
        return combustiveis;
    }
}
