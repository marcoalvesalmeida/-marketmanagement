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
    CAMINHONETE(1), PASSEIO(2), CAMINHAO(3), MOTOCICLETA(4), FURGAO(5);
    private int tipoVeiculo;
    private EnumTipoVeiculo(int tipoVeiculo){
        this.tipoVeiculo = tipoVeiculo;
    }
}
