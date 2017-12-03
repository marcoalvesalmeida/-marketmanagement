package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Produto;
import br.edu.ifnmg.marketmanagement.aplicacao.ProdutoRepositorio;
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
public class ProdutoDAO extends DAOGenerico <Produto> implements ProdutoRepositorio{

    @Override
    protected String consultaAbrir() {
        return "select id,descricao,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar from produtos where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into produtos (descricao,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar) values (?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update produtos set descricao =?,valorCusto =?,valorVarejo=?,valorAtacado=?,codigo=?,pontuacao=?,estoqueMinimo=?,estoqueAtual=?,ativo=?,informacoesAdicionais=?,fracionar=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from produtos where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,descricao,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar from produtos";
    }

    @Override
    protected void carregaParametros(Produto obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getDescricao());
            consulta.setBigDecimal(2, obj.getValorCusto());
            consulta.setBigDecimal(3, obj.getValorVarejo());
            consulta.setBigDecimal(4, obj.getValorAtacado());
            consulta.setInt(5, obj.getCodigo());
            consulta.setLong(6, obj.getPontuacao());
            consulta.setLong(7, obj.getEstoqueMinimo());
            consulta.setLong(8, obj.getEstoqueAtual());
            consulta.setBoolean(9, obj.isAtivo());         
            consulta.setString(10, obj.getInformacoesAdicionais());
            consulta.setBoolean(11, obj.isFracionar());
            if(obj.getId() > 0){
                consulta.setLong(12,obj.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Produto carregaObjeto(ResultSet dados){
        Produto produto = new Produto();
        try {
            produto.setId(dados.getLong("id"));
            produto.setDescricao(dados.getString("descricao"));
            produto.setAtivo(dados.getBoolean("ativo"));
            produto.setValorCusto(dados.getBigDecimal("valorCusto"));
            produto.setValorAtacado(dados.getBigDecimal("valorAtacado"));
            produto.setValorVarejo(dados.getBigDecimal("valorVarejo"));
            produto.setCodigo(dados.getInt("codigo"));
            produto.setPontuacao(dados.getLong("pontuacao"));
            produto.setEstoqueMinimo(dados.getLong("estoqueMinino"));
            produto.setEstoqueAtual(dados.getLong("estoqueaAtual"));
            produto.setAtivo(dados.getBoolean("ativo"));
            produto.setInformacoesAdicionais(dados.getString("informacoesAdicionais"));
            produto.setFracionar(dados.getBoolean("fracionar"));
            return produto;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;        
    }

    @Override
    protected String carregaParametrosBusca(Produto obj) {
        String sql = "";        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId()));        
        if(obj.getDescricao() != null && !obj.getDescricao().isEmpty())
            sql = this.filtrarPor(sql, "descricao", obj.getDescricao());        
        if(obj.getCodigo() > 0)
            sql = this.filtrarPor(sql, "codigo", Long.toString(obj.getCodigo()));        
        return sql;    
    } 
}
