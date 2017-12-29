/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.EnumModoPagamento;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumPlanejamento;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import br.edu.ifnmg.marketmanagement.aplicacao.VendaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Venda;
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
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select * from venda where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into venda(data, tipo, valorTotal, modo, acrescimo, desconto, cliente, turno, controle, operador, terminal) values(?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update venda set data = ?, tipo = ?, valorTotal = ?, modo = ?, acrescimo = ?, desconto = ?, cliente = ?, turno = ?, controle = ?, operador = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from veiculo where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from venda";
    }

    @Override
    protected Venda carregaObjeto(ResultSet dados) {
        try {
            Venda obj = new Venda(
                    dados.getString("turno"),
                    dados.getLong("terminal"),
                    dados.getLong("controle"),
                    null,
                    null,
                    dados.getLong("id"),
                    null,
                    dados.getString("tipo"),
                    dados.getBigDecimal("valor"),
                    dados.getBigDecimal("valortotal"),
                    EnumModoPagamento.valueOf(dados.getString("modo")),
                    dados.getBigDecimal("acrescimo"),
                    dados.getBigDecimal("desconto"),
                    null,
                    EnumPlanejamento.valueOf(dados.getString("planejamento"))                    
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void carregaParametros(Venda obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                consulta.setLong(13, obj.getId());
                System.out.println("Editar");
            } else {
                consulta.setString(1, obj.getData().toString());
                consulta.setString(2, obj.getTipo());
                consulta.setBigDecimal(3, obj.getValorTotal());
                consulta.setString(4, obj.getModo().toString());
                consulta.setBigDecimal(5, obj.getAcrescimo());
                consulta.setBigDecimal(6, obj.getDesconto());
                consulta.setLong(7, obj.getCliente().getId());
                consulta.setString(8, obj.getPlanejamento().toString());
                consulta.setString(9, obj.getTurno());
                consulta.setLong(10, obj.getControle());
                consulta.setLong(11, obj.getOperador().getId());
                consulta.setLong(12, obj.getTerminal());
                // Implementar a persistência do ArrayList de itens! ArrayList<Produto> itens;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Venda obj) {
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        
        if(obj.getData() != null)
            sql = this.filtrarPor(sql, "data", obj.getData().toString().replace("-", ""));
        
        return sql;
    }

}