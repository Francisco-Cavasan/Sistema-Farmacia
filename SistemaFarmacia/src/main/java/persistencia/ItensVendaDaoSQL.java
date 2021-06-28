package persistencia;

import apresentacao.Warning;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SistemaFarmacia;
import negocio.ItensVenda;

public class ItensVendaDaoSQL implements ItensVendaDao {

    private DataBaseConnectionManager dbm;

    public ItensVendaDaoSQL() throws DataBaseException {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(ItensVenda itens) throws DataBaseException, DuplicateKeyException {
        if (itens != null) {
            String sql = "insert into itensVenda values(" + itens.getIdVenda() + ", '" + itens.getCodProd() + "', '" + itens.getQuantidade() + "', '" + itens.getValor() + "', '"+ itens.getDesconto() + "');";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Itens nulos");
        }
    }

    @Override
    public void edit(ItensVenda itens) throws DataBaseException {
//       if (itens != null) {
//            String sql = "update itensVenda set (" + itens.getIdVenda() + ", ' " + itens.getCodProd() + " ', ' " + itens.getQuantidade() + " ', ' " + itens.getValor() + " ');";
//            dbm.runSQL(sql);
//        } else {
//            throw new DataBaseException("Itens nulos");
//        }
    }

    @Override
    public void delete(ItensVenda itens) throws DataBaseException {

    }

    @Override
    public ItensVenda read(long id) throws DataBaseException {
        ItensVenda itens = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from itensVenda where itensVenda.id_Venda=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
               String idVenda = Integer.toString(rs.getInt("id_Venda"));
                int codProd = rs.getInt("cod_prod");
                String quantidade = rs.getString("quantidade");
                String valor = rs.getString("valor");
                double desconto = rs.getDouble("desconto");
                    if(desconto > 0){
                         itens = new ItensVenda(idVenda, codProd, Integer.parseInt(quantidade), Integer.parseInt(valor), desconto); 
                    }
                    else{
                      itens = new ItensVenda(idVenda, codProd, Integer.parseInt(quantidade), Integer.parseInt(valor));  
                    }
            }
        } catch (SQLException ex) {
            Warning w = new Warning("Erro: " + ex.getMessage());
            w.setVisible(true);
        }
        return itens;
    }

    @Override
    public ArrayList<ItensVenda> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItensVenda> readAll() throws DataBaseException {
        ArrayList<ItensVenda> itens = new ArrayList();

        try {
            String sql = "select * from itensVenda;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String idVenda = Integer.toString(rs.getInt("id_Venda"));
                    int codProd = rs.getInt("cod_Prod");
                    String quantidade = rs.getString("quantidade");
                    String valor = rs.getString("valor");
                    double desconto = rs.getDouble("desconto");
                    ItensVenda i = null;
                    if(desconto > 0){
                         i = new ItensVenda(idVenda, codProd, Integer.parseInt(quantidade), Integer.parseInt(valor), desconto); 
                    }
                    else{
                      i = new ItensVenda(idVenda, codProd, Integer.parseInt(quantidade), Integer.parseInt(valor));  
                    }
                    itens.add(i);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return itens;
    }

}
