package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Cliente;
import br.edu.ifnmg.marketmanagement.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import static com.mysql.jdbc.Messages.getString;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class ClienteDAO extends DAOGenerico <Cliente> implements ClienteRepositorio{

    @Override
    protected String consultaAbrir() {
        return "select id,nome,dataNascimento,cpf,rg,telefone,celular,email, informacoesAdicionais, saldoCompras, descontos from clientes where id= ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into clientes (nome, dataNascimento, cpf, rg, telefone,celular, email,informacoesAdicionais, saldoCompras,descontos ) values (?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update clientes set nome = ?, dataNascimento = ?,cpf = ?, rg = ?, telefone = ?,celular=?, email = ?, informacoesAdicionais = ?,saldoCompras =?, descontos=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id,nome,dataNascimento,cpf,rg,telefone,celular,email,informacoesAdicionais,saldoCompras,descontos from clientes  ";
    }

    @Override
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        try{            
            consulta.setString(1, obj.getNome());
            consulta.setDate(2, (Date) obj.getDataNascimento());
            consulta.setString(3, obj.getCpf());
            consulta.setString(4, obj.getRg());           
            consulta.setString(5, obj.getTelefone());
            consulta.setString(6, obj.getEmail());
            consulta.setString(7, obj.getInformacoesAdicionais());
            consulta.setBigDecimal(8, obj.getSaldoCompras());
            consulta.setBigDecimal(9, obj.getDescontos());
                        
            if(obj.getId() > 0)
                consulta.setLong(10, obj.getId()); 
            
        }catch(SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
    }

    @Override
    protected Cliente carregaObjeto(ResultSet dados) {
      
        Cliente cli = new Cliente();
        try {
            cli.setNome(dados.getString("nome"));
            cli.setId(dados.getLong("id"));
            cli.setEmail(dados.getString("email"));          
            cli.setCpf(dados.getString("cpf").substring(0,3)+"."+dados.getString("cpf").substring(3,6)+"."+dados.getString("cpf").substring(6,9)+"-"+dados.getString("cpf").substring(9,11));
            cli.setTelefone(dados.getString("telefone"));
            cli.setRg(dados.getString("rg"));
            cli.setDataNascimento(dados.getDate("dataNascimento"));
            cli.setCelular(dados.getString("celular"));
            cli.setDescontos(dados.getBigDecimal("descontos"));
            cli.setInformacoesAdicionais(dados.getString("informacoesAdicionais"));
            cli.setSaldoCompras(dados.getBigDecimal("saldoCompras"));
            
            return cli;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    
    protected String carregaParametrosBusca(Cliente obj){
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
