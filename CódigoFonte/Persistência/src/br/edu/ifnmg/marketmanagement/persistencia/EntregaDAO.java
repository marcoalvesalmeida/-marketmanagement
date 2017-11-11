/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.EntregaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Entrega;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class EntregaDAO extends DAOGenerico<Entrega> implements EntregaRepositorio {

    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into entrega(venda, veiculo, endereco, motorista ) values(?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update entrega set venda = ?, veiculo = ?, endereco = ?, motorista = ? where id = ?";
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
    protected Entrega carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void carregaParametros(Entrega obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0) {
                //consulta.setLong(5, obj.getId());
                System.out.println("Editar");
            } else {
                consulta.setLong(1, obj.getVenda().getId());
                consulta.setLong(2, obj.getVeiculo().getId());
                consulta.setLong(3, obj.getEndereco().getId());
                consulta.setLong(4, obj.getMotorista().getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
