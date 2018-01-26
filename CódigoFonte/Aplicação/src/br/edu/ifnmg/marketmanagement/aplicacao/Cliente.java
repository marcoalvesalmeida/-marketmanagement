package br.edu.ifnmg.marketmanagement.aplicacao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
        try {
            this.saldoCompras = new BigDecimal(0);
            this.descontos = new BigDecimal(0);
            Endereco n = new Endereco();
            n.setBairro("");
            n.setCep("00000-000");
            n.setCidade("");
            n.setId(0);            
            n.setUf("");
            n.setRua("");
            n.setNumero(0);
            this.setEndereco(n);            
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
           
             
                
            
            
     
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
