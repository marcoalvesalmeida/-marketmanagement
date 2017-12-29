
package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Entrega implements Entidade {
    private long id;
    private Venda venda;
    private Veiculo veiculo;
    private Endereco endereco;
    private Funcionario motorista;
    private Date data;

    public Entrega(long id, Venda venda, Veiculo veiculo, Endereco endereco, Funcionario motorista, Date data) {
        this.id = id;
        this.venda = venda;
        this.veiculo = veiculo;
        this.endereco = endereco;
        this.motorista = motorista;
        this.data = data;
    }

    public Entrega() {
        
    }
    
    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id)throws ViolacaoRegraNegocioException {
        if(id<=0)
            throw new ViolacaoRegraNegocioException("Número inválido!");
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) throws ViolacaoRegraNegocioException {
        if(venda==null || venda.getId()<=0){
            throw new ViolacaoRegraNegocioException("Referência a venda inválida!");
        }
        this.venda=venda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcionario getMotorista() {
        return motorista;
    }

    public void setMotorista(Funcionario motorista) throws ViolacaoRegraNegocioException {
        if(motorista==null)
             throw new ViolacaoRegraNegocioException("A referência está vazia!");  
        this.motorista = motorista;
    }
    
    public void gerarRelatorio(){
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.venda);
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
        final Entrega other = (Entrega) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Entrega{" + "id=" + id + ", Venda=" + venda.getId() + ", Endereco=" + endereco + '}';
    }
        
    
}
