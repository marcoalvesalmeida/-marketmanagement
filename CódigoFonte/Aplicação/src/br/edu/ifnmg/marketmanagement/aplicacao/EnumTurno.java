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
public enum EnumTurno {
    MANHÃ("MANHÃ"),
    TARDE("TARDE"),
    NOITE("NOITE"),
    MADRUGADA("MADRUGADA");
    
    private final String turnos;
    EnumTurno(String turnos){
        this.turnos = turnos;
    }
    public String getEnumTurno(){
        return turnos;
    }
}
