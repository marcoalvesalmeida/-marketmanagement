/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumModoPagamento;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumPlanejamento;
import br.edu.ifnmg.marketmanagement.aplicacao.LancamentoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Lancamento;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class LancamentoDAO extends DAOGenerico<Lancamento> implements LancamentoRepositorio {

    ClienteRepositorio clientes = RepositorioBuilder.getClienteRepositorio();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected String consultaAbrir() {
        return "select * from lancamento where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into lancamento(data_lancamento, tipolancamento, valor, acrescimo, desconto, valortotal, cliente, planejamento, formaPagamento) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update lancamento set data_lancamento = ?, tipolancamento = ?, valor = ?,  acrescimo = ?, desconto = ?,  valorTotal = ?, cliente = ?,  planejamento = ?, formaPagamento = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from lancamento where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from lancamento";
    }

    @Override
    protected Lancamento carregaObjeto(ResultSet dados) {
        try {
            Lancamento obj = new Lancamento();
            obj.setId(dados.getLong("id"));
            obj.setData(new java.util.Date(dados.getDate("data_lancamento").getTime()));
            obj.setTipo(dados.getString("tipolancamento"));
            obj.setValor(dados.getBigDecimal("valor"));
            obj.setValorTotal(dados.getBigDecimal("valortotal"));
            obj.setModo(EnumModoPagamento.valueOf(dados.getString("formapagamento")));
            obj.setAcrescimo(dados.getBigDecimal("acrescimo"));
            obj.setDesconto(dados.getBigDecimal("desconto"));
            obj.setCliente(clientes.abrir(dados.getLong("cliente")));
            obj.setPlanejamento(EnumPlanejamento.valueOf(dados.getString("planejamento")));
            return obj;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void carregaParametros(Lancamento obj, PreparedStatement consulta) {
        try {
            if (obj.getId() > 0)
                consulta.setLong(10, obj.getId());
            consulta.setDate(1, new Date(obj.getData().getTime()));
            consulta.setString(2, obj.getTipo());
            consulta.setBigDecimal(3, obj.getValor());
            consulta.setBigDecimal(4, obj.getAcrescimo());
            consulta.setBigDecimal(5, obj.getDesconto());
            consulta.setBigDecimal(6, obj.getValorTotal());
            consulta.setLong(7, obj.getCliente().getId());
            consulta.setString(8, obj.getPlanejamento().toString());
            consulta.setString(9, obj.getModo().toString());
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    protected String carregaParametrosBusca(Lancamento obj) {
        String sql = "";

        if (obj.getDataInicial() != null) {
            sql = this.filtrarPor(sql, "data_lancamento >", df.format(obj.getDataInicial()));
        }
        
        if (obj.getDataFinal() != null) {
            sql = this.filtrarPor(sql, "data_lancamento <", df.format(obj.getDataFinal()));
        }
        
        if(obj.getTipo()!=null && !obj.getTipo().isEmpty()){
            sql = this.filtrarPor(sql, "tipolancamento", obj.getTipo());
        }
        
        if(obj.getPlanejamento()!=null){
            sql = this.filtrarPor(sql, "planejamento", obj.getPlanejamento().toString());
        }
        return sql;
    }

}
