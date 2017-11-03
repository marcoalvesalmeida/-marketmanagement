package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
/**
 *
 * @author guilherme
 */
public class Produto implements Entidade {
    
    private long id;
    private String descricao;
    private Categoria categoria;
    private BigDecimal valorCusto;
    private BigDecimal valorVarejo;
    private BigDecimal valorAtacado;
    private int codigo;
    private EnumUnidadeMedida unMedida;
    private long pontuacao;
    private long estoqueMinimo;
    private long estoqueAtual;
    private boolean ativo;
    private String informacoesAdicionais; 
    private boolean fracionar;
    private Fornecedor fornecedor;    

    @Override
    public long getId(){
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Produto(long id, String descricao, Categoria categoria, BigDecimal valorCusto, BigDecimal valorVarejo, BigDecimal valorAtacado, int codigo, EnumUnidadeMedida unMedida, long pontuacao, long estoqueMinimo, long estoqueAtual, boolean ativo, String informacoesAdicionais, boolean fracionar, Fornecedor fornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorCusto = valorCusto;
        this.valorVarejo = valorVarejo;
        this.valorAtacado = valorAtacado;
        this.codigo = codigo;
        this.unMedida = unMedida;
        this.pontuacao = pontuacao;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueAtual = estoqueAtual;
        this.ativo = ativo;
        this.informacoesAdicionais = informacoesAdicionais;
        this.fracionar = fracionar;
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

    public BigDecimal getValorVarejo() {
        return valorVarejo;
    }

    public void setValorVarejo(BigDecimal valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    public BigDecimal getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(BigDecimal valorAtacado) {
        this.valorAtacado = valorAtacado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public EnumUnidadeMedida getUnMedida() {
        return unMedida;
    }

    public void setUnMedida(EnumUnidadeMedida unMedida) {
        this.unMedida = unMedida;
    }

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public long getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(long estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public long getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(long estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public boolean isFracionar() {
        return fracionar;
    }

    public void setFracionar(boolean fracionar) {
        this.fracionar = fracionar;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }    
   
}
