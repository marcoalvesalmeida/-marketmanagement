package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Cliente;
import br.edu.ifnmg.marketmanagement.aplicacao.ClienteRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class ClienteDAO extends DAOGenerico <Cliente> implements ClienteRepositorio{

 


    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into clientes (nome, dataNascimento, cpf, rg, telefone, email) values (?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update clientes set nome = ?, dataNascimento = ?, cpf = ?, rg = ?, telefone = ?, email = ? where id = ?";
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
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        try{            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getDataNascimento());
            consulta.setString(3, obj.getCpf());
            consulta.setString(4, obj.getRg());           
            consulta.setString(5, obj.getTelefone());
            consulta.setString(6, obj.getEmail()); 
            System.out.println(obj.getId());
            
            if(obj.getId() > 0)
                consulta.setLong(7, obj.getId()); 
            
        }catch(SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }

    @Override
    protected Cliente carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
