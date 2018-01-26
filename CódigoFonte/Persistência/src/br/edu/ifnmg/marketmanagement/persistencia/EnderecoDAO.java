package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Endereco;
import br.edu.ifnmg.marketmanagement.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Entidade;
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
public class EnderecoDAO extends DAOGenerico<Endereco> implements EnderecoRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select id,rua, cep,numero,bairro,cidade,uf from enderecos where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into enderecos (rua, cep,numero,bairro,cidade,uf) values (?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update enderecos set rua=?, cep=?, numero=?,bairro=?,cidade=?,uf=? where id=?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from enderecos where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,rua, cep,numero,bairro,cidade,uf from enderecos";
    }

    @Override
    protected String carregaParametrosBusca(Endereco obj) {
        String sql = "";

        if (obj.getId() > 0) {
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        }

        if (obj.getCep() != null && !obj.getCep().isEmpty()) {
            sql = this.filtrarPor(sql, "cep", obj.getCep());
        }

        return sql;
    }

    @Override
    protected void carregaParametros(Endereco obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getRua());
            consulta.setString(2, (obj.getCep().replace("-", "")));
            consulta.setInt(3, obj.getNumero());
            consulta.setString(4, obj.getBairro());
            consulta.setString(5, obj.getCidade());
            consulta.setString(6, obj.getUf());
            if (obj.getId() > 0) {
                consulta.setLong(7, obj.getId());
            }
            System.out.println(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Endereco carregaObjeto(ResultSet dados) {
        Endereco end = new Endereco();
        try {
            end.setBairro(dados.getString("bairro"));
            end.setId(dados.getLong("id"));
            end.setCep((dados.getString("cep").substring(0, 5) + "-" + dados.getString("cep").substring(5, 8)));
            end.setCidade(dados.getString("cidade"));
            end.setNumero(dados.getInt("numero"));
            end.setRua(dados.getString("rua"));
            end.setUf(dados.getString("uf"));
            return end;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public long maxID() {
        try {
            String sql = "select MAX(id) from enderecos";
            PreparedStatement ps = BD.getConexao().prepareStatement(sql);
            ResultSet dados = ps.executeQuery();
            if (dados.next()) {     
                return dados.getLong(1);                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
