package apresentacao;

import br.univates.system32.db.DataBaseException;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import main.SistemaFarmacia;

import negocio.Venda;
import persistencia.VendaDaoSQL;

public class TabelaVendas extends javax.swing.JFrame {

    private VendaDaoSQL vendaDao;
    private Venda venda;
    private ArrayList<Venda> vendas;

    public TabelaVendas() throws DataBaseException {
        initComponents();
         this.setLocationRelativeTo(null);
        tabela.clearSelection();
        vendas = new ArrayList();
        vendaDao = new VendaDaoSQL();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/images/icone.png")));
        ArrayList<Venda> vendasAr = vendaDao.readAll();
        VendasTableModel tm = new VendasTableModel(vendasAr);
        tabela.setModel(tm);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    VendasTableModel tableModel = (VendasTableModel) tabela.getModel();
                    venda = tableModel.getVendas().get(tabela.getSelectedRow());
                    idVendaF.setText(venda.getIdVenda());
                    cpfFunc.setText(Long.toString(venda.getCpfFunc()));
                    cpfCliente.setText(Long.toString(venda.getCpfCli()));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        details = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cpfFunc = new br.univates.system32.components.JMyCpfField();
        cpfCliente = new br.univates.system32.components.JMyCpfField();
        idVendaF = new br.univates.system32.components.JMyNumberField();
        locate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Vendas");

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

        details.setText("Abrir detalhes");
        details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsActionPerformed(evt);
            }
        });

        close.setText("Fechar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID da venda:");

        jLabel2.setText("CPF Funcionário:");

        jLabel3.setText("CPF Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idVendaF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idVendaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        locate.setText("Localizar");
        locate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(close)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(locate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(details))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close)
                    .addComponent(details)
                    .addComponent(locate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void locateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locateActionPerformed

        String idVenda = idVendaF.getText();
        String cpfCli = (cpfCliente.getText().replace(".", ""));
        cpfCli = cpfCli.replace("-", "");
        String cpfFuncionario = (cpfFunc.getText()).replace(".", "");
        cpfFuncionario = cpfFuncionario.replace("-", "");
        int stop = 0;
        while (stop != 1) {
            if (!idVenda.isEmpty()) {
                tabela.removeAll();
                try {
                    vendas.add(vendaDao.read(Long.parseLong(idVenda)));
                    VendasTableModel tm = (VendasTableModel) tabela.getModel();
                    tm.setVendas(vendas);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: "+ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else if (!cpfFuncionario.isBlank() && !cpfCli.isBlank()) {
                tabela.removeAll();
                try {
                    vendas = vendaDao.readCpfBoth(Long.parseLong(cpfCli), Long.parseLong(cpfFuncionario));
                    VendasTableModel tm = (VendasTableModel) tabela.getModel();
                    tm.setVendas(vendas);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: "+ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else if (!cpfCli.isBlank() && cpfFuncionario.isBlank()) {
                tabela.removeAll();
                try {
                    vendas = vendaDao.readCpfClie(Long.parseLong(cpfCli));
                    VendasTableModel tm = (VendasTableModel) tabela.getModel();
                    tm.setVendas(vendas);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: "+ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else if (!cpfFuncionario.isBlank() && cpfCli.isBlank()) {
                tabela.removeAll();
                try {
                    vendas = vendaDao.readCpfFunc(Long.parseLong(cpfFuncionario));
                    VendasTableModel tm = (VendasTableModel) tabela.getModel();
                    tm.setVendas(vendas);
                    tabela.revalidate();
                    tabela.repaint();
                    stop = 1;
                } catch (DataBaseException ex) {
                    Warning w = new Warning("Erro: "+ex.getMessage());
                    w.setVisible(true);
                    stop = 1;
                }
            } else {
                Warning w = new Warning("Favor preencher os campos corretamente");
                w.setVisible(true);
            }
        }
    }//GEN-LAST:event_locateActionPerformed

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsActionPerformed
        int tam = tabela.getColumnCount();
        if (tam > 0) {
            if(idVendaF.getText().isBlank()){
                Warning w = new Warning("Favor preencher os campos corretamente");
                w.setVisible(true);
            }
            else{
               RelatorioItensVenda relatorio = new RelatorioItensVenda((idVendaF.getInteger()));
            SistemaFarmacia.getInstance().getReportManager().createReport(relatorio); 
            }
        }

    }//GEN-LAST:event_detailsActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        dispose();
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private br.univates.system32.components.JMyCpfField cpfCliente;
    private br.univates.system32.components.JMyCpfField cpfFunc;
    private javax.swing.JButton details;
    private br.univates.system32.components.JMyNumberField idVendaF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton locate;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
