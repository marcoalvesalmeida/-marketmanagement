package br.edu.ifnmg.marketmanagement.persistencia;
import br.edu.ifnmg.marketmanagement.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumFuncoes;
import br.edu.ifnmg.marketmanagement.aplicacao.Funcionario;
import br.edu.ifnmg.marketmanagement.aplicacao.FuncionarioRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
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
    EnderecoRepositorio endereco = RepositorioBuilder.getEnderecoRepositorio();
    
    @Override
    protected String consultaAbrir() {
        return "select id,nome, dataNascimento,endereco, cpf, rg,telefone,celular, email, salario, cargaHoraria, funcao, senha, cnh from funcionarios where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into funcionarios (nome, dataNascimento,endereco, cpf, rg,telefone,celular,  email, salario, cargaHoraria, funcao, senha, cnh) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";    }

    @Override
    protected String consultaUpdate() {
        return "update funcionarios set nome = ?, dataNascimento = ?,endereco =?, cpf = ?, rg =?, telefone = ?,celular =?, email = ?, salario = ?,cargaHoraria = ?, funcao = ?, senha = ?, cnh = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from funcionarios where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,nome, dataNascimento,endereco, cpf, rg, telefone,celular,  email, salario, cargaHoraria, funcao, senha, cnh from funcionarios";
    }

    @Override
    protected void carregaParametros(Funcionario obj, PreparedStatement consulta) {
        try{
            consulta.setString(1, obj.getNome());
            consulta.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
            consulta.setInt(3, Integer.parseInt(String.valueOf(obj.getEndereco().getId())));
            consulta.setString(4, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(5, obj.getRg());
            consulta.setString(6, obj.getTelefone().replace("-", ""));
            consulta.setString(7, obj.getCelular().replace("-", ""));
            consulta.setString(8, obj.getEmail());
            consulta.setBigDecimal(9, obj.getSalario());
            consulta.setInt(10, obj.getCargaHoraria());
            consulta.setString(11, obj.getFuncao().toString());
            consulta.setString(12, obj.getSenha());
            consulta.setString(13, obj.getCnh());            
            if(obj.getId() > 0)
                consulta.setLong(14, obj.getId()); 
            System.out.println(consulta);
        }catch(SQLException e){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }

    @Override
    protected Funcionario carregaObjeto(ResultSet dados) {
        Funcionario func = new Funcionario();
        try {
            func.setId(dados.getLong("id"));            
            func.setNome(dados.getString("nome"));
            func.setDataNascimento(dados.getDate("dataNascimento"));
            func.setCpf(dados.getString("cpf").substring(0,3)+"."+dados.getString("cpf").substring(3,6)+"."+dados.getString("cpf").substring(6,9)+"-"+dados.getString("cpf").substring(9,11));
            func.setRg(dados.getString("rg"));
            func.setEndereco(endereco.abrir(dados.getInt("endereco")));
            func.setTelefone(dados.getString("telefone").substring(0,2)+"-"+dados.getString("telefone").substring(2,10));
            func.setEmail(dados.getString("email"));
            func.setSalario(dados.getBigDecimal("salario"));
            func.setCargaHoraria(dados.getInt("cargaHoraria"));
            String teste = dados.getString("celular");           
            func.setCelular(teste.substring(0,2)+"-"+teste.substring(2, 11));          
            func.setFuncao(EnumFuncoes.valueOf(dados.getString("funcao")));
            func.setSenha(dados.getString("senha"));
            func.setCnh(dados.getString("cnh"));
            return func;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    @Override
    protected String carregaParametrosBusca(Funcionario obj) {
        String sql = ""; 
        
                if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
             
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome()); 
        
      if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));       
        return sql;
    }
}
