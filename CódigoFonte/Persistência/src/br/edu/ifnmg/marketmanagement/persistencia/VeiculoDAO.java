/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Veiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.VeiculoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class VeiculoDAO extends DAOGenerico<Veiculo> implements VeiculoRepositorio {

    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into veiculo(modelo, placa, chassi, tipo, anoFab, marca, combustivel, observacoes) values(?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update veiculo set modelo = ?, placa = ?, chassi = ?, tipo = ?, anoFab = ?, marca = ?, combustivel = ?, observacoes = ? where id = ?";
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
    protected void carregaParametros(Veiculo obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                //consulta.setLong(9, obj.getId());
                System.out.println("Editar");
            } else {
                consulta.setString(1, obj.getModelo());
                consulta.setString(2, obj.getPlaca());
                consulta.setString(3, obj.getChassi());
                consulta.setString(4, obj.getTipo().toString());
                consulta.setInt(5, (int) obj.getAnoFab());
                consulta.setString(6, obj.getMarca().toString());
                consulta.setString(7, obj.getCombustivel().toString());
                consulta.setString(8, obj.getObservacoes());
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Veiculo carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String carregaParametrosBusca(Veiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
