
package apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.ItemProduto;


public class ItensTableModel implements TableModel {

    private ArrayList<ItemProduto> itens;

    public ItensTableModel(ArrayList<ItemProduto> itens) {
        this.itens = itens;
    }

    
    public void addItem(ItemProduto item){
        itens.add(item);
    }
    public ArrayList<ItemProduto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemProduto> itens) {
        this.itens = itens;
    }
    
    @Override
    public int getRowCount() {
     return itens.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
       String[] vet = {"Código", "Nome", "Quantidade", "Valor"};
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
       ItemProduto aux = itens.get(rowIndex);
        Object[] vet = {aux.getCodigo(), aux.getNome(), aux.getQuantidade(), aux.getValor()};
        return vet[columnIndex]; 
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
