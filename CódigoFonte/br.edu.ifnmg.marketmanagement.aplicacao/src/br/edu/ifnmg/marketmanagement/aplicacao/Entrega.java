
package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author marco
 */
public class Entrega implements Entidade {
    private long id;
    private long venda;
    private Veiculo veiculo;
    private Endereco endereco;
    private Funcionario motorista;

    public Entrega(long id, long venda, Veiculo veiculo, Endereco endereco, Funcionario motorista) {
        this.id = id;
        this.venda = venda;
        this.veiculo = veiculo;
        this.endereco = endereco;
        this.motorista = motorista;
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

    public long getVenda() {
        return venda;
    }

    public void setVenda(long venda) throws ViolacaoRegraNegocioException {
        if(venda<=0){
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (int) (this.venda ^ (this.venda >>> 32));
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
        if (this.venda != other.venda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrega{" + "id=" + id + ", Venda=" + venda + ", Endereco=" + endereco + '}';
    }
        
    
}
