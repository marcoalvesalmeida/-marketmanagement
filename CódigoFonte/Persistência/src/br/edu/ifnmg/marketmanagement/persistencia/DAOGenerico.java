/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import br.edu.ifnmg.marketmanagement.aplicacao.Entidade;
import br.edu.ifnmg.marketmanagement.aplicacao.Repositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {

    protected Connection conexao;

    protected abstract String consultaAbrir();

    protected abstract String consultaInsert();

    protected abstract String consultaUpdate();

    protected abstract String consultaDelete();

    protected abstract String consultaBuscar();

    protected abstract String carregaParametrosBusca(T obj);

    protected abstract void carregaParametros(T obj, PreparedStatement consulta);

    protected abstract T carregaObjeto(ResultSet dados);
    

    @Override
    public boolean salvar(T obj) {
        try {
            String sql = "";
            //Verifica se o objeto já está salvo no banco
            if (obj.getId() == 0)
                sql = this.consultaInsert();
            else
                sql = this.consultaUpdate();
          
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            this.carregaParametros(obj, consulta);
            return consulta.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public T abrir(long id) {
        try {
            String sql = this.consultaAbrir();
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            consulta.setLong(1, id);
            ResultSet dados = consulta.executeQuery();
            if (dados.next()) {
                return this.carregaObjeto(dados);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected String filtrarPor(String sql, String campo, String valor) {
        if (valor != null && valor.length() > 0) {

            if (sql.length() > 0) {
                sql = sql + " and ";
            }

            sql = sql + campo + "= '" + valor + "'";
        }
        return sql;

    }

    @Override
    public boolean apagar(T obj) {
        try {
            // Pega a consulta para excluir (delete)
            String sql = this.consultaDelete();

            // Utilizando a conexão aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);

            // Coloca o parâmetro da consulta (id)
            consulta.setLong(1, obj.getId());

            // Executa a consulta
            return consulta.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public List<T> buscar(T filtro) {
        // Cria a lista que conterá o resultado da busca
        List<T> resultado = new ArrayList<>();

        try {

            // Pega a consulta select da busca
            String sql = this.consultaBuscar();

            // Acrescenta os filtros where da busca
            String where = "";
            if (filtro != null) {
                where = this.carregaParametrosBusca(filtro);
            }

            if (!where.isEmpty()) {
                sql += " where " + where;
            }

            // Utilizando a conexão aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);

            // Executa a consulta select e recebe os dados de retorno
            ResultSet dados = consulta.executeQuery();

            // Enquanto houverem registros
            while (dados.next()) {

                // Converte os dados dos registros em objetos
                T obj = this.carregaObjeto(dados);

                // Adiciona o objeto na lista de retorno
                resultado.add(obj);
            }
            return resultado;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
