package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author guilherme
 */
public class Fornecedor extends Pessoa {    
    private String razaoSocial;
    private String cnpj;

    public Fornecedor(String razaoSocial, String cnpj, long id, Endereco endereco, String telefone, String email) {
        super(id, endereco, telefone, email);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

  

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
  
}
