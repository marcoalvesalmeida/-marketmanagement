/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.CompraRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class CompraDAO extends DAOGenerico<Compra> implements CompraRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select * from compra where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into compra(data, tipo, valorTotal, modo, acrescimo, desconto, cliente, planejamento, fornecedor) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update compra set data = ?, tipo = ?, valorTotal = ?, modo = ?, acrescimo = ?, desconto = ?, cliente = ?, planejamento = ?, fornecedor = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
          return "delete from compra where id=?";
    }

    @Override
    protected String consultaBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    protected Compra carregaObjeto(ResultSet dados) {
        try {
            Compra obj = new Compra(
                    null,
                    null,
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
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    protected String carregaParametrosBusca(Compra obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        
        if(obj.getData() != null)
            sql = this.filtrarPor(sql, "data", obj.getData().toString().replace("-", ""));
        
        return sql;
    }
    @Override
    protected void carregaParametros(Compra obj, PreparedStatement consulta) {
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
                consulta.setString(8, obj.getPlanejamento());
                consulta.setLong(9, obj.getFornecedor().getId());
                // Implementar a persistência do ArrayList de itens! ArrayList<Produto> itens;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}