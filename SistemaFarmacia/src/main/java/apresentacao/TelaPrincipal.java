package apresentacao;

import br.univates.system32.Entrada;
import br.univates.system32.Formatacao;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.reports.Report;
import br.univates.system32.reports.ReportManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SistemaFarmacia;
import negocio.Funcionario;
import negocio.ItemProduto;
import negocio.ItensVenda;
import negocio.Jornada;
import negocio.Pagamento;
import negocio.Produto;
import negocio.Venda;
import persistencia.ItensVendaDaoSQL;
import persistencia.JornadaDaoSQL;
import persistencia.PagamentoDaoSQL;
import persistencia.ProdutoDaoSQL;
import persistencia.VendaDaoSQL;

public class TelaPrincipal extends javax.swing.JFrame {

    private Funcionario funcionario;
    private VendaDaoSQL vendaDao;
    private ItensVendaDaoSQL itensDao;
    private ArrayList<Produto> produtos;
    private ArrayList<Produto> produtosTemp;
    private ProdutoDaoSQL produtoDao;
    private ArrayList<Pagamento> pagamentos;
    private ArrayList<Integer> quantidades;
    private double valor;
    private PagamentoDaoSQL pagamentoDao;
    private ArrayList<ItemProduto> itens;
    private JornadaDaoSQL jornadaDao;
    private String dataInicial;

    public TelaPrincipal(Funcionario funcionario) throws DataBaseException {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/images/icone.png")));
        valorDesconto.setEnabled(false);
        jornadaDao = new JornadaDaoSQL();
        pagamentoDao = new PagamentoDaoSQL();
        pagamentos = pagamentoDao.readAll();
        quantidades = new ArrayList();
        valor = 0.0;
        welcome.setText("Bem vindo(a) " + funcionario.getNome());
        vendaDao = new VendaDaoSQL();
        itensDao = new ItensVendaDaoSQL();
        this.funcionario = funcionario;
        produtos = new ArrayList();
        produtosTemp = new ArrayList();
        produtoDao = new ProdutoDaoSQL();
        pagamentoBox.removeAllItems();
        for (Pagamento pagamento : pagamentos) {
            pagamentoBox.addItem(pagamento.getNome());
        }
        if (funcionario.getAdmin() == false) {
            menuFunc.setVisible(false);
            menuCliente.setVisible(true);
            menuProduto.setVisible(false);
            menuSetor.setVisible(false);
            menuFuncao.setVisible(false);
            menuTabela.setVisible(true);
            menuRelatorio.setVisible(true);
            menuListagem.setVisible(true);
            menuCategoria.setVisible(false);
            menuPagamento.setVisible(false);
            menuFabricante.setVisible(false);
            menuComprarEstoque.setVisible(false);
        }
        produtos = produtoDao.readAll();
        for (Produto produto : produtos) {
            if (Integer.parseInt(produto.getQuantidade()) <= 10) {
                menuTabela.setBackground(Color.red);
                tabelaProdM.setBackground(Color.red);
                Warning w = new Warning("O produto " + produto.getNome() + "tem poucas unidades em estoque");
                w.setVisible(true);
            }
        }
        itens = new ArrayList();
        produtos.clear();
        ItensTableModel tm = new ItensTableModel(itens);
        tabela.setModel(tm);

        receivedT.setVisible(false);
        changeT.setVisible(false);
        received.setVisible(false);
        change.setVisible(false);

        dataInicial = Formatacao.getDataHoraAtual();

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        codProdF = new br.univates.system32.components.JMyNumberField();
        jLabel4 = new javax.swing.JLabel();
        quantidade = new br.univates.system32.components.JMyNumberField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cpfF = new br.univates.system32.components.JMyCpfField();
        descontoF = new javax.swing.JRadioButton();
        pagamentoBox = new javax.swing.JComboBox<>();
        receivedT = new javax.swing.JLabel();
        received = new br.univates.system32.components.JMyCurrencyField();
        changeT = new javax.swing.JLabel();
        change = new br.univates.system32.components.JMyCurrencyField();
        valorDesconto = new br.univates.system32.components.JMyNumberField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        valorFinal = new br.univates.system32.components.JMyCurrencyField();
        welcome = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        menuCliente1 = new javax.swing.JMenu();
        menuFunc = new javax.swing.JMenu();
        menuProduto = new javax.swing.JMenu();
        menuSetor = new javax.swing.JMenu();
        menuFuncao = new javax.swing.JMenu();
        menuCidade = new javax.swing.JMenu();
        menuCategoria = new javax.swing.JMenu();
        menuPagamento = new javax.swing.JMenu();
        menuFabricante = new javax.swing.JMenu();
        menuTabela = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        tabelaClientesM = new javax.swing.JMenu();
        tabelaProdM = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        tabelaVendas = new javax.swing.JMenu();
        menuRelatorio = new javax.swing.JMenu();
        jRelatorioClientes = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuRelatorioVendaCidade = new javax.swing.JMenu();
        menuMaisVendidos = new javax.swing.JMenu();
        vendasUfMenu = new javax.swing.JMenu();
        menuRelatorioFabricante = new javax.swing.JMenu();
        menuListagem = new javax.swing.JMenu();
        listagemClientes = new javax.swing.JMenu();
        listagemFuncionarios = new javax.swing.JMenu();
        menuComprarEstoque = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuJornadaHoje = new javax.swing.JMenu();
        menuJornadaCPF = new javax.swing.JMenu();
        menuJornadaData = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu13.setText("jMenu13");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FarmaPlus");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(54, 57, 74));

        jPanel1.setBackground(new java.awt.Color(46, 52, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addProduto.setBackground(new java.awt.Color(54, 57, 73));
        addProduto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        addProduto.setForeground(new java.awt.Color(0, 0, 0));
        addProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus.png"))); // NOI18N
        addProduto.setText("Adicionar produto");
        addProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdutoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(54, 57, 58));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código produto");

        codProdF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Quantidade");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pagamento");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CPF");

        cpfF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFActionPerformed(evt);
            }
        });

        descontoF.setBackground(new java.awt.Color(54, 57, 58));
        descontoF.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        descontoF.setForeground(new java.awt.Color(0, 0, 0));
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

        pagamentoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pagamentoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pagamentoBoxItemStateChanged(evt);
            }
        });
        pagamentoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoBoxActionPerformed(evt);
            }
        });

        receivedT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        receivedT.setForeground(new java.awt.Color(0, 0, 0));
        receivedT.setText("Valor recebido:");

        received.setText("jMyCurrencyField1");
        received.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receivedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receivedFocusLost(evt);
            }
        });
        received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedActionPerformed(evt);
            }
        });
        received.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                receivedPropertyChange(evt);
            }
        });
        received.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                receivedKeyTyped(evt);
            }
        });

        changeT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        changeT.setForeground(new java.awt.Color(0, 0, 0));
        changeT.setText("Troco");

        change.setEditable(false);
        change.setText("jMyCurrencyField2");

        valorDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorDescontoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changeT)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descontoF)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(receivedT)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(received, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagamentoBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 85, Short.MAX_VALUE)
                    .addComponent(cpfF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codProdF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorDesconto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codProdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descontoF)
                    .addComponent(valorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receivedT)
                    .addComponent(received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeT)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

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
        jScrollPane4.setViewportView(tabela);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("R$");

        valorFinal.setEditable(false);
        valorFinal.setBackground(new java.awt.Color(54, 57, 58));
        valorFinal.setForeground(new java.awt.Color(0, 0, 0));
        valorFinal.setText("jMyCurrencyField1");
        valorFinal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(valorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        welcome.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(0, 0, 0));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Bem vindo");

        exit.setBackground(new java.awt.Color(54, 86, 98));
        exit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 0));
        exit.setText("Sair");
        exit.setBorderPainted(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        confirm.setBackground(new java.awt.Color(54, 86, 98));
        confirm.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        confirm.setForeground(new java.awt.Color(0, 0, 0));
        confirm.setText("Fechar compra");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirm))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(welcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        MenuBar.setBackground(new java.awt.Color(58, 71, 78));

        menuCliente.setBackground(new java.awt.Color(58, 71, 78));
        menuCliente.setForeground(new java.awt.Color(0, 0, 0));
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

        menuCidade.setText("Cidade");
        menuCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCidadeMouseClicked(evt);
            }
        });
        menuCliente.add(menuCidade);

        menuCategoria.setText("Categoria");
        menuCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCategoriaMouseClicked(evt);
            }
        });
        menuCliente.add(menuCategoria);

        menuPagamento.setText("Pagamento");
        menuPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPagamentoMouseClicked(evt);
            }
        });
        menuCliente.add(menuPagamento);

        menuFabricante.setText("Fabricante");
        menuFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFabricanteMouseClicked(evt);
            }
        });
        menuFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFabricanteActionPerformed(evt);
            }
        });
        menuCliente.add(menuFabricante);

        MenuBar.add(menuCliente);

        menuTabela.setBackground(new java.awt.Color(58, 71, 78));
        menuTabela.setForeground(new java.awt.Color(0, 0, 0));
        menuTabela.setText("Tabelas");

        jMenu8.setText("Funcionário");
        menuTabela.add(jMenu8);

        tabelaClientesM.setText("Cliente");
        tabelaClientesM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMMouseClicked(evt);
            }
        });
        menuTabela.add(tabelaClientesM);

        tabelaProdM.setText("Produto");
        tabelaProdM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdMMouseClicked(evt);
            }
        });
        menuTabela.add(tabelaProdM);

        jMenu16.setText("Setor");
        menuTabela.add(jMenu16);

        jMenu17.setText("Função");
        menuTabela.add(jMenu17);

        tabelaVendas.setText("Vendas");
        tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendasMouseClicked(evt);
            }
        });
        menuTabela.add(tabelaVendas);

        MenuBar.add(menuTabela);

        menuRelatorio.setBackground(new java.awt.Color(58, 71, 78));
        menuRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        menuRelatorio.setText("Relatórios");

        jRelatorioClientes.setText("Relatório de Clientes");
        jRelatorioClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRelatorioClientesMouseClicked(evt);
            }
        });
        menuRelatorio.add(jRelatorioClientes);

        jMenu2.setText("Relatório de Funcionários");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menuRelatorio.add(jMenu2);

        menuRelatorioVendaCidade.setText("Relátorio Vendas Cidade");
        menuRelatorioVendaCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRelatorioVendaCidadeMouseClicked(evt);
            }
        });
        menuRelatorio.add(menuRelatorioVendaCidade);

        menuMaisVendidos.setText("Relatório Produtos Mais Vendidos");
        menuMaisVendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMaisVendidosMouseClicked(evt);
            }
        });
        menuRelatorio.add(menuMaisVendidos);

        vendasUfMenu.setText("Relatório Vendas Estado");
        vendasUfMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendasUfMenuMouseClicked(evt);
            }
        });
        menuRelatorio.add(vendasUfMenu);

        menuRelatorioFabricante.setText("Relatório Vendas Fabricante");
        menuRelatorioFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRelatorioFabricanteMouseClicked(evt);
            }
        });
        menuRelatorio.add(menuRelatorioFabricante);

        MenuBar.add(menuRelatorio);

        menuListagem.setBackground(new java.awt.Color(58, 71, 78));
        menuListagem.setForeground(new java.awt.Color(0, 0, 0));
        menuListagem.setText("Listagem");
        menuListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuListagemMouseClicked(evt);
            }
        });

        listagemClientes.setText("Listagem de Clientes");
        listagemClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagemClientesMouseClicked(evt);
            }
        });
        listagemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listagemClientesActionPerformed(evt);
            }
        });
        menuListagem.add(listagemClientes);

        listagemFuncionarios.setText("Listagem de Funcionários");
        listagemFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagemFuncionariosMouseClicked(evt);
            }
        });
        menuListagem.add(listagemFuncionarios);

        MenuBar.add(menuListagem);

        menuComprarEstoque.setBackground(new java.awt.Color(58, 71, 78));
        menuComprarEstoque.setForeground(new java.awt.Color(0, 0, 0));
        menuComprarEstoque.setText("Compra Estoque");
        menuComprarEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuComprarEstoqueMouseClicked(evt);
            }
        });
        MenuBar.add(menuComprarEstoque);

        jMenu3.setBackground(new java.awt.Color(58, 71, 78));
        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
        jMenu3.setText("Jornadas");

        menuJornadaHoje.setText("Jornada Hoje");
        jMenu3.add(menuJornadaHoje);

        menuJornadaCPF.setText("Jornada por CPF");
        menuJornadaCPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuJornadaCPFMouseClicked(evt);
            }
        });
        jMenu3.add(menuJornadaCPF);

        menuJornadaData.setText("Jornada por Data");
        jMenu3.add(menuJornadaData);

        MenuBar.add(jMenu3);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void atualizarTabela() {
        ItensTableModel tm = (ItensTableModel) tabela.getModel();
        tm.setItens(itens);
        tabela.revalidate();
        tabela.repaint();
    }

    private void addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdutoActionPerformed
        if (quantidade.getText().isBlank() || codProdF.getText().isBlank() || cpfF.getText().isBlank()) {
            Warning w = new Warning("Favor preencher todos os campos corretamente");
            w.setVisible(true);
        }
        try {
            Produto prod = produtoDao.read(codProdF.getInteger());
            produtos.add(prod);
            produtosTemp.add(prod);
            for (Produto produto : produtosTemp) {
                if (Integer.parseInt(quantidade.getText()) <= 0) {
                    Warning w = new Warning("Informe um quantidade");
                    w.setVisible(true);
                    break;
                } else {
                    quantidades.add(Integer.parseInt(quantidade.getText()));
                    ItemProduto item = new ItemProduto(prod.getCodigo(), prod.getNome(), (produto.getValor() * Integer.parseInt(quantidade.getText())), (quantidades.get(quantidades.size() - 1)));
                    itens.add(item);
                    atualizarTabela();
                    valor = valor + (produto.getValor()) * (Integer.parseInt(quantidade.getText()));
                    produtosTemp.clear();
                }
                valorFinal.setDouble(valor);
                break;
            }
        } catch (DataBaseException ex) {
            Warning w = new Warning("Não foi possível realizar a operação. Erro: " + ex.getMessage());
            w.setVisible(true);
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

    public boolean pagamentoOk(double valor) {
        boolean ok = true;
        if (valor <= 0) {
            ok = false;
            Warning w = new Warning("O valor informado é inferior a zero.");
            w.setVisible(true);
        } else if (valor < valorFinal.getDouble()) {
            ok = false;
            Warning w = new Warning("O valor informado é inferior ao total.");
            w.setVisible(true);
        } else if (valorFinal.getText().isBlank()) {
            ok = false;
            Warning w = new Warning("Nenhum valor foi informado.");
            w.setVisible(true);
        } else {
            change.setDouble(valor - valorFinal.getDouble());
        }
        return ok;
    }

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        if (pagamentoBox.getSelectedItem().toString().equals("Dinheiro")) {
            receivedT.setVisible(true);
            changeT.setVisible(true);
            received.setVisible(true);
            change.setVisible(true);
        }
        String idVenda = "default";
        long cpfFunc = funcionario.getCPF();
        long cpfCliente = Long.parseLong(cpfF.getText().replace(".", "").replace("-", ""));
        String data = Formatacao.getDataAtual();

        int pag = -1;
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getNome().equals(pagamentoBox.getSelectedItem().toString())) {
                pag = pagamento.getCodigo();
            }
        }
        Venda venda = null;
        if (produtos.size() > 0) {
            venda = new Venda(idVenda, cpfFunc, cpfCliente, data, pag);
        }
        boolean ok = true;
        int i = 0;
        double desc = 0;
        if (!valorDesconto.getText().isBlank()) {
            desc = Double.parseDouble(valorDesconto.getText()) / 100;
        }
        try {
            if (pagamentoBox.getSelectedItem().toString().equals("Dinheiro") && pagamentoOk(received.getDouble())) {
                vendaDao.create(venda);
                ArrayList<Venda> vendas = vendaDao.readAll();
                Venda temp = vendas.get(vendas.size() - 1);
                for (Produto produto : produtos) {
                    ItensVenda item = new ItensVenda(temp.getIdVenda(), produto.getCodigo(), quantidades.get(i), (quantidades.get(i) * produto.getValor()), desc);
                    itensDao.create(item);
                    Produto aux = new Produto(produto.getCodigo(), produto.getNome(), produto.getFabricante(), Integer.toString(Integer.parseInt(produto.getQuantidade()) - quantidades.get(i)), produto.getValor(), produto.getDescricao(), produto.getCategoria());
                    produtoDao.editStock(aux);
                    i++;
                }
                RelatorioNotaFiscal nota = new RelatorioNotaFiscal(Integer.parseInt(temp.getIdVenda()));
                SistemaFarmacia.getInstance().getReportManager().createReport(nota);
            }
            if (!pagamentoBox.getSelectedItem().toString().equals("Dinheiro")) {
                vendaDao.create(venda);
                ArrayList<Venda> vendas = vendaDao.readAll();
                Venda temp = vendas.get(vendas.size() - 1);
                for (Produto produto : produtos) {
                    ItensVenda item = new ItensVenda(temp.getIdVenda(), produto.getCodigo(), quantidades.get(i), (quantidades.get(i) * produto.getValor()), desc);
                    itensDao.create(item);
                    Produto aux = new Produto(produto.getCodigo(), produto.getNome(), produto.getFabricante(), Integer.toString(Integer.parseInt(produto.getQuantidade()) - quantidades.get(i)), produto.getValor(), produto.getDescricao(), produto.getCategoria());
                    produtoDao.editStock(aux);
                    i++;
                }
                RelatorioNotaFiscal nota = new RelatorioNotaFiscal(Integer.parseInt(temp.getIdVenda()));
                SistemaFarmacia.getInstance().getReportManager().createReport(nota);
            }

        } catch (DataBaseException | DuplicateKeyException ex) {
            ok = false;
            Warning w = new Warning("Não foi possível realizar a operação. Erro: " + ex.getMessage());
            w.setVisible(true);
        }
        if (ok == false) {
            try {
                vendaDao.delete(venda);
            } catch (DataBaseException ex) {
                Warning w = new Warning("Não foi possível realizar a operação. Erro: " + ex.getMessage());
                w.setVisible(true);
            }
        }
    }//GEN-LAST:event_confirmActionPerformed


    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        String dataFinal = Formatacao.getDataHoraAtual();
        Jornada j = new Jornada(dataInicial, dataFinal, funcionario.getCPF(), funcionario.getNome());
        try {
            jornadaDao.create(j);
        } catch (DataBaseException | DuplicateKeyException ex) {
            Warning w = new Warning("Erro ao resgistrar jornada: " + ex.getMessage());
            w.setVisible(true);
        }
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
        TelaCadastroFuncionario tela;
        try {
            tela = new TelaCadastroFuncionario(funcionario);
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
        TelaCadastroFuncionario tela;
        try {
            tela = new TelaCadastroFuncionario(funcionario);
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

    private void listagemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listagemClientesActionPerformed

    }//GEN-LAST:event_listagemClientesActionPerformed

    private void listagemClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagemClientesMouseClicked

        Report r = new Report() {
            @Override
            public HashMap getParameters() {
                return new HashMap();
            }

            @Override
            public String getPath() {
                return "/resources/reports/ListagemClientes.jrxml";
            }

        };
        ReportManager rm = new ReportManager();

        try {
            rm.setDataBaseConnection(SistemaFarmacia.getInstance().getDataBaseManager().getConnection());
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
        rm.createReport(r);
    }//GEN-LAST:event_listagemClientesMouseClicked

    private void jRelatorioClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRelatorioClientesMouseClicked
        TelaRelatorioClientes tela;
        try {
            tela = new TelaRelatorioClientes();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_jRelatorioClientesMouseClicked

    private void menuListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuListagemMouseClicked

    }//GEN-LAST:event_menuListagemMouseClicked

    private void listagemFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagemFuncionariosMouseClicked
        Report r = new Report() {
            @Override
            public HashMap getParameters() {
                return new HashMap();
            }

            @Override
            public String getPath() {
                return "/resources/reports/ListagemFuncionarios.jrxml";
            }

        };
        ReportManager rm = new ReportManager();

        try {
            rm.setDataBaseConnection(SistemaFarmacia.getInstance().getDataBaseManager().getConnection());
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
        rm.createReport(r);
    }//GEN-LAST:event_listagemFuncionariosMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        TelaRelatorioFuncionarios tela;
        try {
            tela = new TelaRelatorioFuncionarios();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void tabelaVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasMouseClicked
        try {
            TabelaVendas tela = new TabelaVendas();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_tabelaVendasMouseClicked

    private void tabelaProdMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdMMouseClicked
        try {
            TabelaProdutos tela = new TabelaProdutos();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }

    }//GEN-LAST:event_tabelaProdMMouseClicked

    private void tabelaClientesMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMMouseClicked

    }//GEN-LAST:event_tabelaClientesMMouseClicked

    private void menuCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCidadeMouseClicked
        TelaCadastroCidade tela;
        try {
            tela = new TelaCadastroCidade();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_menuCidadeMouseClicked

    private void menuCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCategoriaMouseClicked
        TelaCadastroCategoria tela = new TelaCadastroCategoria();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCategoriaMouseClicked

    private void menuRelatorioVendaCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRelatorioVendaCidadeMouseClicked
        TabelaCidades tela;
        try {
            tela = new TabelaCidades();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }

    }//GEN-LAST:event_menuRelatorioVendaCidadeMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void menuMaisVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMaisVendidosMouseClicked

        int max = Entrada.leiaInt("Informe a quantidade de produtos a ser mostrada");
        if (max <= 0) {
            Warning w = new Warning("Favor informar um número maior que zero.");
            w.setVisible(true);
        } else {
            RelatorioMaisVendidos relatorio = new RelatorioMaisVendidos(max);
            SistemaFarmacia.getInstance().getReportManager().createReport(relatorio);
        }
    }//GEN-LAST:event_menuMaisVendidosMouseClicked

    private void menuPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPagamentoMouseClicked
        TelaCadastroPagamento tela = new TelaCadastroPagamento();
        tela.setVisible(true);
        pagamentoBox.removeAllItems();
        try {
            pagamentos = pagamentoDao.readAll();
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
        for (Pagamento pagamento : pagamentos) {
            pagamentoBox.addItem(pagamento.getNome());
        }
    }//GEN-LAST:event_menuPagamentoMouseClicked

    private void vendasUfMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendasUfMenuMouseClicked
        try {
            TelaEscolhaUf tela = new TelaEscolhaUf();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_vendasUfMenuMouseClicked

    private void pagamentoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pagamentoBoxItemStateChanged
        pagamentoBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().toString().equals("Dinheiro")) {
                        change.setVisible(true);
                        changeT.setVisible(true);
                        received.setVisible(true);
                        receivedT.setVisible(true);
                    }
                    if (!e.getItem().toString().equals("Dinheiro")) {
                        change.setVisible(false);
                        changeT.setVisible(false);
                        received.setVisible(false);
                        receivedT.setVisible(false);
                    }
                }
            }
        });
    }//GEN-LAST:event_pagamentoBoxItemStateChanged

    private void pagamentoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoBoxActionPerformed

    }//GEN-LAST:event_pagamentoBoxActionPerformed

    private void receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedActionPerformed

    }//GEN-LAST:event_receivedActionPerformed

    private void receivedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedFocusLost

        double troco = received.getDouble() - valorFinal.getDouble();
        if (troco >= 0) {
            change.setDouble(troco);
        }
    }//GEN-LAST:event_receivedFocusLost

    private void receivedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedFocusGained
        double troco = received.getDouble() - valorFinal.getDouble();
        if (troco >= 0) {
            change.setDouble(troco);
        }
    }//GEN-LAST:event_receivedFocusGained


    private void receivedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_receivedPropertyChange
        double troco = received.getDouble() - valorFinal.getDouble();
        if (troco >= 0) {
            change.setDouble(troco);
        }
    }//GEN-LAST:event_receivedPropertyChange

    private void receivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receivedKeyTyped
//
//        double recebido = received.getDouble();
//        double vFinal = valorFinal.getDouble();
//        for ( char i = '0'; i <= '9';) {
//            if (evt.getKeyChar() == i) {
//                double troco = recebido - vFinal;
//                if (troco >= 0) {
//                    change.setDouble(troco);
//                }
//                else{
//                }
//                i++;
//            }
//            else{
//                i++;
//            }
//        }
    }//GEN-LAST:event_receivedKeyTyped

    private void valorDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontoFocusLost
        double desc = Double.parseDouble(valorDesconto.getText()) / 100;
        double novo = valorFinal.getDouble() * desc;
        valorFinal.setDouble(valorFinal.getDouble() - novo);
    }//GEN-LAST:event_valorDescontoFocusLost

    private void menuComprarEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComprarEstoqueMouseClicked
        try {
            TelaCompraEstoque tela = new TelaCompraEstoque(funcionario);
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_menuComprarEstoqueMouseClicked

    private void menuFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFabricanteActionPerformed

    }//GEN-LAST:event_menuFabricanteActionPerformed

    private void menuFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFabricanteMouseClicked
        TelaCadastroFabricante tela = new TelaCadastroFabricante();
        tela.setVisible(true);
    }//GEN-LAST:event_menuFabricanteMouseClicked

    private void menuRelatorioFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRelatorioFabricanteMouseClicked
        try {
            TelaEscolhaVendidosFab tela = new TelaEscolhaVendidosFab();
            tela.setVisible(true);
        } catch (DataBaseException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
    }//GEN-LAST:event_menuRelatorioFabricanteMouseClicked

    private void menuJornadaCPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuJornadaCPFMouseClicked
        TelaJornadaCpf tela = new TelaJornadaCpf();
        tela.setVisible(true);
    }//GEN-LAST:event_menuJornadaCPFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton addProduto;
    private br.univates.system32.components.JMyCurrencyField change;
    private javax.swing.JLabel changeT;
    private br.univates.system32.components.JMyNumberField codProdF;
    private javax.swing.JButton confirm;
    private br.univates.system32.components.JMyCpfField cpfF;
    private javax.swing.JRadioButton descontoF;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JMenu jRelatorioClientes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenu listagemClientes;
    private javax.swing.JMenu listagemFuncionarios;
    private javax.swing.JMenu menuCategoria;
    private javax.swing.JMenu menuCidade;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuCliente1;
    private javax.swing.JMenu menuComprarEstoque;
    private javax.swing.JMenu menuFabricante;
    private javax.swing.JMenu menuFunc;
    private javax.swing.JMenu menuFuncao;
    private javax.swing.JMenu menuJornadaCPF;
    private javax.swing.JMenu menuJornadaData;
    private javax.swing.JMenu menuJornadaHoje;
    private javax.swing.JMenu menuListagem;
    private javax.swing.JMenu menuMaisVendidos;
    private javax.swing.JMenu menuPagamento;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuRelatorioFabricante;
    private javax.swing.JMenu menuRelatorioVendaCidade;
    private javax.swing.JMenu menuSetor;
    private javax.swing.JMenu menuTabela;
    private javax.swing.JComboBox<String> pagamentoBox;
    private br.univates.system32.components.JMyNumberField quantidade;
    private br.univates.system32.components.JMyCurrencyField received;
    private javax.swing.JLabel receivedT;
    private javax.swing.JTable tabela;
    private javax.swing.JMenu tabelaClientesM;
    private javax.swing.JMenu tabelaProdM;
    private javax.swing.JMenu tabelaVendas;
    private br.univates.system32.components.JMyNumberField valorDesconto;
    private br.univates.system32.components.JMyCurrencyField valorFinal;
    private javax.swing.JMenu vendasUfMenu;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
