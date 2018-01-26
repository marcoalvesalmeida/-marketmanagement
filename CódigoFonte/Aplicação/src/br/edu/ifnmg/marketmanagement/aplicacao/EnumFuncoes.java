/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author guilherme
 */
public enum EnumFuncoes {
    GERENTE(1), FUNCIONARIO(2), MOTORISTA(3), OPERADOR(4), MANUTENÇÃO(5);
    private int funcao;
    private EnumFuncoes(int funcao){
        this.funcao = funcao;
    }
}
