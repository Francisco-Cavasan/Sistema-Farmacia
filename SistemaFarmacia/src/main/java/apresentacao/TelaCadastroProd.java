package apresentacao;

import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.awt.Toolkit;
import java.util.ArrayList;

import negocio.Categoria;
import negocio.Fabricante;
import negocio.Produto;
import persistencia.CategoriaDaoSQL;
import persistencia.FabricanteDaoSQL;
import persistencia.ProdutoDaoSQL;

public class TelaCadastroProd extends javax.swing.JFrame {

    private ProdutoDaoSQL dao;
    private CategoriaDaoSQL catDao;
    private ArrayList<Fabricante> fabricantes;
    private FabricanteDaoSQL fabDao;

    public TelaCadastroProd() throws DataBaseException {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/images/icone.png")));
        dao = new ProdutoDaoSQL();
        catDao = new CategoriaDaoSQL();
        fabDao = new FabricanteDaoSQL();
        fabricantes = fabDao.readAll();
        this.setLocationRelativeTo(null);
        categoriaCB.removeAllItems();
        ArrayList<Categoria> categorias = catDao.readAll();
        if(!categorias.isEmpty()){
            for (Categoria categoria : categorias) {
            categoriaCB.addItem(categoria.getNome());
        }
        }
        fabricantesBox.removeAllItems();
        for (Fabricante fab : fabricantes) {
            fabricantesBox.addItem(fab.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        nomeF2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        categoriaCB = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        quantF = new br.univates.system32.components.JMyNumberField();
        jLabel1 = new javax.swing.JLabel();
        codigoF = new br.univates.system32.components.JMyNumberField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoF = new javax.swing.JTextArea();
        ValorF = new br.univates.system32.components.JMyCurrencyField();
        fabricantesBox = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        register = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        novo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Cadastro de Produto");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Quantidade");

        jLabel23.setText("Nome");

        jLabel24.setText("Fabricante");

        jLabel25.setText("Valor");

        jLabel29.setText("Categoria");

        categoriaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Código");

        jLabel26.setText("Descrição");

        descricaoF.setColumns(20);
        descricaoF.setRows(5);
        jScrollPane1.setViewportView(descricaoF);

        ValorF.setText("jMyCurrencyField1");

        fabricantesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel23))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeF2)
                                    .addComponent(ValorF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fabricantesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(nomeF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(quantF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fabricantesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(codigoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(ValorF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 72, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))))
        );

        delete.setText("Excluir");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        register.setText("Registrar");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        novo.setText("Novo");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(edit)
                        .addGap(18, 18, 18)
                        .addComponent(register)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register)
                    .addComponent(cancel)
                    .addComponent(edit)
                    .addComponent(delete)
                    .addComponent(novo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        try {
            int codigo = Integer.parseInt(codigoF.getText());
            String nome = nomeF2.getText();
            String fabricante = fabricantesBox.getSelectedItem().toString();
            int fabCod = -1;
            for (Fabricante fab : fabricantes) {
                if(fab.getNome().equals(fabricante)){
                    fabCod = fab.getCodigo();
                }
            }
            Double valor = (ValorF.getDouble());
            String quantidade = quantF.getText();
            String descricao = descricaoF.getText();
            String categoria = categoriaCB.getSelectedItem().toString();
            int catCod = -1;
            ArrayList<Categoria> categorias = catDao.readAll();
            for (Categoria cat : categorias) {
                if(categoria.equals(cat.getNome())){
                    catCod = cat.getCodigo();
                }
            }
            if (valor > 0 && !nome.isBlank() && !quantidade.isBlank() && !codigoF.getText().isBlank()) {
                Produto prod = new Produto(codigo, nome, fabCod, quantidade, valor, descricao, catCod);
                dao.create(prod);
            } else {
                Warning w = new Warning("Favor preencher todos os campos corretamente");
                w.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            Warning w = new Warning("Favor preencher todos os campos corretamente");
            w.setVisible(true);
        } catch (DataBaseException | DuplicateKeyException ex) {
            Warning w = new Warning("Não foi possível inserir este item no sistema. Confira os dados e tente novamente. Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_registerActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
         try {
            int codigo = Integer.parseInt(codigoF.getText());
            String nome = nomeF2.getText();
            String fabricante = fabricantesBox.getSelectedItem().toString();
            int fabCod = -1;
            for (Fabricante fab : fabricantes) {
                if(fab.getNome().equals(fabricante)){
                    fabCod = fab.getCodigo();
                }
            }
            Double valor = (ValorF.getDouble());
            String quantidade = quantF.getText();
            String descricao = descricaoF.getText();
            String categoria = categoriaCB.getSelectedItem().toString();
            int catCod = -1;
            ArrayList<Categoria> categorias = catDao.readAll();
            for (Categoria cat : categorias) {
                if(categoria.equals(cat.getNome())){
                    catCod = cat.getCodigo();
                }
            }
            if (valor > 0 && !nome.isBlank() && !categoria.isBlank() && !quantidade.isBlank()) {
                Produto prod = new Produto(codigo, nome, fabCod, quantidade, valor, descricao, catCod);
                dao.edit(prod);
            } else {
                Warning w = new Warning("Favor preencher todos os campos corretamente");
                w.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            Warning w = new Warning("Favor preencher todos os campos corretamente");
            w.setVisible(true);
        } catch (DataBaseException ex) {
           Warning w = new Warning(ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            int codigo = Integer.parseInt(codigoF.getText());
            String nome = nomeF2.getText();
            String fabricante = fabricantesBox.getSelectedItem().toString();
            int fabCod = -1;
            for (Fabricante fab : fabricantes) {
                if(fab.getNome().equals(fabricante)){
                    fabCod = fab.getCodigo();
                }
            }
            Double valor = (ValorF.getDouble());
            String quantidade = quantF.getText();
            String descricao = descricaoF.getText();
            String categoria = categoriaCB.getSelectedItem().toString();
            int catCod = -1;
            ArrayList<Categoria> categorias = catDao.readAll();
            for (Categoria cat : categorias) {
                if(categoria.equals(cat.getNome())){
                    catCod = cat.getCodigo();
                }
            }
            if (valor > 0 && !nome.isBlank() && !categoria.isBlank() && !quantidade.isBlank()) {
                Produto prod = new Produto(codigo, nome, fabCod, quantidade, valor, descricao, catCod);
                dao.delete(prod);
            } else {
                Warning w = new Warning("Favor preencher todos os campos corretamente");
                w.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            Warning w = new Warning("Favor preencher todos os campos corretamente");
            w.setVisible(true);
        } catch (DataBaseException ex) {
           Warning w = new Warning(ex.getMessage());
            w.setVisible(true);
    }//GEN-LAST:event_deleteActionPerformed
    }
    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        codigoF.setText("");
        nomeF2.setText("");
        ValorF.setText("");
        quantF.setText("");
        descricaoF.setText("");
    }//GEN-LAST:event_novoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.univates.system32.components.JMyCurrencyField ValorF;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> categoriaCB;
    private br.univates.system32.components.JMyNumberField codigoF;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea descricaoF;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> fabricantesBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeF2;
    private javax.swing.JButton novo;
    private br.univates.system32.components.JMyNumberField quantF;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables

}
