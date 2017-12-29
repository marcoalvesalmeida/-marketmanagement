package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Veiculo implements Entidade{
    private long id;
    private String modelo;
    private String placa;
    private String chassi;
    private EnumTipoVeiculo tipo;
    private long anoFab;
    private EnumMarcaVeiculo marca;
    private EnumCombustivel combustivel;   
    private String observacoes;

    public Veiculo(long id, String modelo, String placa, String chassi, EnumTipoVeiculo tipo, long anoFab, EnumMarcaVeiculo marca, EnumCombustivel combustivel, String observacoes) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.tipo = tipo;
        this.anoFab = anoFab;
        this.marca = marca;
        this.combustivel = combustivel;
        this.observacoes = observacoes;
    }

    public Veiculo(long id, String modelo, String placa, String chassi, long anoFab, String observacoes) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.anoFab = anoFab;
        this.observacoes = observacoes;
    }

    public Veiculo(String modelo, String placa, String chassi, EnumTipoVeiculo tipo, long anoFab, EnumMarcaVeiculo marca, EnumCombustivel combustivel, String observacoes) {
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.tipo = tipo;
        this.anoFab = anoFab;
        this.marca = marca;
        this.combustivel = combustivel;
        this.observacoes = observacoes;
    }

    public Veiculo(long id, String modelo, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Veiculo() {
    }
    

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws ViolacaoRegraNegocioException{
        if(modelo==null)
            throw new ViolacaoRegraNegocioException("O modelo não pode ser atribuido como nulo!");
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws ViolacaoRegraNegocioException {
        if(!placa.matches("[A-Z]{3,3}-\\d{4,4}"))
            throw new ViolacaoRegraNegocioException("A placa possui formato inválido!");
        this.placa = placa.replace("-","");
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) throws ViolacaoRegraNegocioException {
        if(chassi==null || chassi.length()<17)
            throw new ViolacaoRegraNegocioException("O chassi possui formato inválido!"); 
        this.chassi = chassi;
    }

    public EnumTipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoVeiculo tipo) throws ViolacaoRegraNegocioException{
        if(tipo==null)
            throw new ViolacaoRegraNegocioException("É obrigatório que o veículo tenha um tipo!");       
        this.tipo = tipo;
    }

    public long getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) throws ViolacaoRegraNegocioException {
        if(anoFab<1900)
            throw new ViolacaoRegraNegocioException("É obrigatório que o veículo tenha ano de fabricação!");  
        this.anoFab = anoFab;
    }

    public EnumMarcaVeiculo getMarca() {
        return marca;
    }

    public void setMarca(EnumMarcaVeiculo marca) throws ViolacaoRegraNegocioException {
        if(marca==null)
            throw new ViolacaoRegraNegocioException("É obrigatório que o veículo tenha uma marca!");  
        this.marca = marca;
    }

    public EnumCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(EnumCombustivel combustivel) throws ViolacaoRegraNegocioException {
        if(combustivel==null)
            throw new ViolacaoRegraNegocioException("É obrigatório que o veículo tenha um tipo de combustível!");
        this.combustivel = combustivel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.placa);
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
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.placa, other.placa);
    }

    @Override
    public String toString() {
        return modelo + " - " + placa;
    }
   
}
