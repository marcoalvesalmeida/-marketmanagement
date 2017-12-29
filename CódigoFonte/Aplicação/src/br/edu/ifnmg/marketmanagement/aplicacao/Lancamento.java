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
    private BigDecimal valor;
    private BigDecimal valorTotal;
    private EnumModoPagamento modo;
    private BigDecimal acrescimo;
    private BigDecimal desconto;
    private Cliente cliente;
    private EnumPlanejamento planejamento;
    private Date dataInicial;
    private Date dataFinal;
    private final BigDecimal TEMP = new BigDecimal(0);

    public Lancamento(long id, Date data, String tipo, BigDecimal valor, BigDecimal valorTotal, EnumModoPagamento modo, BigDecimal acrescimo, BigDecimal desconto,Cliente cliente, EnumPlanejamento planejamento) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.modo = modo;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
        this.cliente = cliente;
        this.planejamento = planejamento;
        this.valor=valor;
    }
    
    public Lancamento(String generic){
        
    }

    public Lancamento() {
        this.id = 0;
        this.data = new Date();
        this.tipo = "receita";
        this.valor= new BigDecimal(100);
        this.valorTotal = new BigDecimal(100);
        this.modo = EnumModoPagamento.valueOf("CRÉDITO");
        this.acrescimo = new BigDecimal(0);
        this.desconto = new BigDecimal(0);
        this.cliente = new Cliente();
        this.planejamento = EnumPlanejamento.valueOf("DESPESAS");
    }
    
     @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) throws ViolacaoRegraNegocioException {
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
            throw new ViolacaoRegraNegocioException("Tipo deve possuir no mínimo 5 caracteres!");
        this.tipo = tipo;
    }
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) throws ViolacaoRegraNegocioException {
        if(valorTotal==null || valorTotal.compareTo(TEMP)<=0)
             throw new ViolacaoRegraNegocioException("O valor deve ser maior que 0!");  
        this.valorTotal = valorTotal;
    }

    public EnumModoPagamento getModo() {
        return modo;
    }

    public void setModo(EnumModoPagamento modo) throws ViolacaoRegraNegocioException {
        if(modo==null)
             throw new ViolacaoRegraNegocioException("É necessário informar um modo de lançamento!");
        this.modo = modo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) throws ViolacaoRegraNegocioException {
        if(acrescimo==null)
            throw new ViolacaoRegraNegocioException("O acréscimo deve ser maior que 0!"); 
        this.acrescimo = acrescimo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) throws ViolacaoRegraNegocioException {
        if(desconto==null)
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

    public EnumPlanejamento getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(EnumPlanejamento planejamento) throws ViolacaoRegraNegocioException {
        if(planejamento==null)
            throw new ViolacaoRegraNegocioException("É necessário informar um planejamento!"); 
        this.planejamento = planejamento;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
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
