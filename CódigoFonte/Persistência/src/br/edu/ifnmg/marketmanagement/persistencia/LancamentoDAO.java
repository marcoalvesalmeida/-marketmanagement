/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.LancamentoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class LancamentoDAO extends DAOGenerico<Lancamento> implements LancamentoRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select * from lancamento where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into lancamento(data, tipo, valorTotal, modo, acrescimo, desconto, cliente) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update lancamento set data = ?, tipo = ?, valorTotal = ?, modo = ?, acrescimo = ?, desconto = ?, cliente = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from lancamento where id=?";
    }

    @Override
    protected String consultaBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Lancamento carregaObjeto(ResultSet dados) {
        try {
            Lancamento obj = new Lancamento(
                    dados.getLong("id"),
                    null,
                    dados.getString("tipo"),
                    dados.getBigDecimal("valortotal"),
                    dados.getString("modo"),
                    dados.getBigDecimal("acrescimo"),
                    dados.getBigDecimal("desconto"),
                    null,
                    dados.getString("planejamento")
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void carregaParametros(Lancamento obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                //consulta.setLong(10, obj.getId());
                System.out.println("Editar");
            } else {
                consulta.setString(1, obj.getData().toString());
                consulta.setString(2, obj.getTipo());
                consulta.setBigDecimal(3, obj.getValorTotal());
                consulta.setString(4, obj.getModo());
                consulta.setBigDecimal(5, obj.getAcrescimo());
                consulta.setBigDecimal(6, obj.getDesconto());
                consulta.setLong(7, obj.getCliente().getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Lancamento obj) {
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        
        if(obj.getData() != null)
            sql = this.filtrarPor(sql, "data", obj.getData().toString().replace("-", ""));
        
        return sql;
    }

}
