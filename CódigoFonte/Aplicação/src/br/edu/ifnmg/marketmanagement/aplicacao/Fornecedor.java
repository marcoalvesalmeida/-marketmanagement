package br.edu.ifnmg.marketmanagement.aplicacao;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
 */
public class Fornecedor extends Pessoa {    
    private String razaoSocial;
    private String cnpj;
    private String informacoesAdicionais;
    private boolean ativo;

    public Fornecedor(String razaoSocial, String cnpj, String informacoesAdicionais, String inscricaoEstadual, boolean ativo, long id, Endereco endereco, String telefone, String email, String celular) {
        super(id, endereco, telefone, email, celular);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.informacoesAdicionais = informacoesAdicionais;
        this.ativo = ativo;
    }

    public Fornecedor() {
        try {
            super.setEndereco(new Endereco());
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) throws ViolacaoRegraNegocioException{
        if(razaoSocial==null){
            throw new ViolacaoRegraNegocioException("A razão social não pode ser atribuida como nula!");
        }
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    //VERIFICAR COM PETRONIO
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.razaoSocial);
        hash = 71 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.razaoSocial, other.razaoSocial)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return razaoSocial ;
    } 
  
}
