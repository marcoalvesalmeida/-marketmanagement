package br.edu.ifnmg.marketmanagement.aplicacao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
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
    
}
