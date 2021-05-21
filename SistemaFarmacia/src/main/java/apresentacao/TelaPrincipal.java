package apresentacao;

import br.univates.system32.Formatacao;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Funcionario;
import negocio.Venda;
import persistencia.ProdutoDaoSQL;
import persistencia.VendaDaoSQL;

public class TelaPrincipal extends javax.swing.JFrame {

    private Funcionario funcionario;
    VendaDaoSQL vendaDao;

    public TelaPrincipal(Funcionario funcionario) throws DataBaseException {
        initComponents();
        vendaDao = new VendaDaoSQL();
        this.funcionario = funcionario;

        if (funcionario.getAdmin() == false) {
            menuFunc.setEnabled(false);
            menuCliente.setEnabled(true);
            menuProduto.setEnabled(false);
            menuSetor.setEnabled(false);
            menuFuncao.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenu13 = new javax.swing.JMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        welcome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        addProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        codProdF = new br.univates.system32.components.JMyNumberField();
        jLabel4 = new javax.swing.JLabel();
        quantidadeF = new br.univates.system32.components.JMyNumberField();
        jLabel2 = new javax.swing.JLabel();
        pagamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cpfF = new br.univates.system32.components.JMyCpfField();
        descontoF = new javax.swing.JRadioButton();
        valorDesconto = new br.univates.system32.components.JMyNumberField();
        valorFinal = new br.univates.system32.components.JMyNumberField();
        confirm = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        menuCliente1 = new javax.swing.JMenu();
        menuFunc = new javax.swing.JMenu();
        menuProduto = new javax.swing.JMenu();
        menuSetor = new javax.swing.JMenu();
        menuFuncao = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu13.setText("jMenu13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        welcome.setText("Bem vindo");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        log.setEditable(false);
        log.setColumns(20);
        log.setRows(5);
        jScrollPane1.setViewportView(log);

        addProduto.setText("Adicionar produto");
        addProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdutoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Código produto");

        jLabel4.setText("Quantidade");

        jLabel2.setText("Pagamento");

        pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("CPF");

        cpfF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFActionPerformed(evt);
            }
        });

        descontoF.setText("Desconto");
        descontoF.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                descontoFStateChanged(evt);
            }
        });
        descontoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descontoFActionPerformed(evt);
            }
        });
        descontoF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                descontoFPropertyChange(evt);
            }
        });

        valorDesconto.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descontoF))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpfF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(codProdF, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(quantidadeF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codProdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantidadeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descontoF)
                    .addComponent(valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cpfF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(valorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(valorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        confirm.setText("Fechar compra");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        exit.setText("Sair");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        menuCliente.setText("Cadastro");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });

        menuCliente1.setText("Cliente");
        menuCliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCliente1MouseClicked(evt);
            }
        });
        menuCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliente1ActionPerformed(evt);
            }
        });
        menuCliente.add(menuCliente1);

        menuFunc.setText("Funcionário");
        menuFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFuncMouseClicked(evt);
            }
        });
        menuFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncActionPerformed(evt);
            }
        });
        menuCliente.add(menuFunc);

        menuProduto.setText("Produto");
        menuProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProdutoMouseClicked(evt);
            }
        });
        menuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutoActionPerformed(evt);
            }
        });
        menuCliente.add(menuProduto);

        menuSetor.setText("Setor");
        menuSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSetorMouseClicked(evt);
            }
        });
        menuSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSetorActionPerformed(evt);
            }
        });
        menuCliente.add(menuSetor);

        menuFuncao.setText("Função");
        menuFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFuncaoMouseClicked(evt);
            }
        });
        menuFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncaoActionPerformed(evt);
            }
        });
        menuCliente.add(menuFuncao);

        MenuBar.add(menuCliente);

        jMenu3.setText("Tabelas");

        jMenu8.setText("Funcionário");
        jMenu3.add(jMenu8);

        jMenu14.setText("Cliente");
        jMenu3.add(jMenu14);

        jMenu15.setText("Produto");
        jMenu3.add(jMenu15);

        jMenu16.setText("Setor");
        jMenu3.add(jMenu16);

        jMenu17.setText("Função");
        jMenu3.add(jMenu17);

        MenuBar.add(jMenu3);

        jMenu4.setText("Relatórios");

        jMenu7.setText("jMenu7");
        jMenu4.add(jMenu7);

        MenuBar.add(jMenu4);

        jMenu5.setText("Listagem");

        jMenu6.setText("jMenu6");
        jMenu5.add(jMenu6);

        MenuBar.add(jMenu5);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(welcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirm))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(exit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdutoActionPerformed
        try {
            TabelaProdutos tela = new TabelaProdutos();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_addProdutoActionPerformed

    private void cpfFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFActionPerformed

    }//GEN-LAST:event_cpfFActionPerformed

    private void descontoFStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_descontoFStateChanged

    }//GEN-LAST:event_descontoFStateChanged

    private void descontoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descontoFActionPerformed
        if (descontoF.isSelected()) {
            valorDesconto.setEnabled(true);
        } else if (!descontoF.isSelected()) {
            valorDesconto.setEnabled(false);
        }
    }//GEN-LAST:event_descontoFActionPerformed

    private void descontoFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_descontoFPropertyChange

    }//GEN-LAST:event_descontoFPropertyChange

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        long cpfFunc = funcionario.getCPF();
        String temp = cpfF.getText().replace(".", "").replace("-", "");
        long cpfCliente = Long.parseLong(temp);
        int codProd = Integer.parseInt(codProdF.getText());
        double valor = Double.parseDouble(valorFinal.getText());
        String data = Formatacao.getDataAtual();
        int quantidade = Integer.parseInt(quantidadeF.getText());
        Venda venda = new Venda(cpfFunc, cpfCliente, codProd, valor, data, quantidade);
        try {
            vendaDao.create(venda);
        } catch (DataBaseException | DuplicateKeyException ex) {
            Warning w = new Warning(ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        TelaCadastroCli tela;
        try {
            tela = new TelaCadastroCli();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncActionPerformed
        TelaCadastroFunc tela;
        try {
            tela = new TelaCadastroFunc(funcionario);
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }


    }//GEN-LAST:event_menuFuncActionPerformed

    private void menuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutoActionPerformed
        try {
            TelaCadastroProd tela = new TelaCadastroProd();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuProdutoActionPerformed

    private void menuSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSetorActionPerformed
        try {
            TelaCadastroSetor tela = new TelaCadastroSetor();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuSetorActionPerformed

    private void menuFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncaoActionPerformed
        try {
            TelaCadastroFuncao tela = new TelaCadastroFuncao();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuFuncaoActionPerformed

    private void menuCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliente1ActionPerformed
        TelaCadastroCli tela;
        try {
            tela = new TelaCadastroCli();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuCliente1ActionPerformed

    private void menuCliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCliente1MouseClicked
        TelaCadastroCli tela;
        try {
            tela = new TelaCadastroCli();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuCliente1MouseClicked

    private void menuFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFuncMouseClicked
        TelaCadastroFunc tela;
        try {
            tela = new TelaCadastroFunc(funcionario);
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuFuncMouseClicked

    private void menuProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProdutoMouseClicked
        try {
            TelaCadastroProd tela = new TelaCadastroProd();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuProdutoMouseClicked

    private void menuSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSetorMouseClicked
        try {
            TelaCadastroSetor tela = new TelaCadastroSetor();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuSetorMouseClicked

    private void menuFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFuncaoMouseClicked
        try {
            TelaCadastroFuncao tela = new TelaCadastroFuncao();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_menuFuncaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton addProduto;
    private br.univates.system32.components.JMyNumberField codProdF;
    private javax.swing.JButton confirm;
    private br.univates.system32.components.JMyCpfField cpfF;
    private javax.swing.JRadioButton descontoF;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea log;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuCliente1;
    private javax.swing.JMenu menuFunc;
    private javax.swing.JMenu menuFuncao;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenu menuSetor;
    private javax.swing.JComboBox<String> pagamento;
    private br.univates.system32.components.JMyNumberField quantidadeF;
    private br.univates.system32.components.JMyNumberField valorDesconto;
    private br.univates.system32.components.JMyNumberField valorFinal;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
