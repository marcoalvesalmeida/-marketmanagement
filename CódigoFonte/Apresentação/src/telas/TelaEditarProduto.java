package telas;

import br.edu.ifnmg.marketmanagement.aplicacao.Categoria;
import br.edu.ifnmg.marketmanagement.aplicacao.CategoriaRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.EnumUnidadeMedida;
import br.edu.ifnmg.marketmanagement.aplicacao.Fornecedor;
import br.edu.ifnmg.marketmanagement.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.Produto;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author guilherme
 */
public class TelaEditarProduto extends TelaEditar<Produto> {
    /**
     * Creates new form TelaEditarProdutoss
     */
    public TelaEditarProduto() {
        initComponents();
        groupRadio();
        setRepositorio(RepositorioBuilder.getProdutoRepositorio());
        carregaCombobox();
    }
    FornecedorRepositorio forn = RepositorioBuilder.getFornecedorRepositorio();
    CategoriaRepositorio cat = RepositorioBuilder.getCategoriaRepositorio(); 
     
    private void groupRadio() {
        GrupoFracionar.add(rdFracionarNao);
        GrupoFracionar.add(rdFracionarSim);        
        GrupoAtivo.add(rdAtivoNao);
        GrupoAtivo.add(rdAtivoSim); 
    }

    
    public void carregaCombobox(){
        cbxFornecedor.removeAllItems();
        List<Fornecedor> lista1 = (List<Fornecedor>) forn.buscar(null);
        ComboBoxModel modelo1 = new DefaultComboBoxModel(lista1.toArray());
        cbxFornecedor.setModel(modelo1);   
        
        cbxUnidMedida.setModel(new DefaultComboBoxModel<>(EnumUnidadeMedida.values())); 
        
        cbxCategoria.removeAllItems();
        List<Categoria> lista2 = (List<Categoria>) cat.buscar(null);
        ComboBoxModel modelo2 = new DefaultComboBoxModel(lista2.toArray());
        cbxCategoria.setModel(modelo2);
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoFracionar = new javax.swing.ButtonGroup();
        GrupoAtivo = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtValorCusto = new javax.swing.JTextField();
        txtValorVarejo = new javax.swing.JTextField();
        txtValorAtacado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rdFracionarSim = new javax.swing.JRadioButton();
        rdFracionarNao = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPontuacao = new javax.swing.JTextField();
        txtInfoAdicionais = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxUnidMedida = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        txtEstqminimo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEstqAtual = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        rdAtivoSim = new javax.swing.JRadioButton();
        rdAtivoNao = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        cbxCategoria = new javax.swing.JComboBox();
        btnDeletar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Editar Produtos");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 185, 185)));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Descrição do Produto:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Valor de Custo:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Valor de Varejo:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Valor de Atacado:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Categoria do Produto:");

        btnNovo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNovo.setText("Nova");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170)), "Informações Extras"));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Código ou Código de Barras:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(181, 181, 181)), "Aceita Fracionar:"));

        rdFracionarSim.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdFracionarSim.setText("Sim");

        rdFracionarNao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdFracionarNao.setText("Não");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(rdFracionarSim)
                .addGap(32, 32, 32)
                .addComponent(rdFracionarNao)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdFracionarSim)
                    .addComponent(rdFracionarNao))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Unid. de Medida:");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("Pontuação:");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("Informações Adicionais:");

        cbxUnidMedida.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbxUnidMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtInfoAdicionais, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigoProduto))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxUnidMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPontuacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxUnidMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInfoAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(198, 196, 196)), "Informações de Estoque:"));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel10.setText("Estoque Mínimo:");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel12.setText("Estoque Atual:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(198, 196, 196)), "Ativo:"));

        rdAtivoSim.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdAtivoSim.setText("Sim");

        rdAtivoNao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdAtivoNao.setText("Não");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdAtivoSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(rdAtivoNao)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAtivoSim)
                    .addComponent(rdAtivoNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstqminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstqAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstqAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstqminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSalvar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnSair.setText("Voltar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        cbxCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDeletar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtValorAtacado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorAtacado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Informações Básicas", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setText("Selecione o Fornecedor:");

        cbxFornecedor.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 492, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fornecedor", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFornecedorActionPerformed

    }//GEN-LAST:event_cbxFornecedorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        apagar();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        voltar();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoAtivo;
    private javax.swing.ButtonGroup GrupoFracionar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxCategoria;
    private javax.swing.JComboBox<String> cbxFornecedor;
    private javax.swing.JComboBox cbxUnidMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdAtivoNao;
    private javax.swing.JRadioButton rdAtivoSim;
    private javax.swing.JRadioButton rdFracionarNao;
    private javax.swing.JRadioButton rdFracionarSim;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstqAtual;
    private javax.swing.JTextField txtEstqminimo;
    private javax.swing.JTextField txtInfoAdicionais;
    private javax.swing.JTextField txtPontuacao;
    private javax.swing.JTextField txtValorAtacado;
    private javax.swing.JTextField txtValorCusto;
    private javax.swing.JTextField txtValorVarejo;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void carregaObjeto() throws ViolacaoRegraNegocioException {
        entidade.setDescricao(txtDescricao.getText());
        entidade.setValorCusto(new BigDecimal(txtValorCusto.getText()));
        entidade.setValorVarejo(new BigDecimal(txtValorVarejo.getText()));
        entidade.setValorAtacado(new BigDecimal(txtValorAtacado.getText()));
        Categoria nova = new Categoria();
        nova = (Categoria) cbxCategoria.getSelectedItem();
        System.out.println(nova.getDescricao()+nova.getId());
        entidade.setCategoria(nova);
        entidade.setCodigo(Integer.parseInt(txtCodigoProduto.getText()));
        entidade.setUnMedida((EnumUnidadeMedida) cbxUnidMedida.getSelectedItem());
        entidade.setPontuacao(Integer.parseInt(txtPontuacao.getText()));
        if (rdFracionarSim.isSelected())
            entidade.setFracionar(true);
        else
            entidade.setFracionar(false);
        entidade.setInformacoesAdicionais(txtInfoAdicionais.getText());
        entidade.setEstoqueMinimo(Long.parseLong(txtEstqminimo.getText()));
        entidade.setEstoqueAtual(Long.parseLong(txtEstqAtual.getText()));
        if (rdAtivoSim.isSelected())
            entidade.setAtivo(true);
        else 
            entidade.setAtivo(false);
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = (Fornecedor) cbxFornecedor.getSelectedItem();
        entidade.setFornecedor(fornecedor);
    }

    @Override
    protected void carregaCampos() {
        txtDescricao.setText(entidade.getDescricao());
        txtValorCusto.setText(String.valueOf(entidade.getValorCusto()));
        txtValorVarejo.setText(String.valueOf(entidade.getValorVarejo()));
        txtValorAtacado.setText(String.valueOf(entidade.getValorAtacado()));
        cbxCategoria.setSelectedItem(entidade.getCategoria());
        txtCodigoProduto.setText(String.valueOf(entidade.getCodigo()));
        
        
        cbxUnidMedida.setSelectedItem(entidade.getUnMedida());
        
        System.out.println(entidade.getUnMedida());
        
        txtPontuacao.setText(String.valueOf(entidade.getPontuacao()));
        if (entidade.isFracionar())
            rdFracionarSim.setSelected(true);
        else
            rdFracionarNao.setSelected(true);
        txtInfoAdicionais.setText(entidade.getInformacoesAdicionais());
        txtEstqAtual.setText(String.valueOf(entidade.getEstoqueAtual()));
        txtEstqminimo.setText(String.valueOf(entidade.getEstoqueMinimo()));
        if (entidade.isAtivo())
            rdAtivoSim.setSelected(true);
        else
            rdAtivoNao.setSelected(true);  
        cbxFornecedor.setSelectedItem(entidade.getFornecedor());
    }
}
