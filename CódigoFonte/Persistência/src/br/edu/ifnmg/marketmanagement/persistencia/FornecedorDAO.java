package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Fornecedor;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
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
    
    EnderecoRepositorio end = RepositorioBuilder.getEnderecoRepositorio();

    @Override
    protected String consultaAbrir() {
        return "select id,razaoSocial,cnpj,telefone,telefone2,endereco,informacoesAdicionais,ativo, email from fornecedores where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into fornecedores (razaoSocial, cnpj, telefone,telefone2,endereco,informacoesAdicionais,ativo, email) values (?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update fornecedores set razaoSocial = ?, cnpj = ?, telefone = ?,telefone2=?,endereco=?,informacoesAdicionais=?,ativo=?, email = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from fornecedores where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,razaoSocial,cnpj,telefone,telefone2,endereco,informacoesAdicionais,ativo,email from fornecedores";
    }

    @Override
    protected void carregaParametros(Fornecedor obj, PreparedStatement consulta) {
        try{
            consulta.setString(1,obj.getRazaoSocial());
            consulta.setString(2,obj.getCnpj().replace(".", "").replace("-", "").replace("/", ""));
            consulta.setString(3,obj.getTelefone());
            consulta.setString(4, obj.getCelular());
            consulta.setLong(5, obj.getEndereco().getId());
            consulta.setString(6, obj.getInformacoesAdicionais());
            consulta.setBoolean(7, obj.isAtivo());            
            consulta.setString(8,obj.getEmail());            
            if(obj.getId() > 0)
                consulta.setLong(9,obj.getId());    
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
            fornecedor.setCnpj(dados.getString("cnpj").substring(0,2)+"."+dados.getString("cnpj").substring(2,5)+"."+dados.getString("cnpj").substring(5,8)+"/"+dados.getString("cnpj").substring(8,12)+"-"+dados.getString("cnpj").substring(12,14));
            fornecedor.setEmail(dados.getString("email"));
            fornecedor.setTelefone(dados.getString("telefone"));
            fornecedor.setAtivo(dados.getBoolean("ativo"));
            fornecedor.setCelular(dados.getString("telefone2"));
            fornecedor.setInformacoesAdicionais(dados.getString("informacoesAdicionais"));
            fornecedor.setEndereco(end.abrir(dados.getInt("endereco")));           
            return fornecedor;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;        
    }

    @Override
    protected String carregaParametrosBusca(Fornecedor obj) {
        String sql = "";       
            
        if(obj.getRazaoSocial() != null && !obj.getRazaoSocial().isEmpty())
            sql = this.filtrarPor(sql, "razaoSocial", obj.getRazaoSocial());        
        if(obj.getCnpj() != null && !obj.getCnpj().isEmpty())
            sql = this.filtrarPor(sql, "cnpj", obj.getCnpj().replace(".", "").replace("-", "").replace("/",""));        
        return sql;
    }

   
    
}
