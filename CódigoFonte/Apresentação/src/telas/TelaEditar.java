/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import br.edu.ifnmg.marketmanagement.aplicacao.Entidade;
import br.edu.ifnmg.marketmanagement.aplicacao.Repositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 * @param <T>
 */
public abstract class TelaEditar<T extends Entidade> extends javax.swing.JInternalFrame{
    
    protected Posicionamento pos = new Posicionamento();
    
    private TelaBuscar buscar;
    
    protected T entidade;
    
    private Repositorio<T> repositorio;

    public TelaBuscar getBuscar() {
        return buscar;
    }

    public void setBuscar(TelaBuscar buscar) {
        this.buscar = buscar;
    }

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
        
        carregaCampos();
    }

    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    protected abstract void carregaObjeto() throws ViolacaoRegraNegocioException;
    
    protected abstract void carregaCampos();
    
    protected void voltar(){
        this.getBuscar().setVisible(true);
        this.getBuscar().pos.setTamanho(this.getBuscar());
        this.setVisible(false);
    }
    
    protected void salvar() {
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente salvar o registro?","Atenção",
                JOptionPane.YES_NO_OPTION) == 0) {
            
            try {
                carregaObjeto();
                
                if(getRepositorio().salvar(entidade))            
                    JOptionPane.showMessageDialog(rootPane, "Registro salvo com sucesso!");
                else
                    JOptionPane.showMessageDialog(rootPane, "Houve um erro ao salvar o resgistro!");
            } catch (ViolacaoRegraNegocioException ex) {
                
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                
            }
        }
    }
    
    protected void apagar() {                                          
        if(entidade.getId() == 0){
            JOptionPane.showMessageDialog(rootPane, "Os dados ainda não estão salvos");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this, "Você deseja realmente remover o registro?","Atenção",
                JOptionPane.YES_NO_OPTION) == 0) {
            
            if(getRepositorio().apagar(entidade))  {          
                JOptionPane.showMessageDialog(rootPane, "Dados removidos com sucesso!");
                this.setVisible(false);
                this.getBuscar().setVisible(true);
            } else
                JOptionPane.showMessageDialog(rootPane, "Falha ao remover os dados!");
        } 
    }    
}