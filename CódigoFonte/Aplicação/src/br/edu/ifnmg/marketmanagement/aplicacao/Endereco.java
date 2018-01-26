package br.edu.ifnmg.marketmanagement.aplicacao;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author guilherme
 */
public class Endereco implements Entidade {
    private long id;
    private String rua;
    private String cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
    private static Pattern regex_cep = Pattern.compile("^\\d{5}\\-\\d{3}$");
    
    public Endereco(long id, String rua, String cep, int numero, String bairro, String cidade, String uf) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;        
        this.cidade = cidade;
        this.uf = uf;
    }  

    public Endereco() {
        this.uf = "MG";
        
    }

    @Override
    public long getId(){
        return id;
    }
    
    @Override
    public void setId(long id){       
        this.id = id;        
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ViolacaoRegraNegocioException{
        if (rua == null){
            throw new ViolacaoRegraNegocioException("A rua não pode ser atribuida como nula!");
        }
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws ViolacaoRegraNegocioException{
        Matcher verificador = regex_cep.matcher(cep);
        if (cep == null || cep.isEmpty() || ! verificador.matches()){
            throw new ViolacaoRegraNegocioException("O cep deve estar no formato #####-###");
        }
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ViolacaoRegraNegocioException{
        if (bairro == null){
            throw new ViolacaoRegraNegocioException("O bairro não pode ser atribuido como nulo!");
        }
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade)throws ViolacaoRegraNegocioException {
        if (cidade == null){
            throw new ViolacaoRegraNegocioException("A cidade não pode ser atribuida como nula!");
        }
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) throws ViolacaoRegraNegocioException {
        if (uf == null){
            throw new ViolacaoRegraNegocioException("A UF não pode ser atribuida como nula!");
        }
        this.uf = uf;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", cep=" + cep + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + '}';
    }

}
