/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.Veiculo;
import br.edu.ifnmg.marketmanagement.aplicacao.VeiculoRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author marco
 */
public class TelaVeiculo extends javax.swing.JInternalFrame{
    protected Posicionamento pos = new Posicionamento();
    private MaskFormatter maskPlaca;
    private MaskFormatter maskAno;
    private MaskFormatter maskModelo;
    private MaskFormatter maskMarca;
    /**
     * Creates new form TelaVeiculoInternal
     */
    public TelaVeiculo() throws ParseException {
        initComponents();
        groupRadio();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        lblPesquisa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdPlaca = new javax.swing.JRadioButton();
        rdModelo = new javax.swing.JRadioButton();
        rdMarca = new javax.swing.JRadioButton();
        rdAno = new javax.swing.JRadioButton();
        rdTodos = new javax.swing.JRadioButton();
        txtPesquisa = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(160, 160, 160)));

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnRelatorio.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        lblPesquisa.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblPesquisa.setText("Pesquisar Veiculo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 191, 191)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(131, 128, 128)), "Modos de Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(4, 2, 2))); // NOI18N

        rdPlaca.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdPlaca.setText("Placa");

        rdModelo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdModelo.setText("Modelo");

        rdMarca.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdMarca.setText("Marca");

        rdAno.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdAno.setText("Ano");

        rdTodos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdTodos.setText("Todos");

         // cria as mascaras e já a deixa pronta pra uso
        try {
            maskPlaca = new MaskFormatter("UUU-####");
            maskAno = new MaskFormatter("####");
            maskMarca = new MaskFormatter("***********************");
            maskModelo = new MaskFormatter("**********************");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // adiciona um listener aos radiobuttons
        rdPlaca.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskPlaca));
                }
            }
        });

        rdAno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskAno));
                }
            }
        });
        
        rdMarca.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskMarca));
                }
            }
        });

        rdModelo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskModelo));
                }
            }
        });

        rdTodos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(false);
                    txtPesquisa.setValue(null);
                }
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdPlaca)
                            .addComponent(rdModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdMarca)
                            .addComponent(rdAno)))
                    .addComponent(rdTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdMarca)
                    .addComponent(rdPlaca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAno)
                    .addComponent(rdModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdTodos)
                .addContainerGap())
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPesquisa)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPesquisa)
                        .addGap(4, 4, 4)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabResultado.setBorder(null);
        tabResultado.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        tabResultado.setGridColor(new java.awt.Color(254, 254, 254));
        tabResultado.setRowMargin(0);
        jScrollPane1.setViewportView(tabResultado);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupRadio(){
        rdGrupo.add(rdPlaca);
        rdGrupo.add(rdAno);
        rdGrupo.add(rdModelo);
        rdGrupo.add(rdMarca);
        rdGrupo.add(rdTodos);
        rdTodos.setSelected(true);
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        TelaEditarVeiculo nova = new TelaEditarVeiculo();
        this.getParent().add(nova);
        nova.setVisible(true);
        nova.pos.setTamanho(nova);
        nova.setTelaVeiculo(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            VeiculoRepositorio veiculos = RepositorioBuilder.getVeiculoRepositorio();
            
            Veiculo filtro = new Veiculo();
            
            if(!txtPesquisa.getText().isEmpty() && txtPesquisa!=null && !rdTodos.isSelected()){
                if(rdPlaca.isSelected())
                    filtro.setPlaca(txtPesquisa.getText());
                else if(rdAno.isSelected())
                    filtro.setAnoFab(Integer.parseInt(txtPesquisa.getText()));
                //else if(rdMarca.isSelected())
                    //filtro.setMarca(txtPesquisa.getText());
                else if(rdModelo.isSelected())
                    filtro.setModelo(txtPesquisa.getText());  
            }
           
            List<Veiculo> resultado = (List<Veiculo>) veiculos.buscar(filtro);
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("ID");
            modelo.addColumn("Placa");
            modelo.addColumn("Modelo");
            modelo.addColumn("Marca");
            modelo.addColumn("Tipo");
            modelo.addColumn("Chassi");
            modelo.addColumn("AnoFab");
            modelo.addColumn("Combustivel");
            modelo.addColumn("Observações");
            
            for(Veiculo v : resultado){
                Vector valores = new Vector();
                valores.add(v.getId());
                valores.add(v.getPlaca());
                valores.add(v.getModelo());   
                valores.add(v.getMarca());
                valores.add(v.getTipo());
                valores.add(v.getChassi());
                valores.add(v.getAnoFab());
                valores.add(v.getCombustivel());
                valores.add(v.getObservacoes());
                modelo.addRow(valores);
            }
            
            tabResultado.setModel(modelo);
            
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(TelaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        int linha = tabResultado.getSelectedRow();
        if(linha<0){
            JOptionPane.showMessageDialog(this, "Um veículo deve estar selecionado!");
            return;
        }
        long id = Long.parseLong(tabResultado.getValueAt(linha, 0).toString());
        
        VeiculoRepositorio veiculo = RepositorioBuilder.getVeiculoRepositorio();
        
        Veiculo obj = veiculo.abrir(id);
        
        TelaEditarVeiculo nova = new TelaEditarVeiculo();
        this.getParent().add(nova);
        nova.setVisible(true);
        this.setVisible(false); 
        nova.pos.setTamanho(nova);
        nova.setEntidade(obj);        
        nova.setTelaVeiculo(this);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        int linha = tabResultado.getSelectedRow();
        if(linha<0){
            JOptionPane.showMessageDialog(this, "Um veículo deve estar selecionado!");
            return;
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JRadioButton rdAno;
    private javax.swing.ButtonGroup rdGrupo;
    private javax.swing.JRadioButton rdMarca;
    private javax.swing.JRadioButton rdModelo;
    private javax.swing.JRadioButton rdPlaca;
    private javax.swing.JRadioButton rdTodos;
    private javax.swing.JTable tabResultado;
    private javax.swing.JFormattedTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

}
