package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Funcionario;
import br.edu.ifnmg.marketmanagement.aplicacao.FuncionarioRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class FuncionarioDAO extends DAOGenerico <Funcionario> implements FuncionarioRepositorio{

    @Override
    protected String consultaAbrir() {
        return "select id,nome, dataNascimento, cpf, telefone, email, salario, cargaHoraria, tipo, senha, cnh from funcionarios where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into funcionarios (nome, dataNascimento, cpf, telefone, email, salario, cargaHoraria, tipo, senha, cnh) values (?,?,?,?,?,?,?,?,?,?)";    }

    @Override
    protected String consultaUpdate() {
        return "update funcionarios set nome = ?, dataNascimento = ?, cpf = ?, telefone = ?, email = ?, salario = ?,cargaHoraria = ?, tipo = ?, senha = ?, cnh = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from funcionarios where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,nome, dataNascimento, cpf, telefone, email, salario, cargaHoraria, tipo, senha, cnh from funcionarios";
    }

    @Override
    protected void carregaParametros(Funcionario obj, PreparedStatement consulta) {
        try{
            consulta.setString(1, obj.getNome());
            consulta.setDate(2, (Date) obj.getDataNascimento());
            consulta.setString(3, obj.getCpf());
            consulta.setString(4, obj.getTelefone());
            consulta.setString(5, obj.getEmail());
            consulta.setBigDecimal(6, obj.getSalario());
            consulta.setInt(7, obj.getCargaHoraria());
            consulta.setInt(8, obj.getTipo());
            consulta.setString(9, obj.getSenha());
            consulta.setString(10, obj.getCnh());            
            if(obj.getId() > 0)
                consulta.setLong(11, obj.getId());            
        }catch(SQLException e){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }
    
    @Override
    protected Funcionario carregaObjeto(ResultSet dados) {
        try {
            Funcionario func = new Funcionario(
                    dados.getBigDecimal("salario"),
                    dados.getInt("cargaHoraria"),
                    dados.getInt("tipo"),
                    dados.getString("senha"),
                    dados.getString("cnh"),
                    dados.getString("nome"),
                    dados.getDate("dataNascimento"),
                    dados.getString("cpf"),
                    null,
                    dados.getLong("id"),
                    null,
                    dados.getString("telefone"),
                    dados.getString("email"),
                    null
            );
            return func;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    @Override
    protected String carregaParametrosBusca(Funcionario obj) {
        String sql = "";        
                
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());        
        if(obj.getCpf() != null && !obj.getCpf().isEmpty()){
            sql = this.filtrarPor(sql, "cpf", obj.getCpf());             
        }
        if(obj.getEmail()!= null && !obj.getEmail().isEmpty()){
            sql = this.filtrarPor(sql, "email", obj.getEmail());             
        }
        if(obj.getSenha()!= null && !obj.getSenha().isEmpty()){
            sql = this.filtrarPor(sql, "senha", obj.getSenha());             
        }
        return sql;
    }
}
