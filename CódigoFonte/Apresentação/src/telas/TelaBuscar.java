package telas;
import br.edu.ifnmg.marketmanagement.aplicacao.Entidade;
import br.edu.ifnmg.marketmanagement.aplicacao.Repositorio;
import java.util.List;

/**
 *
 * @author guilherme
 */
public abstract class TelaBuscar<T extends Entidade> extends javax.swing.JInternalFrame {
    
    private T filtro;
    private TelaEditar editar;
    private Repositorio<T> repositorio;
    protected Posicionamento pos = new Posicionamento();

    public T getFiltro() {
        return filtro;
    }

    public void setFiltro(T filtro) {
        this.filtro = filtro;
    }

    public TelaEditar getEditar() {
        return editar;
    }

    public void setEditar(TelaEditar editar) {
        this.editar = editar;
    }
    
    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    protected abstract void preencherTabela(List<T> dados);
    protected abstract T carregaFiltro();
    protected abstract T novaEntidade();
    
    protected void novo() {
        editar.setEntidade(novaEntidade());
        editar.setBuscar(this);
        this.getParent().add(editar);
        editar.pos.setTamanho(editar);
        editar.setVisible(true);
        this.setVisible(false);
    }
    
    protected void buscar() {
        filtro = carregaFiltro();

        List<T> resultado = (List<T>) getRepositorio().buscar(filtro);

        preencherTabela(resultado);
            
    }
    
    protected void editar(long id) {
        T obj = getRepositorio().abrir(id);         
        this.getParent().add(editar);
        editar.setVisible(true);
        this.setVisible(false);
        pos.setTamanho(editar);
        editar.setEntidade(obj);
        
        editar.setBuscar(this);
    }
    
}