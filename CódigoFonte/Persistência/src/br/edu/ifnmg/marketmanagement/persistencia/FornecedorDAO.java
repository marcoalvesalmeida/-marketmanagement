package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Fornecedor;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class FornecedorDAO extends DAOGenerico <Fornecedor> implements FornecedorRepositorio{

    @Override
    protected String consultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into fornecedores (razaoSocial, cnpj, telefone, email) values (?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update fornecedores set razaoSocial = ?, cnpj = ?, telefone = ?, email = ? where id = ?";
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
    protected void carregaParametros(Fornecedor obj, PreparedStatement consulta) {
        try{
            consulta.setString(1,obj.getRazaoSocial());
            consulta.setString(2,obj.getCnpj());
            consulta.setString(3,obj.getTelefone());
            consulta.setString(4,obj.getEmail());            
            if(obj.getId() > 0)
                consulta.setLong(5,obj.getId());    
        }catch(SQLException e){
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }

    @Override
    protected Fornecedor carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String carregaParametrosBusca(Fornecedor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
