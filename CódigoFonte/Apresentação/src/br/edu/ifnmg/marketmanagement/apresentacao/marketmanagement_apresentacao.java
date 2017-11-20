/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.apresentacao;

import br.edu.ifnmg.marketmanagement.aplicacao.Endereco;
import br.edu.ifnmg.marketmanagement.aplicacao.Entrega;
import br.edu.ifnmg.marketmanagement.aplicacao.EntregaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumCombustivel;
import telas.TelaEditarVeiculos;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumMarcaVeiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumTipoVeiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.Funcionario;
import br.edu.ifnmg.marketmanagement.aplicacao.Veiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.VeiculoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Venda;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import br.edu.ifnmg.marketmanagement.persistencia.EntregaDAO;
import br.edu.ifnmg.marketmanagement.persistencia.VeiculoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class marketmanagement_apresentacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ViolacaoRegraNegocioException {
        /* VeiculoRepositorio veiculos = new VeiculoDAO() {};
        Veiculo x = new Veiculo();
        EnumCombustivel comb = EnumCombustivel.FLEX;
        EnumMarcaVeiculo marca = EnumMarcaVeiculo.FIAT;
        EnumTipoVeiculo tipo = EnumTipoVeiculo.PASSEIO;
        x.setId(1);
        x.setModelo("UNO");
        x.setPlaca("JIY-9337");
        x.setAnoFab(1970);
        x.setCombustivel(comb);
        x.setChassi("19191919191919191");
        x.setMarca(marca);
        x.setTipo(tipo);
        x.setObservacoes("Esse carro deve ser revisado no sábado 19");
        //boolean salvar = veiculos.salvar(x);
        EntregaRepositorio entregas = new EntregaDAO() {};
        Entrega z = new Entrega();
        Venda v = new Venda();
        Funcionario f = new Funcionario();
        Endereco e = new Endereco();
        v.setId(1);
        z.setVenda(v);
        z.setMotorista(f);
        z.setVeiculo(x);
        z.setEndereco(e);
        //boolean salvar = entregas.salvar(z);*/
        VeiculoRepositorio veiculos = new VeiculoDAO() {
        };
        Veiculo veic = new Veiculo();
        //veic = veiculos.abrir(1);
        //System.out.println(veic.getModelo());
        Veiculo filtro;
        filtro = new Veiculo();
        
        List<Veiculo> resultado = (List<Veiculo>) veiculos.buscar(filtro);
        
        for(Veiculo c : resultado){   
            System.out.println(c.getModelo());
            if(c.getId()==3)
                veiculos.apagar(c);                
        }
    }
}
