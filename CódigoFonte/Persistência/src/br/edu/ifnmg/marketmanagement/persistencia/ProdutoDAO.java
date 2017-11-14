package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Produto;
import br.edu.ifnmg.marketmanagement.aplicacao.ProdutoRepositorio;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaInsert() {
        return "insert into produtos (descricao,valorCusto,valorVarejo,valorAtacado,codigo, pontuacao,estoqueMinino,estoqueaAtual,ativo,informacoesAdicionais,fracionar) values (?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update produtos set descricao =?,valorCusto =?,valorVarejo=?,valorAtacado=?,codigo=?,pontuacao=?,estoqueMinino=?,estoqueaAtual=?,ativo=?,informacoesAdicionais=?,fracionar=? where id = ?";
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
    protected void carregaParametros(Produto obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getDescricao());
            consulta.setBigDecimal(2, obj.getValorCusto());
            consulta.setBigDecimal(3, obj.getValorVarejo());
            consulta.setBigDecimal(4, obj.getValorAtacado());
            consulta.setInt(5, obj.getCodigo());
            consulta.setLong(6, obj.getPontuacao());
            consulta.setLong(7, obj.getEstoqueMinimo());
            consulta.setBoolean(8, obj.isAtivo());
            consulta.setLong(9, obj.getEstoqueMinimo());
            consulta.setLong(10, obj.getEstoqueMinimo());
            consulta.setString(11, obj.getInformacoesAdicionais());
            if(obj.getId() > 0){
                consulta.setLong(11,obj.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Produto carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String carregaParametrosBusca(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
}
