package telas;

import br.edu.ifnmg.marketmanagement.aplicacao.Fornecedor;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class TelaFornecedores extends javax.swing.JInternalFrame{
    /**
     * Creates new form TelaFornecedoresd
     */
    public TelaFornecedores() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdNome = new javax.swing.JRadioButton();
        rdCnpj = new javax.swing.JRadioButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();

        setClosable(true);
        setTitle("Pesquisar Fornecedores");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(160, 160, 160)));

        txtBusca.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEditar.setText("Editar");

        btnNovo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNovo.setText("Novo");

        btnRelatorio.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRelatorio.setText("Relatório");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar cadastro já existente por Nome:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modos de Pesquisa"));

        rdNome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rdNome.setText("Nome");

        rdCnpj.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rdCnpj.setText("CNPJ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdNome)
                .addGap(85, 85, 85))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdCnpj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rdNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdCnpj)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btnPesquisar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBusca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        tbResultado.setBorder(null);
        tbResultado.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbResultado.setGridColor(new java.awt.Color(254, 254, 254));
        tbResultado.setRowMargin(0);
        jScrollPane1.setViewportView(tbResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            FornecedorRepositorio fornecedores = RepositorioBuilder.getFornecedorRepositorio();          
            Fornecedor filtro = new Fornecedor();            
            if(!txtBusca.getText().isEmpty())
                filtro.setRazaoSocial(txtBusca.getText());                       
            List<Fornecedor> resultado = (List<Fornecedor>) fornecedores.buscar(filtro);            
            DefaultTableModel modelo = new DefaultTableModel();            
            modelo.addColumn("ID");
            modelo.addColumn("RAZAO SOCIAL");
            modelo.addColumn("CNPJ");      
            modelo.addColumn("TELEFONE");
            modelo.addColumn("EMAIL");           
            for(Fornecedor c : resultado){
                Vector valores = new Vector();
                valores.add(c.getId());
                valores.add(c.getRazaoSocial());
                valores.add(c.getCnpj());
                valores.add(c.getTelefone());              
                valores.add(c.getEmail());                
                modelo.addRow(valores);
            }            
            tbResultado.setModel(modelo);            
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCnpj;
    private javax.swing.JRadioButton rdNome;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
