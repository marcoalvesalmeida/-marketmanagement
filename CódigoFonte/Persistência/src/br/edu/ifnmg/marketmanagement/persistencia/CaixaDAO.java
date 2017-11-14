/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.CaixaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class CaixaDAO extends DAOGenerico<Caixa> implements CaixaRepositorio {

    @Override
    protected String consultaAbrir() {
        return "";
    }

    @Override
    protected String consultaInsert() {
        return "insert into caixa(operador, saldo, dataHoraAbertura, terminal, valorInicial, turno, valorDinheiro, valorBoleto, \n" +
"            valorCartao, valorCarne, somaVendas, totalPagamentos, valorProximoCaixa, somalTotalTurno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update caixa set operador = ? , saldo, dataHoraAbertura = ?, terminal = ?, valorInicial = ?, turno = ?, valorDinheiro = ?, valorBoleto = ?, \n" +
"            valorCartao = ?, valorCarne = ?, somaVendas = ?, totalPagamentos = ?, valorProximoCaixa = ?, somalTotalTurno = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Caixa carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void carregaParametros(Caixa obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                //consulta.setLong(15, obj.getId());
                System.out.println("Editar");
            } else {
                consulta.setLong(1, obj.getOperador().getId());
                consulta.setBigDecimal(2, obj.getSaldo());
                consulta.setString(3, obj.getDataHoraAbertura().toString());
                consulta.setLong(4, obj.getTerminal());
                consulta.setBigDecimal(5, obj.getValorInicial());
                consulta.setLong(6, obj.getTurno());
                consulta.setBigDecimal(7, obj.getValorDinheiro());
                consulta.setBigDecimal(8, obj.getValorBoleto());
                consulta.setBigDecimal(9, obj.getValorCartao());
                consulta.setBigDecimal(10, obj.getValorCarne());
                consulta.setBigDecimal(11, obj.getSomaVendas());
                consulta.setBigDecimal(12, obj.getTotalPagamentos());
                consulta.setBigDecimal(13, obj.getValorProximoCaixa());
                consulta.setBigDecimal(14, obj.getSomaTotalTurno());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Caixa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
