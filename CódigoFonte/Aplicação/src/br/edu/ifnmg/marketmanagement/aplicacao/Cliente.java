package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author guilherme
 */
public class Cliente extends PessoaFisica {
    private BigDecimal saldoCompras;
    private BigDecimal descontos;
    private String informacoesAdicionais;

    public Cliente(BigDecimal saldoCompras, BigDecimal descontos, String informacoesAdicionais, String nome, Date dataNascimento, String cpf, String rg, long id, Endereco endereco, String telefone, String email, String celular) {
        super(nome, dataNascimento, cpf, rg, id, endereco, telefone, email, celular);
        this.saldoCompras = saldoCompras;
        this.descontos = descontos;
        this.informacoesAdicionais = informacoesAdicionais;
    }

   
    public Cliente() {
    }

    public BigDecimal getSaldoCompras() {
        return saldoCompras;
    }

    public void setSaldoCompras(BigDecimal saldoCompras) {
        this.saldoCompras = saldoCompras;
    }

    public BigDecimal getDescontos() {
        return descontos;
    }

    public void setDescontos(BigDecimal descontos) {
        this.descontos = descontos;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

   


  
}
