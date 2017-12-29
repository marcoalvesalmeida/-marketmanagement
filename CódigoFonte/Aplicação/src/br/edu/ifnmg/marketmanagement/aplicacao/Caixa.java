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

public class Caixa implements Entidade {
    private long id;
    private Funcionario operador; 
    private Date dataHoraAbertura;
    private Date dataHoraFechamento;
    private BigDecimal valorInicial;
    private EnumTurno turno;
    private BigDecimal valorDinheiro;
    private BigDecimal valorBoleto;
    private BigDecimal valorCartao;
    private BigDecimal valorCarne;
    private BigDecimal somaVendas;
    private BigDecimal valorProximoCaixa;
    private BigDecimal somaTotalTurno;
    private final BigDecimal TEMP = new BigDecimal(0);
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) throws ViolacaoRegraNegocioException {
        this.id = id;
    }

    public Caixa(long id, Funcionario operador, Date dataHoraAbertura, Date dataHoraFechamento, BigDecimal valorInicial, EnumTurno turno, BigDecimal valorDinheiro, BigDecimal valorBoleto, BigDecimal valorCartao, BigDecimal valorCarne, BigDecimal somaVendas, BigDecimal valorProximoCaixa, BigDecimal somaTotalTurno) {
        this.id = id;
        this.operador = operador;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorInicial = valorInicial;
        this.turno = turno;
        this.valorDinheiro = valorDinheiro;
        this.valorBoleto = valorBoleto;
        this.valorCartao = valorCartao;
        this.valorCarne = valorCarne;
        this.somaVendas = somaVendas;
        this.valorProximoCaixa = valorProximoCaixa;
        this.somaTotalTurno = somaTotalTurno;
    }

    public Funcionario getOperador() {
        return operador;
    }

    public void setOperador(Funcionario operador) throws ViolacaoRegraNegocioException {
        if(operador==null)
            throw new ViolacaoRegraNegocioException("É necessário informar um operador!");
        this.operador = operador;
    }


    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) throws ViolacaoRegraNegocioException {
        if(dataHoraAbertura==null)
            throw new ViolacaoRegraNegocioException("É necessário informar uma data e hora de abertura!");
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) throws ViolacaoRegraNegocioException {
         if(dataHoraFechamento==null)
            throw new ViolacaoRegraNegocioException("É necessário informar uma data e hora de fechamento!");
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) throws ViolacaoRegraNegocioException {
        if(valorInicial==null || valorInicial.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorInicial = valorInicial;
    }

    public EnumTurno getTurno() {
        return turno;
    }

    public void setTurno(EnumTurno turno) throws ViolacaoRegraNegocioException {
        if(turno==null)
            throw new ViolacaoRegraNegocioException("É necessário informar um turno válido!");
        this.turno = turno;
    }

    public BigDecimal getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(BigDecimal valorDinheiro) throws ViolacaoRegraNegocioException {
        if(valorDinheiro==null || valorDinheiro.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorDinheiro = valorDinheiro;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) throws ViolacaoRegraNegocioException {
        if(valorBoleto==null || valorBoleto.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorBoleto = valorBoleto;
    }

    public BigDecimal getValorCartao() {
        return valorCartao;
    }

    public void setValorCartao(BigDecimal valorCartao) throws ViolacaoRegraNegocioException {
        if(valorCartao==null || valorCartao.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorCartao = valorCartao;
    }

    public BigDecimal getValorCarne() {
        return valorCarne;
    }

    public void setValorCarne(BigDecimal valorCarne) throws ViolacaoRegraNegocioException {
        if(valorCarne==null || valorCarne.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorCarne = valorCarne;
    }

    public BigDecimal getSomaVendas() {
        return somaVendas;
    }

    public void setSomaVendas(BigDecimal somaVendas) throws ViolacaoRegraNegocioException {
        if(somaVendas==null || somaVendas.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.somaVendas = somaVendas;
    }

    public BigDecimal getValorProximoCaixa() {
        return valorProximoCaixa;
    }

    public void setValorProximoCaixa(BigDecimal valorProximoCaixa) throws ViolacaoRegraNegocioException {
        if(valorProximoCaixa==null || valorProximoCaixa.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.valorProximoCaixa = valorProximoCaixa;
    }

    public BigDecimal getSomaTotalTurno() {
        return somaTotalTurno;
    }

    public void setSomaTotalTurno(BigDecimal somaTotalTurno) throws ViolacaoRegraNegocioException {
        if(somaTotalTurno==null || somaTotalTurno.compareTo(TEMP)<0)
            throw new ViolacaoRegraNegocioException("É necessário informar um valor maior ou igual a 0!");
        this.somaTotalTurno = somaTotalTurno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.operador);
        hash = 67 * hash + Objects.hashCode(this.dataHoraAbertura);
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
        final Caixa other = (Caixa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraAbertura, other.dataHoraAbertura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", operador=" + operador + " dataHoraAbertura=" + dataHoraAbertura + ", dataHoraFechamento=" + dataHoraFechamento + '}';
    }
}
