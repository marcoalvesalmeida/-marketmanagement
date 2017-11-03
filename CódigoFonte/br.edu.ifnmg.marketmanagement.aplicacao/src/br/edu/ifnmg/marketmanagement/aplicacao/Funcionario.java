package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
/**
 *
 * @author guilherme
 */
public class Funcionario extends PessoaFisica{
    private BigDecimal salario;
    private int cargaHoraria;
    private int tipo;
    private String senha;
    private String cnh;
    private final BigDecimal TEMP = new BigDecimal(0);

    public Funcionario(BigDecimal salario, int cargaHoraria, int tipo, String senha, String cnh, String login, String nome, String dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.senha = senha;
        this.cnh = cnh;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) throws ViolacaoRegraNegocioException {
        if(tipo <= 0){
            throw new ViolacaoRegraNegocioException("O tipo deve ser maior que 0!"); 
        }
        this.tipo = tipo;
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

}
