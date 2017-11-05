/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Collection;

/**
 *
 * @author aluno
 * @param <T>
 */
public interface Repositorio<T>{
    public boolean salvar(T obj);
    public boolean apagar(T obj);
    public T abrir(long id);
    public Collection<T> buscar(T filtro);
       
}
