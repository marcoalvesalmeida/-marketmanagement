/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.EntregaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Entrega;
import br.edu.ifnmg.marketmanagement.aplicacao.FuncionarioRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.VeiculoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class EntregaDAO extends DAOGenerico<Entrega> implements EntregaRepositorio {
    
    VeiculoRepositorio veiculos = RepositorioBuilder.getVeiculoRepositorio();
    
    FuncionarioRepositorio funcionarios = RepositorioBuilder.getFuncionarioRepositorio();
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into entrega(venda, veiculo, endereco, motorista, data_entrega) values(?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update entrega set venda = ?, veiculo = ?, endereco = ?,  motorista = ?, data_entrega = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from entrega where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from entrega";
    }


    @Override
    protected Entrega carregaObjeto(ResultSet dados) {
        try {
            Entrega obj;
            obj = new Entrega(
                    dados.getLong("id"),
                    null,
                    veiculos.abrir(dados.getLong("veiculo")),
                    null,                    
                    funcionarios.abrir(dados.getLong("motorista")),
                    new java.util.Date(dados.getDate("data_entrega").getTime())
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    protected String carregaParametrosBusca(Entrega obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        
        if(obj.getData() != null)
            sql = this.filtrarPor(sql, "data_entrega", df.format(obj.getData()));
        
        return sql;
    }

    @Override
    protected void carregaParametros(Entrega obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                consulta.setLong(6, obj.getId());
            } else {
                consulta.setLong(1, obj.getVenda().getId());
                consulta.setLong(2, obj.getVeiculo().getId());
                consulta.setLong(3, obj.getEndereco().getId());
                consulta.setLong(4, obj.getMotorista().getId());
                consulta.setDate(5, (java.sql.Date) obj.getData());
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
