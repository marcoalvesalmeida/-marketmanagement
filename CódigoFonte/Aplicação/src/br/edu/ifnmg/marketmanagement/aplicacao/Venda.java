package br.edu.ifnmg.marketmanagement.aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Venda extends Lancamento{
    private String turno;
    private long terminal;
    private long controle;
    private Funcionario operador;
    private ArrayList<ItemTransacao> itens;

    public Venda(String turno, long terminal, long controle, Funcionario operador, ArrayList<ItemTransacao> itens, long id, Date data, String tipo, BigDecimal valorTotal, String modo, BigDecimal acrescimo, BigDecimal desconto, Cliente cliente, String planejamento) {
        super(id, data, tipo, valorTotal, modo, acrescimo, desconto, cliente, planejamento);
        this.turno = turno;
        this.terminal = terminal;
        this.controle = controle;
        this.operador = operador;
        this.itens = itens;
    }

    public Venda() {
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) throws ViolacaoRegraNegocioException {
        if(turno==null || turno.length()>4)
            throw new ViolacaoRegraNegocioException("O turno deve ser informado e deve conter mais de 4 letra(Manhã, Tarde, Noite)");
        this.turno = turno;
    }

    public long getTerminal() {
        return terminal;
    }

    public void setTerminal(long terminal) throws ViolacaoRegraNegocioException {
        if(terminal<=0)
            throw new ViolacaoRegraNegocioException("O Terminal deve ser representado por um número inteiro maior que 0");              
        this.terminal = terminal;
    }

    public long getControle() {
        return controle;
    }

    public void setControle(long controle) throws ViolacaoRegraNegocioException {
        if(controle<=0)
            throw new ViolacaoRegraNegocioException("O Terminal deve ser representado por um número inteiro maior que 0");
        this.controle = controle;
    }

    public Funcionario getOperador() {
        return operador;
    }

    public void setOperador(Funcionario operador) throws ViolacaoRegraNegocioException {
        if(operador==null || operador.getId()<=0)
            throw new ViolacaoRegraNegocioException("Não é possível inserir funcionário nulo ou inexistente!");
        this.operador = operador;
    }
    
    
}
