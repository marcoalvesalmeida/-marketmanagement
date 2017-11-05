/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author aluno
 */
public class ViolacaoRegraNegocioException extends Exception{

    public ViolacaoRegraNegocioException(String message) {
        super(message);
    }

    ViolacaoRegraNegocioException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
