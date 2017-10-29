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
public class SISMERCADO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ViolacaoRegraNegocioException {
        // TODO code application logic here
        Veiculo veic = new Veiculo(1,"Uno","GZR-8909");
        veic.setPlaca("KDS-4337");
        veic.setChassi("1AB34343434343434");
        System.out.println(veic.toString());
    }
    
}
