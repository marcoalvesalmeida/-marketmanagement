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
public enum EnumPlanejamento {
    DESPESAS("DESPESAS"),
    DEVOLUCAO("DEVOLUÇÃO"),
    VENDA("VENDA"),
    COMPRA("COMPRA");
    
    
    private final String planejamentos;
    EnumPlanejamento(String planejamentos){
        this.planejamentos = planejamentos;
    }
    public String getEnumModoPagamento(){
        return planejamentos;
    }
}
