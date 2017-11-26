package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Categoria;
import br.edu.ifnmg.marketmanagement.aplicacao.CategoriaRepositorio;
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
public class CategoriaDAO extends DAOGenerico <Categoria> implements CategoriaRepositorio{

    @Override
    protected String consultaAbrir() {
        return "select id,descricao from categorias where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into categorias (descricao) values (?)" ;
    }

    @Override
    protected String consultaUpdate() {
        return "update categorias set descricao = ? where id =?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from categorias where id=? ";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,descricao from categorias";
        
    }

    @Override
    protected String carregaParametrosBusca(Categoria obj) {      
        String sql = "";        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
     
        
        return sql;
    }

    @Override
    protected void carregaParametros(Categoria obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getDescricao());
            if (obj.getId()>0){
                consulta.setLong(2, obj.getId());                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Categoria carregaObjeto(ResultSet dados) {
        Categoria cat = new Categoria();
        try {
            cat.setId(dados.getLong("id"));
            cat.setDescricao(dados.getString("descricao"));
            return cat;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {       
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    
}
