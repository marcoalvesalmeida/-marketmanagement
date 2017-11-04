package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Objects;

/**
 *
 * @author marco
 */
public class ItemTransacao implements Entidade {
    private long id;
    private Produto produto;
    private Lancamento lancamento;
    private long quantidade;

    public ItemTransacao(long id, Produto produto, Lancamento lancamento, long quantidade) {
        this.id = id;
        this.produto = produto;
        this.lancamento = lancamento;
        this.quantidade = quantidade;
    }

    public ItemTransacao() {
    }
    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) throws ViolacaoRegraNegocioException {
        if(produto==null)
            throw new ViolacaoRegraNegocioException("O produto deve ser informado!");
        this.produto = produto;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) throws ViolacaoRegraNegocioException {
        if(lancamento==null)
           throw new ViolacaoRegraNegocioException("O lançamento deve ser informado!");  
        this.lancamento = lancamento;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) throws ViolacaoRegraNegocioException {
        if(quantidade<=0)
            throw new ViolacaoRegraNegocioException("A quantidade deve ser maior que 0!");
            
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.produto);
        hash = 19 * hash + Objects.hashCode(this.lancamento);
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
        final ItemTransacao other = (ItemTransacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.lancamento, other.lancamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemTransacao{" + "id=" + id + ", produto=" + produto + ", lancamento=" + lancamento + ", quantidade=" + quantidade + '}';
    }
    
    
    
    
}
