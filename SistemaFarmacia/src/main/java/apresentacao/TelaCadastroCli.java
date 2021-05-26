package apresentacao;

import br.univates.system32.Formatacao;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import negocio.Cliente;
import persistencia.ClienteDaoSQL;

public class TelaCadastroCli extends javax.swing.JFrame {
    
    ClienteDaoSQL dao;
    private Cliente cliente;
    
    public TelaCadastroCli() throws DataBaseException {
        initComponents();
        dao = new ClienteDaoSQL();
        ArrayList<Cliente> clientes = dao.readAll();
        clientes = dao.readAll();
        ClientesTableModel tm = new ClientesTableModel(clientes);
        tabela.setModel(tm);
        sexoF.removeAllItems();
        sexoF.addItem("m");
        sexoF.addItem("f");
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabela.getSelectedRow();
                
                if (row >= 0) {
                    ClientesTableModel tableModel = (ClientesTableModel) tabela.getModel();
                    cliente = tableModel.getClientes().get(tabela.getSelectedRow());
                    cpfF2.setText((Long.toString(cliente.getCPF())));
                    nomeF2.setText(cliente.getNome());
                    emailF.setText(cliente.getEmail());
                    telefone.setText(cliente.getTelefone());
                    sexoF.setSelectedItem(cliente.getSexo());
                }
            }
        });
        
        tabela.getSelectionModel().setSelectionInterval(0, 0);
        
    }
    
    public void atualizarTabela() {
        ArrayList<Cliente> clientesS = new ArrayList();
        try {
            ClienteDaoSQL daoS = new ClienteDaoSQL();
            clientesS = daoS.readAll();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
        ClientesTableModel tm = (ClientesTableModel) tabela.getModel();
        tm.setClientes(clientesS);
        tabela.revalidate();
        tabela.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nomeF2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cpfF2 = new br.univates.system32.components.JMyCpfField();
        telefone = new br.univates.system32.components.JMyFoneField();
        emailF = new javax.swing.JTextField();
        sexoF = new javax.swing.JComboBox<>();
        register = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        novo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Sexo");

        jLabel3.setText("Nome");

        jLabel4.setText("Email");

        jLabel2.setText("CPF");

        jLabel27.setText("Telefone");

        sexoF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cpfF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailF)
                            .addComponent(nomeF2))))
                .addGap(119, 119, 119)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cpfF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(sexoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(emailF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        register.setText("Registrar");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Excluir");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)
                        .addGap(12, 12, 12)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(register)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(delete)
                    .addComponent(edit)
                    .addComponent(register)
                    .addComponent(novo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        String email = "";
        String temp = cpfF2.getText().replace(".", "");
        temp = temp.replace("-", "");
        long cpf = Long.parseLong(temp);
        String nome = nomeF2.getText();
        String fone = telefone.getText();
        String data = Formatacao.getDataAtual();
        String sexo = sexoF.getSelectedItem().toString();
        if (emailF.getText().isBlank()) {
            email = "";
        } else {
            email = emailF.getText();
        }
        if (temp.length() == 11 && !nome.isBlank() && !fone.isBlank()) {
            Cliente cliente = new Cliente(nome, cpf, fone, email, data, sexo);
            try {
                dao.create(cliente);
                atualizarTabela();
            } catch (DataBaseException | DuplicateKeyException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            Warning w = new Warning("Favor preencher todos os campos");
            w.setVisible(true);
        }
    }//GEN-LAST:event_registerActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String email = "";
        String temp = cpfF2.getText().replace(".", "");
        temp = temp.replace("-", "");
        long cpf = Long.parseLong(temp);
        String nome = nomeF2.getText();
        String fone = telefone.getText();
        String sexo = sexoF.getSelectedItem().toString();
        String data = Formatacao.getDataAtual();
        if (emailF.getText().isBlank()) {
            email = "";
        } else {
            email = emailF.getText();
        }
        if (temp.length() == 11 && !nome.isBlank() && !fone.isBlank()) {
            Cliente cliente = new Cliente(nome, cpf, fone, email, data, sexo);
            try {
                dao.edit(cliente);
                atualizarTabela();
            } catch (DataBaseException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            Warning w = new Warning("Favor preencher todos os campos");
            w.setVisible(true);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String email = "";
        String temp = cpfF2.getText().replace(".", "");
        temp = temp.replace("-", "");
        long cpf = Long.parseLong(temp);
        String nome = nomeF2.getText();
        String fone = telefone.getText();
        String sexo = sexoF.getSelectedItem().toString();
        String data = Formatacao.getDataAtual();
        if (emailF.getText().isBlank()) {
            email = "";
        } else {
            email = emailF.getText();
        }
        if (temp.length() == 11) {
            Cliente cliente = new Cliente(nome, cpf, fone, email, data, sexo);
            try {
                dao.delete(cliente);
                atualizarTabela();
            } catch (DataBaseException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            Warning w = new Warning("Favor preencher todos os campos");
            w.setVisible(true);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        cpfF2.setText("");
        nomeF2.setText("");
        emailF.setText("");
        telefone.setText("");
        sexoF.setSelectedItem("m");
    }//GEN-LAST:event_novoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private br.univates.system32.components.JMyCpfField cpfF2;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField emailF;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeF2;
    private javax.swing.JButton novo;
    private javax.swing.JButton register;
    private javax.swing.JComboBox<String> sexoF;
    private javax.swing.JTable tabela;
    private br.univates.system32.components.JMyFoneField telefone;
    // End of variables declaration//GEN-END:variables
}
