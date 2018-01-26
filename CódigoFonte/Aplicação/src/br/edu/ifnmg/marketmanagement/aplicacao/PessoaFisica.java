package br.edu.ifnmg.marketmanagement.aplicacao;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author guilherme
 */
public abstract class PessoaFisica extends Pessoa{
    String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private static Pattern regex_cpf = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

    public PessoaFisica(String nome, Date dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email, String celular) {
        super(id, endereco, telefone, email, celular);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
    }

 
    public PessoaFisica(){
        this.dataNascimento =  new Date ("01/01/01111");
    }
    
  
    public String getNome(){
        return nome;
    }

    public void setNome(String nome)throws ViolacaoRegraNegocioException{
        if(nome==null || nome.length() < 8 || nome.isEmpty()){
            throw new ViolacaoRegraNegocioException("O nome deve possuir no minimo 8 caracteres!");
        }
        this.nome = nome;
    }

    public Date getDataNascimento() {        
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento)throws ViolacaoRegraNegocioException{          
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        if (cpf != null)
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
        return cpf;
    }

    public void setCpf(String cpf) throws ViolacaoRegraNegocioException {
        Matcher verificador = regex_cpf.matcher(cpf);
        if(cpf == null || cpf.isEmpty() || ! verificador.matches())
            throw new ViolacaoRegraNegocioException("O CPF deve estar no formato ###.###.###-##!");
        this.cpf = cpf.replace(".", "").replace("-", "");
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) throws ViolacaoRegraNegocioException {
        if (rg == null || rg.isEmpty()){
            throw new ViolacaoRegraNegocioException("O rg não pode ser lancao como nulo!");
        }
        this.rg = rg;
    }  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return  nome;
    }
    
    
}
