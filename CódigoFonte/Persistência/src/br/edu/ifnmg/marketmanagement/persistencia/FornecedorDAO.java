package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Fornecedor;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
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
        return "select id,razaoSocial,cnpj,telefone,email from fornecedores where id= ?";
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
        return "delete from fornecedores where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,razaoSocial,cnpj,telefone,email from fornecedores";
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
        Fornecedor fornecedor = new Fornecedor();
        try {
            fornecedor.setId(dados.getLong("id"));
            fornecedor.setRazaoSocial(dados.getString("razaoSocial"));
            fornecedor.setCnpj(dados.getString("cnpj"));
            fornecedor.setEmail(dados.getString("email"));
            fornecedor.setTelefone(dados.getString("telefone"));
            return fornecedor;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;        
    }

    @Override
    protected String carregaParametrosBusca(Fornecedor obj) {
        String sql = "";        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId()));        
        if(obj.getRazaoSocial() != null && !obj.getRazaoSocial().isEmpty())
            sql = this.filtrarPor(sql, "razaoSocial", obj.getRazaoSocial());        
        if(obj.getCnpj() != null && !obj.getCnpj().isEmpty())
            sql = this.filtrarPor(sql, "cnpj", obj.getCnpj());        
        return sql;
    }
    
}
