package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Objects;

/**
 *
 * @author guilherme
 */
public class Categoria implements Entidade{    
    private long id;
    private String descricao;

    public Categoria(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
     public Categoria() {
       
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws ViolacaoRegraNegocioException{
        if(descricao == null){
            throw new ViolacaoRegraNegocioException("A descrição não pode ser atribuida como nula!");
        }
        this.descricao = descricao;
    }   

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.descricao);
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
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    } 
}
