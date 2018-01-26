package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class Funcionario extends PessoaFisica{
    private BigDecimal salario;
    private int cargaHoraria;
    private EnumFuncoes funcao;
    private String senha;
    private String cnh;
    private final BigDecimal TEMP = new BigDecimal(0);

    public Funcionario(BigDecimal salario, int cargaHoraria, EnumFuncoes funcao, String senha, String cnh, String nome, Date dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email, String celular) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email, celular);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.funcao = funcao;
        this.senha = senha;
        this.cnh = cnh;
    }

 

    public Funcionario() {
        this.salario = new BigDecimal(0);
        this.senha = "";
        this.cnh = "";
        try {            
            Endereco n = new Endereco();
            n.setBairro("");
            n.setCep("00000-000");
            n.setCidade("");
            n.setId(0);            
            n.setUf("");
            n.setRua("");
            n.setNumero(0);
            this.setEndereco(n);            
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) throws ViolacaoRegraNegocioException{
        if(salario==null || salario.compareTo(TEMP)==0 || salario.compareTo(TEMP)==-1){
            throw new ViolacaoRegraNegocioException("O salário deve ser maior que 0!"); 
        }
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria)throws ViolacaoRegraNegocioException{
        if(cargaHoraria <= 0){
            throw new ViolacaoRegraNegocioException("O carga horária deve ser maior que 0!"); 
        }
        this.cargaHoraria = cargaHoraria;
    }

    public EnumFuncoes getFuncao() {
        return funcao;
    }

    public void setFuncao(EnumFuncoes funcao) throws ViolacaoRegraNegocioException {
        if(funcao == null){
            throw new ViolacaoRegraNegocioException("A função não pode nula !"); 
        }
        this.funcao = funcao;
    }

    public String getSenha(){       
        return senha;
    }

    public void setSenha(String senha)throws ViolacaoRegraNegocioException{
        if(senha == null || senha.isEmpty() || senha.length() < 8){
            throw new ViolacaoRegraNegocioException("A senha deve ser ter no minimo 8 caracteres!"); 
        }
        this.senha = senha;
    }

    public String getCnh() {
        return cnh;
    }

    //VERIFICAR COM PETRONIO
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return nome;
    }

}
