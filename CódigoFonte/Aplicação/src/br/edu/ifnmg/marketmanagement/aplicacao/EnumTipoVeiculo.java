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
public enum EnumTipoVeiculo {
    CAMINHONETE("CAMINHONETE"), 
    PASSEIO("PASSEIO"), 
    CAMINHAO("CAMINHAO"), 
    MOTOCICLETA("MOTOCICLETA"), 
    FURGAO("FURGAO");
    private String tipoVeiculo;
    private EnumTipoVeiculo(String tipoVeiculo){
        this.tipoVeiculo = tipoVeiculo;
    }
}
