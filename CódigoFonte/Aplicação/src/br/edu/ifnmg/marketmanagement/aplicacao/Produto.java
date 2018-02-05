package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private final BigDecimal TEMP = new BigDecimal(0);

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
    
    public Produto() {  
        this.valorCusto = new BigDecimal(0);
        this.valorVarejo =  new BigDecimal(0);
        this.valorAtacado =  new BigDecimal(0);
  
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao)throws ViolacaoRegraNegocioException {
        if(descricao == null || descricao.isEmpty()){
            throw new ViolacaoRegraNegocioException("A descrição não pode ficar vazia!"); 
        }
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

   
    public void setCategoria(Categoria categoria) throws ViolacaoRegraNegocioException{
        if(categoria == null){
            throw new ViolacaoRegraNegocioException("A categoria não pode ser nula!"); 
        }
        this.categoria = categoria;
    }

    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) throws ViolacaoRegraNegocioException {
        if(valorCusto==null || valorCusto.compareTo(TEMP)==0 || valorCusto.compareTo(TEMP)==-1){
            throw new ViolacaoRegraNegocioException("O valor de custo deve ser maior que 0!");
        }    
        this.valorCusto = valorCusto;
    }

    public BigDecimal getValorVarejo() {          
        return valorVarejo;
    }

    public void setValorVarejo(BigDecimal valorVarejo) throws ViolacaoRegraNegocioException {
        if(valorVarejo==null || valorVarejo.compareTo(TEMP)==0 || valorVarejo.compareTo(TEMP)==-1){
            throw new ViolacaoRegraNegocioException("O valor de varejo deve ser maior que 0!");
        } 
        this.valorVarejo = valorVarejo;
    }

    public BigDecimal getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(BigDecimal valorAtacado) throws ViolacaoRegraNegocioException {
        if(valorAtacado==null || valorAtacado.compareTo(TEMP)==0 || valorAtacado.compareTo(TEMP)==-1){
            throw new ViolacaoRegraNegocioException("O valor de atacado deve ser maior que 0!");
        } 
        this.valorAtacado = valorAtacado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ViolacaoRegraNegocioException{
        if(codigo <= 0){
            throw new ViolacaoRegraNegocioException("O codigo deve ser maior que 0!");
        }
        this.codigo = codigo;
    }

    public EnumUnidadeMedida getUnMedida() {
        return unMedida;
    }

    public void setUnMedida(EnumUnidadeMedida unMedida) throws ViolacaoRegraNegocioException {
        if(unMedida == null){
            throw new ViolacaoRegraNegocioException("A unidade de medida deve ser informada!");
        }
        this.unMedida = unMedida;
    }

    public long getPontuacao() {
        return pontuacao;
    }
    
    //ver com marco
    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public long getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(long estoqueMinimo) throws ViolacaoRegraNegocioException{
        if(estoqueMinimo < 0){
            throw new ViolacaoRegraNegocioException("O estoque minimo não pode ser menor que 0!");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public long getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(long estoqueAtual) throws ViolacaoRegraNegocioException {
        if (estoqueAtual < 0){
            throw new ViolacaoRegraNegocioException("O estoque atual não pode ser menor que 0!");
        }
        this.estoqueAtual = estoqueAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo){       
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

    public void setFornecedor(Fornecedor fornecedor) throws ViolacaoRegraNegocioException {
        if (fornecedor == null){
            throw new ViolacaoRegraNegocioException("O fornecedor não pode ser nulo!");
        }
        this.fornecedor = fornecedor;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + this.codigo;
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    } 

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", categoria=" + categoria + ", valorCusto=" + valorCusto + ", valorVarejo=" + valorVarejo + ", valorAtacado=" + valorAtacado + ", codigo=" + codigo + ", unMedida=" + unMedida + ", pontuacao=" + pontuacao + ", estoqueMinimo=" + estoqueMinimo + ", estoqueAtual=" + estoqueAtual + ", ativo=" + ativo + ", informacoesAdicionais=" + informacoesAdicionais + ", fracionar=" + fracionar + ", fornecedor=" + fornecedor + '}';
    }
  
}
