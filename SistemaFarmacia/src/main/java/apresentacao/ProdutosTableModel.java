package apresentacao;

import br.univates.system32.db.DataBaseException;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Fabricante;
import negocio.Produto;
import persistencia.FabricanteDaoSQL;

public class ProdutosTableModel implements TableModel {

    private ArrayList<Produto> produtos;
    private FabricanteDaoSQL dao;
    private ArrayList<Fabricante> fabricantes;

    public ProdutosTableModel(ArrayList<Produto> produtos) throws DataBaseException {
        this.produtos = produtos;
        dao = new FabricanteDaoSQL();
        fabricantes = dao.readAll();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] vet = {"Código", "Nome", "Fabricante", "Quantidade", "Valor"};
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
        Produto aux = produtos.get(rowIndex);
        String fab = "";
        for (Fabricante fabricante : fabricantes) {
            if(fabricante.getCodigo() == aux.getFabricante()){
                fab = fabricante.getNome();
            }
        }
        Object[] vet = {aux.getCodigo(), aux.getNome(), fab, aux.getQuantidade(), aux.getValor()};
        return vet[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
