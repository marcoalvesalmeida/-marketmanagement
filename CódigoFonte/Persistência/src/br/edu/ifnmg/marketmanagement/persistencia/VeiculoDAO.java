/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.EnumCombustivel;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumMarcaVeiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumTipoVeiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import br.edu.ifnmg.marketmanagement.aplicacao.Veiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.VeiculoRepositorio;
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
public class VeiculoDAO extends DAOGenerico<Veiculo> implements VeiculoRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select  * from veiculo where id=?";
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
        return "delete from veiculo where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select  * from veiculo";
    }

    @Override
    protected String carregaParametrosBusca(Veiculo obj) {
        String sql = "";

        if (obj.getPlaca() != null && !obj.getPlaca().isEmpty()) {
            sql = this.filtrarPor(sql, "placa", obj.getPlaca().replace("-", ""));
        }

        if (obj.getModelo() != null && !obj.getModelo().isEmpty()) {
            sql = this.filtrarPor(sql, "modelo", obj.getModelo());
        }

        if (obj.getAnoFab()>0) {
            sql = this.filtrarPor(sql, "anofab", Long.toString(obj.getAnoFab()));
        }
        
        if (obj.getTipo() != null) {
            sql = this.filtrarPor(sql, "tipo", obj.getTipo().toString());
        }
        return sql;
    }

    @Override
    protected void carregaParametros(Veiculo obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0)
                consulta.setLong(9, obj.getId());
            
            consulta.setString(1, obj.getModelo());
            consulta.setString(2, obj.getPlaca());
            consulta.setString(3, obj.getChassi());
            consulta.setString(4, obj.getTipo().toString());
            consulta.setLong(5, obj.getAnoFab());
            consulta.setString(6, obj.getMarca().toString());
            consulta.setString(7, obj.getCombustivel().toString());
            consulta.setString(8, obj.getObservacoes());
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Veiculo carregaObjeto(ResultSet dados) {
        try {
            Veiculo obj;
            obj = new Veiculo(
                    dados.getLong("id"), 
                    dados.getString("modelo"),
                    dados.getString("placa"),
                    dados.getString("chassi"),
                    EnumTipoVeiculo.valueOf(dados.getString("tipo")),                    
                    dados.getLong("anoFab"),
                    EnumMarcaVeiculo.valueOf(dados.getString("marca")),
                    EnumCombustivel.valueOf(dados.getString("combustivel")),
                    dados.getString("observacoes")
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
