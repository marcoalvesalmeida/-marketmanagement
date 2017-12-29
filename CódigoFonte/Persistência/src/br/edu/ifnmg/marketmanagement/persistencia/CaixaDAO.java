/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.CaixaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Caixa;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class CaixaDAO extends DAOGenerico<Caixa> implements CaixaRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select * from caixa where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into caixa(data_hora_abertura, valor_inicial, turno, usuario, valor_dinheiro, valor_boleto, outras_formas, total_vendas, proximo_caixa, soma_caixa, estado) values(?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update caixa set operador = ? , saldo, dataHoraAbertura = ?, terminal = ?, valorInicial = ?, turno = ?, valorDinheiro = ?, valorBoleto = ?, \n" +
"            valorCartao = ?, valorCarne = ?, somaVendas = ?, totalPagamentos = ?, valorProximoCaixa = ?, somalTotalTurno = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from veiculo where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from caixa";
    }

    @Override
    protected Caixa carregaObjeto(ResultSet dados) {
        Caixa obj;
        try {
            obj = new Caixa(
                    dados.getLong("id"),
                    null,
                    null,
                    null,
                    dados.getBigDecimal("valorinicial"),
                    dados.getLong("turno"),
                    dados.getBigDecimal("valordinheiro"),
                    dados.getBigDecimal("valorboleto"),
                    dados.getBigDecimal("valorcartao"),
                    dados.getBigDecimal("valorcarne"),
                    dados.getBigDecimal("somavendas"),
                    dados.getBigDecimal("valorproximocaixa"),
                    dados.getBigDecimal("somatotalturno")
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }

    @Override
    protected void carregaParametros(Caixa obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                consulta.setLong(12, obj.getId());
            } else {
                consulta.setLong(1, obj.getOperador().getId());
                consulta.setString(3, obj.getDataHoraAbertura().toString());
                consulta.setBigDecimal(5, obj.getValorInicial());
                consulta.setLong(6, obj.getTurno());
                consulta.setBigDecimal(7, obj.getValorDinheiro());
                consulta.setBigDecimal(8, obj.getValorBoleto());
                consulta.setBigDecimal(9, obj.getValorCartao());
                consulta.setBigDecimal(10, obj.getValorCarne());
                consulta.setBigDecimal(11, obj.getSomaVendas());
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
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        
        if(obj.getDataHoraAbertura() != null)
            sql = this.filtrarPor(sql, "dataHoraAbertura", obj.getDataHoraAbertura().toString().replace("-", ""));
        
        if(obj.getDataHoraFechamento() != null)
            sql = this.filtrarPor(sql, "dataHoraFechamento", obj.getDataHoraFechamento().toString().replace("-", ""));
        
        if(obj.getOperador().getId() > 0)
            sql = this.filtrarPor(sql, "operador", Long.toString(obj.getOperador().getId()));
        
        if(obj.getTurno() > 0)
            sql = this.filtrarPor(sql, "turno", Long.toString(obj.getTurno()));
        return sql;
    }

}
