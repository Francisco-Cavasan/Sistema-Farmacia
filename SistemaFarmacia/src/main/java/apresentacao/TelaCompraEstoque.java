package apresentacao;

import br.univates.system32.Formatacao;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import negocio.Categoria;
import negocio.CompraEstoque;
import negocio.Fabricante;
import negocio.Funcionario;
import negocio.Produto;
import persistencia.CategoriaDaoSQL;
import persistencia.CompraEstoqueDaoSQL;
import persistencia.FabricanteDaoSQL;
import persistencia.ProdutoDaoSQL;

public class TelaCompraEstoque extends javax.swing.JFrame {

    private Produto produto;
    private ArrayList<Produto> produtos;
    private ProdutoDaoSQL produtoDao;
    private CategoriaDaoSQL categoriaDao;
    private ArrayList<Categoria> categorias;
    private ArrayList<Produto> produtosCompra;
    private ArrayList<Fabricante> fabricantes;
    private FabricanteDaoSQL fabDao;
    private Funcionario func;
    private CompraEstoqueDaoSQL estoqueDao;

    public TelaCompraEstoque(Funcionario func) throws DataBaseException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        produtosCompra = new ArrayList();
        estoqueDao = new CompraEstoqueDaoSQL();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/images/icone.png")));
        categoriaDao = new CategoriaDaoSQL();
        produtoDao = new ProdutoDaoSQL();
        categorias = categoriaDao.readAll();
        fabDao = new FabricanteDaoSQL();
        fabricantes = fabDao.readAll();
        fabricanteBox.removeAllItems();
        for (Fabricante fab : fabricantes) {
            fabricanteBox.addItem(fab.getNome());
        }
        this.func = func;
        produtos = new ArrayList();
        ProdutoDaoSQL dao = new ProdutoDaoSQL();
        produtos = dao.readAll();
        categoria.removeAllItems();
        ArrayList<Categoria> categoriasAr = categoriaDao.readAll();
        if (!categorias.isEmpty()) {
            for (Categoria cats : categoriasAr) {
                categoria.addItem(cats.getNome());
            }
        }
        ProdutosTableModel tm = new ProdutosTableModel(produtos);
        tabela.setModel(tm);
        ProdutosTableModel tmC = new ProdutosTableModel(produtosCompra);
        tabelaCompra.setModel(tmC);

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    ProdutosTableModel tableModel = (ProdutosTableModel) tabela.getModel();
                    produto = tableModel.getProdutos().get(tabela.getSelectedRow());
                    codigo.setInteger(produto.getCodigo());
                    nome.setText((produto.getNome()));
                    amount.setInteger(Integer.parseInt(produto.getQuantidade()));
                    int temp = -1;
                    int temp1 = -1;
                    for (Categoria cat : categorias) {
                        if (cat.getNome().equals(categoria.getSelectedItem().toString())) {
                            temp = cat.getCodigo();
                        }
                    }
                    for (Fabricante fabr : fabricantes) {
                        if (fabr.getNome().equals(fabricanteBox.getSelectedItem().toString())) {
                            temp1 = fabr.getCodigo();
                        }
                    }
                    Fabricante fab;
                    Categoria aux;
                    try {
                        fab = fabDao.read(temp1);
                        fabricanteBox.setSelectedItem(fab);
                        aux = categoriaDao.read(temp);
                        categoria.setSelectedItem(aux);
                    } catch (DataBaseException ex) {
                        Warning w = new Warning("Erro: " + ex.getMessage());
                        w.setVisible(true);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigo = new br.univates.system32.components.JMyNumberField();
        jLabel2 = new javax.swing.JLabel();
        categoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amount = new br.univates.system32.components.JMyNumberField();
        jLabel5 = new javax.swing.JLabel();
        valor = new br.univates.system32.components.JMyCurrencyField();
        search = new javax.swing.JToggleButton();
        exit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fabricanteBox = new javax.swing.JComboBox<>();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCompra = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Compra de Estoque");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código");

        jLabel2.setText("Categoria");

        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nome");

        jLabel4.setText("Quantidade");

        jLabel5.setText("Valor");

        valor.setText("jMyCurrencyField1");

        search.setText("Buscar");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        exit.setText("Sair");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel6.setText("Fabricante");

        fabricanteBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        clear.setText("Limpar");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoria, 0, 126, Short.MAX_VALUE)
                            .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nome)
                            .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fabricanteBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fabricanteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(exit)
                    .addComponent(clear))
                .addContainerGap())
        );

        add.setText("Adicionar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        confirm.setText("Confirmar");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(tabelaCompra);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Seleção de Produto");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tabela de Compras");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        int cod = codigo.getInteger();
        String name = nome.getText();
        double value = valor.getDouble();
        String cat = categoria.getSelectedItem().toString();
        int quantidade = amount.getInteger();
        int stop = 0;
        while (stop != 1) {
            if (!name.isBlank() && cod > 0 && value > 0 && !cat.isBlank() && quantidade > 0) {
                tabela.removeAll();
                try {
                    int temp = -1;
                    for (Categoria cate : categorias) {
                        if (cate.getNome().equals(cat)) {
                            temp = cate.getCodigo();
                        }
                    }
                    produtos = produtoDao.readEvery(cod, name, value, quantidade, temp);
                    ProdutosTableModel tm = (ProdutosTableModel) tabela.getModel();
                    tm.setProdutos(produtos);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: " + ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else if (!name.isBlank() && cod > 0) {
                tabela.removeAll();
                try {
                    produtos = produtoDao.readCodName(cod, name);
                    ProdutosTableModel tm = (ProdutosTableModel) tabela.getModel();
                    tm.setProdutos(produtos);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: " + ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else if (cod > 0) {
                tabela.removeAll();
                try {
                    produtos.add(produtoDao.read(cod));
                    ProdutosTableModel tm = (ProdutosTableModel) tabela.getModel();
                    tm.setProdutos(produtos);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: " + ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else {
                Warning w = new Warning("Favor preencher os campos ou somente o campo do código");
                w.setVisible(true);
                stop = 1;
            }
        }
    }//GEN-LAST:event_searchActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int cod = codigo.getInteger();
        String name = nome.getText();
        double value = valor.getDouble();
        String cat = categoria.getSelectedItem().toString();
        int aux = -1;
        for (Categoria cate : categorias) {
            if (cate.getNome().equals(cat)) {
                aux = cate.getCodigo();
            }
        }
        String quantidade = amount.getText();
        String temp = fabricanteBox.getSelectedItem().toString();
        int fab = -1;
        for (Fabricante fabricante : fabricantes) {
            if (fabricante.getNome().equals(temp)) {
                fab = fabricante.getCodigo();
            }
        }
        Produto auxProd = null;
        try {
            auxProd = produtoDao.read(cod);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Favor preencher os campos ou somente o campo do código");
            w.setVisible(true);
        }
        Produto prod = new Produto(auxProd.getCodigo(), auxProd.getNome(), fab, quantidade, value, aux);
        produtosCompra.add(prod);
        ProdutosTableModel tm = (ProdutosTableModel) tabelaCompra.getModel();
        tm.setProdutos(produtosCompra);
        tabelaCompra.revalidate();
        tabelaCompra.repaint();
    }//GEN-LAST:event_addActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        long cpf = func.getCPF();
        int idCompra = -1;
        ArrayList<CompraEstoque> compras = null;
        try {
            compras = estoqueDao.readAll();
        } catch (DataBaseException ex) {
            Logger.getLogger(TelaCompraEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        int size = compras.size();
        if(size == 0){
            idCompra = 1;
        }
        else if(size > 0){
            idCompra = (compras.get(size-1).getCodigo()) + 1;
        }
        String data = Formatacao.getDataAtual();
        double value = valor.getDouble();
        for (Produto prod : produtosCompra) {
            CompraEstoque compra = new CompraEstoque(idCompra,prod.getCodigo(), amount.getInteger(), value,cpf,prod.getFabricante(),data);
            try {
                estoqueDao.create(compra);
            } catch (DataBaseException | DuplicateKeyException ex) {
                Warning w = new Warning("Erro: "+ex.getMessage());
            w.setVisible(true);
            }
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        codigo.setText("");
        nome.setText("");
        amount.setText("");
        valor.setText("");
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private br.univates.system32.components.JMyNumberField amount;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JButton clear;
    private br.univates.system32.components.JMyNumberField codigo;
    private javax.swing.JButton confirm;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> fabricanteBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JToggleButton search;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaCompra;
    private br.univates.system32.components.JMyCurrencyField valor;
    // End of variables declaration//GEN-END:variables
}
