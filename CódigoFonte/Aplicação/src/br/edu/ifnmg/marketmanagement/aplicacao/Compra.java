package br.edu.ifnmg.marketmanagement.aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Compra extends Lancamento{
    private Fornecedor fornecedor;
    private ArrayList<Produto> itens;

    public Compra(Fornecedor fornecedor, ArrayList<Produto> itens, long id, Date data, String tipo, BigDecimal valorTotal, String modo, BigDecimal acrescimo, BigDecimal desconto, Cliente cliente, String planejamento) {
        super(id, data, tipo, valorTotal, modo, acrescimo, desconto, cliente, planejamento);
        this.fornecedor = fornecedor;
        this.itens = itens;
    }

    public Compra() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) throws ViolacaoRegraNegocioException {
        if(fornecedor==null)
            throw new ViolacaoRegraNegocioException("É preciso informar um fornecedor!");
        this.fornecedor = fornecedor;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) throws ViolacaoRegraNegocioException {
        if(itens==null)
            throw new ViolacaoRegraNegocioException("É preciso informar um item!");
        this.itens = itens;
    }

    @Override
    public String toString() {
        return super.toString()+"Compra{" + "fornecedor=" + fornecedor + ", itens=" + itens + '}';
    }
    
    
}
