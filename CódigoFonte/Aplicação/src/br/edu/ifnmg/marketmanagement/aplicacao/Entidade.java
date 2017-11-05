package br.edu.ifnmg.marketmanagement.aplicacao;

/**
 *
 * @author marco
 */
public interface Entidade {
    public long getId();
    public void setId(long id) throws ViolacaoRegraNegocioException;
}
