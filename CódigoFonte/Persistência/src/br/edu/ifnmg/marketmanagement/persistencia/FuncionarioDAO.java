package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.Funcionario;
import br.edu.ifnmg.marketmanagement.aplicacao.FuncionarioRepositorio;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String consultaBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void carregaParametros(Funcionario obj, PreparedStatement consulta) {
        try{
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getDataNascimento());
            consulta.setString(3, obj.getCpf());
            consulta.setString(4, obj.getTelefone());
            consulta.setString(5, obj.getEmail());
            consulta.setBigDecimal(6, obj.getSalario());
            consulta.setInt(7, obj.getCargaHoraria());
            consulta.setInt(8, obj.getTipo());
            consulta.setString(9, obj.getSenha());
            consulta.setString(10, obj.getCnh());            
            if(obj.getId() > 0)
                consulta.setLong(10, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }

    @Override
    protected Funcionario carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    @Override
    protected String carregaParametrosBusca(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
