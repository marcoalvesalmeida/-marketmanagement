/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Entidade;
import br.edu.ifnmg.marketmanagement.aplicacao.Repositorio;
import java.sql.Connection;
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
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {
    
    protected Connection conexao;

    protected abstract String consultaAbrir();
    protected abstract String consultaInsert();
    protected abstract String consultaUpdate();
    protected abstract String consultaDelete();
    protected abstract String consultaBuscar();
    
    protected abstract void carregaParametros(T obj, PreparedStatement consulta);
    protected abstract T carregaObjeto(ResultSet dados);
    
    @Override
    public boolean salvar(T obj) {
        try {
            String sql = "";
            
            if(obj.getId() == 0)
                sql = this.consultaInsert();
            else
                sql = this.consultaUpdate();
            System.out.println(sql);
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            this.carregaParametros(obj, consulta);
            return consulta.executeUpdate() > 0;
          
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public T abrir(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> buscar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
