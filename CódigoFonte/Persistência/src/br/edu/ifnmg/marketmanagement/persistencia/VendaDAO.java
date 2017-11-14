/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.VendaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio {

    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into venda(data, tipo, valorTotal, modo, acrescimo, desconto, cliente, turno, controle, operador) values(?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update venda set data = ?, tipo = ?, valorTotal = ?, modo = ?, acrescimo = ?, desconto = ?, cliente = ?, turno = ?, controle = ?, operador = ? where id = ?";
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
    protected Venda carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void carregaParametros(Venda obj, PreparedStatement consulta) {
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
                consulta.setString(9, obj.getTurno());
                consulta.setLong(10, obj.getControle());
                consulta.setLong(11, obj.getOperador().getId());
                // Implementar a persistência do ArrayList de itens! ArrayList<Produto> itens;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Venda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}