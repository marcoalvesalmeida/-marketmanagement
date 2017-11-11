package br.edu.ifnmg.marketmanagement.aplicacao;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author guilherme
 */
public abstract class PessoaFisica extends Pessoa{
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private static Pattern regex_cpf = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

    public PessoaFisica(String nome, String dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email) {
        super(id, endereco, telefone, email);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
    }   

    public PessoaFisica(){
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

    public String getDataNascimento() {        
        return dataNascimento.substring(0,2)+"-"+dataNascimento.substring(2,4)+"-"+dataNascimento.substring(4,8);
    }

    public void setDataNascimento(String dataNascimento)throws ViolacaoRegraNegocioException{
        if(!dataNascimento.matches("^\\d{2}\\-\\d{2}\\-\\d{4}$") || dataNascimento == null){
            throw new ViolacaoRegraNegocioException("A data de nascimento deve ter o seguinte padrão: dd-mm-aaaa"); 
        }      
        this.dataNascimento = dataNascimento.replace("-", "");
    }

    public String getCpf() {
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
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
}
