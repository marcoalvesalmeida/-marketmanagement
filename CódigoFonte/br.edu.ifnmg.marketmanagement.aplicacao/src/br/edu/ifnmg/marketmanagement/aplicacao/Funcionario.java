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
    private String login;

    public Funcionario(BigDecimal salario, int cargaHoraria, int tipo, String senha, String cnh, String login, String nome, String dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.senha = senha;
        this.cnh = cnh;
        this.login = login;
    }

 
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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
