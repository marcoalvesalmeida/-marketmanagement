package telas;
import br.edu.ifnmg.marketmanagement.aplicacao.Categoria;
import br.edu.ifnmg.marketmanagement.aplicacao.CategoriaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import br.edu.ifnmg.marketmanagement.persistencia.CategoriaDAO;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class TelaCategoria extends TelaBuscar<Categoria> {

    /**
     * Creates new form TelaCategorias
     */
    public TelaCategoria() {
        initComponents();
        setRepositorio(RepositorioBuilder.getCategoriaRepositorio());
        carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescricao = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Edição de Categorias");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 201, 201)));
        jPanel1.setForeground(new java.awt.Color(1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Descrição da Categoria:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbDescricao.setBackground(new java.awt.Color(254, 254, 254));
        tbDescricao.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        tbDescricao.setForeground(new java.awt.Color(5, 5, 5));
        tbDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDescricao.setToolTipText("Categorias Cadastradas");
        tbDescricao.setFocusable(false);
        tbDescricao.setGridColor(new java.awt.Color(254, 254, 254));
        tbDescricao.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tbDescricao);
        tbDescricao.getAccessibleContext().setAccessibleName("");

        btnSalvar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        CategoriaRepositorio cat = new CategoriaDAO();
        Categoria c = new Categoria();
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente salvar os dados?", "Confirmação",
                JOptionPane.YES_NO_OPTION) == 0) {
            if (txtCategoria.getText().length() > 3 && !txtCategoria.getText().isEmpty()) {
                try {
                    c.setDescricao(txtCategoria.getText());
                    if (cat.salvar(c)) {
                        txtCategoria.setText("");
                        carregaTabela();
                    }
                } catch (ViolacaoRegraNegocioException ex) {
                    Logger.getLogger(TelaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "A descrição deve ter no mínimo 4 caracteres!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int linha = tbDescricao.getSelectedRow();
        long id = Long.parseLong(tbDescricao.getValueAt(linha, 0).toString());
        String descricao = tbDescricao.getValueAt(linha, 1).toString();
        CategoriaRepositorio cat = new CategoriaDAO();
        Categoria nova = new Categoria();
        nova.setId(id);
        try {
            nova.setDescricao(descricao);
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(TelaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente apagar ?", "Aviso", JOptionPane.ERROR_MESSAGE) == 0) {
            if (cat.apagar(nova)) {
                JOptionPane.showMessageDialog(null, "Registro apagado com sucesso!");
                carregaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Essa categoria esta vinculada com outro produto! Apague primeiro o produto.");
                return;
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDescricao;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void preencherTabela(List<Categoria> dados) {
    }

    private void carregaTabela() {
        CategoriaRepositorio clientes = new CategoriaDAO();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIÇÃO");
        List<Categoria> resultado = (List<Categoria>) clientes.buscar(carregaFiltro());
        int linha = 0;
        for (Categoria c : resultado) {
            Vector valores = new Vector();
            valores.add(c.getId());
            valores.add(c.getDescricao());
            modelo.addRow(valores);
        }
        tbDescricao.setModel(modelo);
    }

    @Override
    protected Categoria carregaFiltro() {
        Categoria filtro = new Categoria();
        return filtro;
    }

    @Override
    protected Categoria novaEntidade() {
        Categoria categoria = new Categoria();
        return categoria;
    }
}
