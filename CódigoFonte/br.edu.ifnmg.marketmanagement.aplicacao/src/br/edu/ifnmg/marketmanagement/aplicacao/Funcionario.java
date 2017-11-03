package br.edu.ifnmg.marketmanagement.aplicacao;
/**
 *
 * @author guilherme
 */
public class Funcionario extends PessoaFisica{
    private Double salario;
    private Double cargaHoraria;
    private String tipo;
    private String senha;
    private String cnh;
    private String login;

    public Funcionario(Double salario, Double cargaHoraria, String tipo, String senha, String cnh, String login, String nome, String dataNascimento, String cpf, String rg, long id, Endereco endereco, Telefone[] telefone, String email) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.senha = senha;
        this.cnh = cnh;
        this.login = login;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
   
}
