/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.aplicacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Lancamento implements Entidade {
    private long id;
    private Date data;
    private String tipo;
    private BigDecimal valorTotal;
    private String modo;
    private BigDecimal acrescimo;
    private BigDecimal desconto;
    private Cliente cliente;
    private String planejamento;
    private final BigDecimal TEMP = new BigDecimal(0);

    public Lancamento(long id, Date data, String tipo, BigDecimal valorTotal, String modo, BigDecimal acrescimo, BigDecimal desconto,Cliente cliente, String planejamento) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.modo = modo;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
        this.cliente = cliente;
        this.planejamento = planejamento;
    }

    public Lancamento() {
    }
    
     @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) throws ViolacaoRegraNegocioException {
        if (id<=0)
            throw new ViolacaoRegraNegocioException("Número inválido!");
        this.id = id;     
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) throws ViolacaoRegraNegocioException {
        if(data==null)
            throw new ViolacaoRegraNegocioException("Data possui formato inválido!");
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws ViolacaoRegraNegocioException {
        if(tipo==null || tipo.length()<5)
            throw new ViolacaoRegraNegocioException("Tipo foi informado de forma incorreta!(Deve possuir no mínimo 5 caracteres");
        this.tipo = tipo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) throws ViolacaoRegraNegocioException {
        if(valorTotal==null || valorTotal.compareTo(TEMP)<=0)
             throw new ViolacaoRegraNegocioException("O valor deve ser maior que 0!");  
        this.valorTotal = valorTotal;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) throws ViolacaoRegraNegocioException {
        if(modo==null)
             throw new ViolacaoRegraNegocioException("É necessário informar um modo de lançamento!");
        this.modo = modo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) throws ViolacaoRegraNegocioException {
        if(acrescimo==null || acrescimo.compareTo(TEMP)<=0)
            throw new ViolacaoRegraNegocioException("O acréscimo deve ser maior que 0!"); 
        this.acrescimo = acrescimo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) throws ViolacaoRegraNegocioException {
        if(desconto==null || desconto.compareTo(TEMP)<=0)
            throw new ViolacaoRegraNegocioException("O desconto deve ser maior que 0!"); 
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws ViolacaoRegraNegocioException {
        if(cliente==null)
            throw new ViolacaoRegraNegocioException("É necessário informar um cliente!"); 
        this.cliente = cliente;
    }

    public String getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(String planejamento) throws ViolacaoRegraNegocioException {
        if(planejamento==null)
            throw new ViolacaoRegraNegocioException("É necessário informar um planejamento!"); 
        this.planejamento = planejamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.data);
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
        final Lancamento other = (Lancamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lancamento{" + "id=" + id + ", data=" + data + ", tipo=" + tipo + ", valorTotal=" + valorTotal + '}';
    }
    
    
   
}
