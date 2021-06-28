package apresentacao;

import br.univates.system32.db.DataBaseException;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import negocio.Categoria;
import negocio.Fabricante;
import negocio.Produto;
import persistencia.CategoriaDaoSQL;
import persistencia.FabricanteDaoSQL;
import persistencia.ProdutoDaoSQL;

public class TabelaProdutos extends javax.swing.JFrame {

    private Produto produto;
    private ArrayList<Produto> produtos;
    private ProdutoDaoSQL produtoDao;
    private CategoriaDaoSQL categoriaDao;
    private ArrayList<Categoria> categorias;
    private ArrayList<Fabricante> fabricantes;
    private FabricanteDaoSQL fabDao;

    public TabelaProdutos() throws DataBaseException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/images/icone.png")));
        categoriaDao = new CategoriaDaoSQL();
        fabDao = new FabricanteDaoSQL();
        produtoDao = new ProdutoDaoSQL();
        categorias = categoriaDao.readAll();
        fabricantes = fabDao.readAll();
        fabricanteBox.removeAllItems();
        for (Fabricante fab : fabricantes) {
            fabricanteBox.addItem(fab.getNome());
        }
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
                    valor.setDouble(produto.getValor());
                    int temp = 0;
                    int temp1 = 0;
                    for (Categoria cat : categorias) {
                        if (cat.getNome().equals(categoria.getSelectedItem().toString())) {
                            temp = cat.getCodigo();
                        }
                    }
                    for(Fabricante fabr : fabricantes){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Produtos");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoria, 0, 126, Short.MAX_VALUE)
                            .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nome)
                            .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(exit))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(fabricanteBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fabricanteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(exit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.univates.system32.components.JMyNumberField amount;
    private javax.swing.JComboBox<String> categoria;
    private br.univates.system32.components.JMyNumberField codigo;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> fabricanteBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JToggleButton search;
    private javax.swing.JTable tabela;
    private br.univates.system32.components.JMyCurrencyField valor;
    // End of variables declaration//GEN-END:variables
}
