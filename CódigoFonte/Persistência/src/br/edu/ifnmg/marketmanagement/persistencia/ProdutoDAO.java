package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.CategoriaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumFuncoes;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumUnidadeMedida;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Produto;
import br.edu.ifnmg.marketmanagement.aplicacao.ProdutoRepositorio;
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
public class ProdutoDAO extends DAOGenerico <Produto> implements ProdutoRepositorio{
    FornecedorRepositorio fornecedor = RepositorioBuilder.getFornecedorRepositorio();
    CategoriaRepositorio categoria = RepositorioBuilder.getCategoriaRepositorio();
    @Override
    protected String consultaAbrir() {
        return "select id,descricao,categoria,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,unidadeMedida,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar,fornecedor from produtos where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into produtos (descricao,categoria,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,unidadeMedida,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar,fornecedor) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update produtos set descricao =?,categoria =?, valorCusto =?,valorVarejo=?,valorAtacado=?,codigo=?,pontuacao=?,unidadeMedida =?, estoqueMinimo=?,estoqueAtual=?,ativo=?,informacoesAdicionais=?,fracionar=?, fornecedor =? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from produtos where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,descricao,categoria,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,unidadeMedida,estoqueMinimo,estoqueAtual,ativo,informacoesAdicionais,fracionar,fornecedor from produtos";
    }
    
  
    @Override
    protected void carregaParametros(Produto obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getDescricao());
            consulta.setInt(2, (int) obj.getCategoria().getId());
            consulta.setBigDecimal(3, obj.getValorCusto());
            consulta.setBigDecimal(4, obj.getValorVarejo());
            consulta.setBigDecimal(5, obj.getValorAtacado());
            consulta.setInt(6, obj.getCodigo());
            consulta.setLong(7, obj.getPontuacao());
            consulta.setString(8, obj.getUnMedida().toString());
            consulta.setLong(9, obj.getEstoqueMinimo());
            consulta.setLong(10, obj.getEstoqueAtual());
            consulta.setBoolean(11, obj.isAtivo());         
            consulta.setString(12, obj.getInformacoesAdicionais());
            consulta.setBoolean(13, obj.isFracionar());
            consulta.setInt(14, (int) obj.getFornecedor().getId());
            if(obj.getId() > 0){
                consulta.setLong(15,obj.getId());
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
            produto.setCategoria(categoria.abrir(dados.getInt("categoria")));
            produto.setFornecedor(fornecedor.abrir(dados.getInt("fornecedor")));
            produto.setPontuacao(dados.getLong("pontuacao"));
            produto.setUnMedida(EnumUnidadeMedida.valueOf(dados.getString("unidadeMedida")));
            produto.setEstoqueMinimo(dados.getLong("estoqueMinimo"));
            produto.setEstoqueAtual(dados.getLong("estoqueAtual"));
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
        if(obj.getDescricao() != null && !obj.getDescricao().isEmpty())
            sql = this.filtrarPor(sql, "descricao", obj.getDescricao());        
        if(obj.getCodigo() > 0)
            sql = this.filtrarPor(sql, "codigo", Integer.toString(obj.getCodigo()));        
        return sql;    
    }
   
}
