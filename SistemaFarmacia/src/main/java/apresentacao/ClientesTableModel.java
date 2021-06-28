package apresentacao;

import br.univates.system32.db.DataBaseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Cidade;
import negocio.Cliente;
import persistencia.CidadeDaoSQL;


public class ClientesTableModel implements TableModel{
    
    private ArrayList<Cliente> clientes;
    
    public ClientesTableModel( ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
      return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
     String[] vet = {"CPF", "Nome", "Telefone", "Email", "Data Criação",  "Sexo", "Cidade"};
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Cliente aux = clientes.get(rowIndex);
         CidadeDaoSQL dao = new CidadeDaoSQL();
         Cidade cidade = null;
        try {
            cidade = dao.read(aux.getCodCity());
        } catch (DataBaseException ex) {
          
        }
        Object[] vet = {aux.getCPF(), aux.getNome(), aux.getTelefone(), aux.getEmail(), aux.getDataCadastro(), aux.getSexo(), cidade.getNome()};
        return vet[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
