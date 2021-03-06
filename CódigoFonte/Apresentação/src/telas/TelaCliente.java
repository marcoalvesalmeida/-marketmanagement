package telas;
import br.edu.ifnmg.marketmanagement.aplicacao.Cliente;
import br.edu.ifnmg.marketmanagement.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.marketmanagement.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.marketmanagement.aplicacao.ViolacaoRegraNegocioException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author guilherme
 */
public class TelaCliente extends TelaBuscar<Cliente>  {
    /**
     * Creates new form TelaCliente
     */
    
    //protected Posicionamento pos = new Posicionamento();
    private MaskFormatter maskNome;
    private MaskFormatter maskCpf;
    private MaskFormatter maskTodos;


    
    public TelaCliente() {
        initComponents();
        groupRadio();
        setEditar(new TelaEditarCliente());
        setRepositorio(RepositorioBuilder.getClienteRepositorio());      
        
    }
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dfy = new SimpleDateFormat("dd_MM_yyyy");
    DateFormat hf = new SimpleDateFormat("hh:mm:ss");
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblPesquisa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdNome = new javax.swing.JRadioButton();
        rdCpf = new javax.swing.JRadioButton();
        rdTodos = new javax.swing.JRadioButton();
        btnRelatorio = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Cliente");

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

        btnPesquisar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblPesquisa.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblPesquisa.setText("Pesquisar cadastro já existente:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 154, 154)), "Modos de Pesquisa"));

        rdNome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rdNome.setText("Nome");
        rdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNomeActionPerformed(evt);
            }
        });

        rdCpf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rdCpf.setText("CPF");
        rdCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCpfActionPerformed(evt);
            }
        });

        rdTodos.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rdTodos.setText("Todos");
        rdTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTodosActionPerformed(evt);
            }
        });
        
         try {          
            maskCpf = new MaskFormatter("###.###.###-##"); 
            maskNome = new MaskFormatter("******************************************");
            maskTodos = new MaskFormatter("******************************************");      
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
                // adiciona um listener aos radiobuttons
        rdTodos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskTodos));
                }
            }
        });
        
                // adiciona um listener aos radiobuttons
        rdCpf.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
                }
            }
        });
        
                // adiciona um listener aos radiobuttons
        rdNome.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskNome));
                }
            }
        });
        
        if (rdCpf.isSelected() == true)        
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
		if (rdTodos.isSelected() == true)
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskTodos));
		if (rdNome.isSelected() == true)
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskNome));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdTodos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdCpf)
                            .addComponent(rdNome))
                        .addGap(20, 65, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdNome)
                .addGap(8, 8, 8)
                .addComponent(rdCpf)
                .addContainerGap())
        );

        btnRelatorio.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
        
          try {          
            maskCpf = new MaskFormatter("###.###.###-##"); 
            maskNome = new MaskFormatter("******************************************");
            maskTodos = new MaskFormatter("******************************************");      
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
                // adiciona um listener aos radiobuttons
        rdTodos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskTodos));
                }
            }
        });
        
                // adiciona um listener aos radiobuttons
        rdCpf.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
                }
            }
        });
        
                // adiciona um listener aos radiobuttons
        rdNome.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPesquisa.setEnabled(true);
                    txtPesquisa.setValue(null);
                    txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskNome));
                }
            }
        });
        
        if (rdCpf.isSelected() == true)        
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
		if (rdTodos.isSelected() == true)
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskTodos));
		if (rdNome.isSelected() == true)
			txtPesquisa.setFormatterFactory(new DefaultFormatterFactory(maskNome));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPesquisa)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tbClientes.setBorder(null);
        tbClientes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbClientes.setGridColor(new java.awt.Color(254, 254, 254));
        tbClientes.setRowMargin(0);
        jScrollPane1.setViewportView(tbClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupRadio() {
        buttonGroup1.add(rdNome);
        buttonGroup1.add(rdCpf);
        buttonGroup1.add(rdTodos);
        rdTodos.setSelected(true);
        txtPesquisa.setEnabled(false);
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
      buscar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tbClientes.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar um cliente!");
            return;
        }
        long id = Long.parseLong(tbClientes.getValueAt(linha, 0).toString());
        editar(id);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void rdCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCpfActionPerformed
        lblPesquisa.setText("Pesquisar cadastro já existente por CPF: ");
    }//GEN-LAST:event_rdCpfActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novo();        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void rdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNomeActionPerformed
        lblPesquisa.setText("Pesquisar cadastro já existente por Nome: ");
    }//GEN-LAST:event_rdNomeActionPerformed

    private void rdTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTodosActionPerformed
        lblPesquisa.setText("Pesquisar cadastro já existente: ");
        txtPesquisa.setEnabled(false);
    }//GEN-LAST:event_rdTodosActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
         String hora = hf.format(new Date());
        String titledoc = "Funcionarios_Geral_" + dfy.format(new Date()) +"_"+hora+".pdf";
        int linha = tbClientes.getSelectedRow();
        if (linha < 0) {
            if (JOptionPane.showConfirmDialog(this, "Você deseja realmente realizar o relatório de todos os funcioários?", "Atenção",
                    JOptionPane.YES_NO_OPTION) == 0) {
                Document doc = new Document();
                try {
                    ClienteRepositorio funcionarios = RepositorioBuilder.getClienteRepositorio();
                    List<Cliente> dados = (ArrayList) funcionarios.buscar(null);
                    PdfWriter.getInstance(doc, new FileOutputStream(titledoc));
                    doc.open();
                    PdfPTable table = new PdfPTable(1);
                    Paragraph titulo = new Paragraph("RELATÓRIO GERAL DE CLIENTES ", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                    titulo.setIndentationLeft(60);
                    PdfPCell tituloCell = new PdfPCell(titulo);
                    table.addCell(tituloCell);
                    for (Cliente f : dados) {
                        Paragraph nome = new Paragraph("Nome: " + f.getNome(),new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                        nome.setIndentationLeft(20);
                        PdfPCell nomeCell = new PdfPCell();
                        nomeCell.addElement(nome);
                        table.addCell(nomeCell);
                        Paragraph cpf = new Paragraph("CPF: " + f.getCpf());
                        cpf.setIndentationLeft(20);
                        PdfPCell cpfCell = new PdfPCell();
                        cpfCell.addElement(cpf);
                        table.addCell(cpfCell);
                        Paragraph rg = new Paragraph("RG: " + f.getRg());
                        rg.setIndentationLeft(20);
                        PdfPCell rgCell = new PdfPCell();
                        rgCell.addElement(rg);
                        table.addCell(rgCell);
                        Paragraph nasc = new Paragraph("NASCIMENTO: " + df.format(f.getDataNascimento()));
                        nasc.setIndentationLeft(20);
                        PdfPCell nascCell = new PdfPCell();
                        nascCell.addElement(nasc);
                        table.addCell(nascCell);
                        Paragraph email = new Paragraph("E-MAIL: " +  f.getEmail());
                        email.setIndentationLeft(20);
                        PdfPCell emailCell = new PdfPCell();
                        emailCell.addElement(email);
                        table.addCell(emailCell);
                        Paragraph end = new Paragraph("ENDEREÇO: " + "Rua " +   f.getEndereco().getRua() + " " + f.getEndereco().getCidade() + "-"+ f.getEndereco().getUf() + " " + f.getEndereco().getCep());
                        end.setIndentationLeft(20);
                        PdfPCell endCell = new PdfPCell();
                        endCell.addElement(end);
                        table.addCell(endCell);
                        Paragraph tel1 = new Paragraph("TELEFONE: " + f.getTelefone());
                        tel1.setIndentationLeft(20);
                        PdfPCell tel1Cell = new PdfPCell();
                        tel1Cell.addElement(tel1);
                        table.addCell(tel1Cell);
                        Paragraph tel2 = new Paragraph("CELULAR: " + f.getCelular());
                        tel2.setIndentationLeft(20);
                        PdfPCell tel2Cell = new PdfPCell();
                        tel2Cell.addElement(tel2);
                        table.addCell(tel2Cell);  
                         Paragraph in1 = new Paragraph("DESCONTOS: " + f.getDescontos());
                        in1.setIndentationLeft(20);
                        PdfPCell in1Cell = new PdfPCell();
                        in1Cell.addElement(in1);
                        table.addCell(in1Cell); 
                         Paragraph in2 = new Paragraph("SALDO COMPRA: " + f.getSaldoCompras());
                        in2.setIndentationLeft(20);
                        PdfPCell in2Cell = new PdfPCell();
                        in2Cell.addElement(in2);
                        table.addCell(in2Cell);                    
                        Paragraph in = new Paragraph("INFORMAÇÕES ADICIONAIS: " + f.getInformacoesAdicionais());
                        in.setIndentationLeft(20);
                        PdfPCell inCell = new PdfPCell();
                        inCell.addElement(in);
                        table.addCell(inCell);   
                    }
                    doc.add(table);
                    Paragraph rodape = new Paragraph("Relatório gerado em " + df.format(new Date()) + " às " + hora);
                    rodape.setSpacingBefore(30f);
                    rodape.setIndentationLeft(130f);
                    doc.add(rodape);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    doc.close();
                }

                try {
                    Desktop.getDesktop().open(new File(titledoc));
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Relatório gerado com sucesso!");
            }
        }else{
            long id = Long.parseLong(tbClientes.getValueAt(linha, 0).toString());
            Cliente f = new Cliente();
            ClienteRepositorio v = RepositorioBuilder.getClienteRepositorio();
            f = v.abrir(id);
            Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("relatorioclientes.pdf"));
            doc.open();
             PdfPTable table = new PdfPTable(1);
        Paragraph titulo = new Paragraph("RELATÓRIO GERAL DE CLIENTES ",new Font(FontFamily.HELVETICA, 12, Font.BOLD));
        titulo.setIndentationLeft(60);
        PdfPCell tituloCell = new PdfPCell(titulo);
        table.addCell(tituloCell);
   
         Paragraph nome = new Paragraph("Nome: " + f.getNome(),new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                        nome.setIndentationLeft(20);
                        PdfPCell nomeCell = new PdfPCell();
                        nomeCell.addElement(nome);
                        table.addCell(nomeCell);
                        Paragraph cpf = new Paragraph("CPF: " + f.getCpf());
                        cpf.setIndentationLeft(20);
                        PdfPCell cpfCell = new PdfPCell();
                        cpfCell.addElement(cpf);
                        table.addCell(cpfCell);
                        Paragraph rg = new Paragraph("RG: " + f.getRg());
                        rg.setIndentationLeft(20);
                        PdfPCell rgCell = new PdfPCell();
                        rgCell.addElement(rg);
                        table.addCell(rgCell);
                        Paragraph nasc = new Paragraph("NASCIMENTO: " + df.format(f.getDataNascimento()));
                        nasc.setIndentationLeft(20);
                        PdfPCell nascCell = new PdfPCell();
                        nascCell.addElement(nasc);
                        table.addCell(nascCell);
                        Paragraph email = new Paragraph("E-MAIL: " +  f.getEmail());
                        email.setIndentationLeft(20);
                        PdfPCell emailCell = new PdfPCell();
                        emailCell.addElement(email);
                        table.addCell(emailCell);
                        Paragraph end = new Paragraph("ENDEREÇO: " + "Rua " +   f.getEndereco().getRua() + " " + f.getEndereco().getCidade() + "-"+ f.getEndereco().getUf() + " " + f.getEndereco().getCep());
                        end.setIndentationLeft(20);
                        PdfPCell endCell = new PdfPCell();
                        endCell.addElement(end);
                        table.addCell(endCell);
                        Paragraph tel1 = new Paragraph("TELEFONE: " + f.getTelefone());
                        tel1.setIndentationLeft(20);
                        PdfPCell tel1Cell = new PdfPCell();
                        tel1Cell.addElement(tel1);
                        table.addCell(tel1Cell);
                        Paragraph tel2 = new Paragraph("CELULAR: " + f.getCelular());
                        tel2.setIndentationLeft(20);
                        PdfPCell tel2Cell = new PdfPCell();
                        tel2Cell.addElement(tel2);
                        table.addCell(tel2Cell);  
                         Paragraph in1 = new Paragraph("DESCONTOS: " + f.getDescontos());
                        in1.setIndentationLeft(20);
                        PdfPCell in1Cell = new PdfPCell();
                        in1Cell.addElement(in1);
                        table.addCell(in1Cell); 
                         Paragraph in2 = new Paragraph("SALDO COMPRA: " + f.getSaldoCompras());
                        in2.setIndentationLeft(20);
                        PdfPCell in2Cell = new PdfPCell();
                        in2Cell.addElement(in2);
                        table.addCell(in2Cell);                    
                        Paragraph in = new Paragraph("INFORMAÇÕES ADICIONAIS: " + f.getInformacoesAdicionais());
                        in.setIndentationLeft(20);
                        PdfPCell inCell = new PdfPCell();
                        inCell.addElement(in);
                        table.addCell(inCell);   
               doc.add(table);
                    Paragraph rodape = new Paragraph("Relatório gerado em " + df.format(new Date()) + " às " + hora);
                    rodape.setSpacingBefore(30f);
                    rodape.setIndentationLeft(130f);
                    doc.add(rodape);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            doc.close();
        }
        
        try {
            Desktop.getDesktop().open(new File("relatorioclientes.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JRadioButton rdCpf;
    private javax.swing.JRadioButton rdNome;
    private javax.swing.JRadioButton rdTodos;
    private javax.swing.JTable tbClientes;
    private javax.swing.JFormattedTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void preencherTabela(List<Cliente> dados) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
        modelo.addColumn("NASCIMENTO");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("TELEFONE");
        modelo.addColumn("EMAIL");
        for (Cliente c : dados) {
            Vector valores = new Vector();
            valores.add(c.getId());
            valores.add(c.getNome());
            valores.add(df.format(c.getDataNascimento().getTime()));
            valores.add(c.getCpf());
            valores.add(c.getRg());
            valores.add(c.getTelefone());
            valores.add(c.getEmail());
            modelo.addRow(valores);
        }
        tbClientes.setModel(modelo);
    }

    @Override
    protected Cliente carregaFiltro() {
        try{           
            Cliente filtro = new Cliente();
            if(!txtPesquisa.getText().isEmpty()){                
                if (rdNome.isSelected()){
                    filtro.setNome(txtPesquisa.getText());
                }else if(rdCpf.isSelected() && txtPesquisa.getValue() != null){               
                    filtro.setCpf(txtPesquisa.getText()); 
                }else if (rdCpf.isSelected() && txtPesquisa.getValue()==null){
                    filtro.setCpf("111.111.111-11");
                }
                return filtro;
            }
        }catch(ViolacaoRegraNegocioException ex){
           Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return null;   
    }

    @Override
    protected Cliente novaEntidade() {
        return new Cliente();       
    }
}
