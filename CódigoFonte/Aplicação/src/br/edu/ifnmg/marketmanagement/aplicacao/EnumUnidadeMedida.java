package br.edu.ifnmg.marketmanagement.aplicacao;
/**
 *
 * @author guilherme
 */
public enum EnumUnidadeMedida {
    UNIDADE(1),
    QUILO(2),
    LITRO(3),
    METRO(4);
    private int unMedida;
    private EnumUnidadeMedida(int unMedida){
        this.unMedida = unMedida;
    } 

  
    
    
}
