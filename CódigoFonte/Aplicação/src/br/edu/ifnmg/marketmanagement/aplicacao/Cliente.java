package br.edu.ifnmg.marketmanagement.aplicacao;
/**
 *
 * @author guilherme
 */
public class Cliente extends PessoaFisica {
    public Cliente(String nome, String dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email);
    } 

    public Cliente() {
    }


  
}
