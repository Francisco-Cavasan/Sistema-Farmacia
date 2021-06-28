package persistencia;

import apresentacao.Warning;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Venda;

public class VendaDaoSQL implements VendaDao {

    private DataBaseConnectionManager dbm;

    public VendaDaoSQL() throws DataBaseException {

        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Venda venda) throws DataBaseException, DuplicateKeyException {
        if (venda != null) {
            String sql = "insert into vendas values(" + "default" + ",   " + venda.getCpfFunc() + "  ,  "
                    + venda.getCpfCli() + " ,  '"
                    + venda.getData() +"' ,  "+ venda.getPagamento() + " ); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Venda nula");
        }
    }

    @Override
    public void edit(Venda venda) throws DataBaseException {
        Warning w = new Warning("Não é possível alterar o registro de uma venda");
        w.setVisible(true);
    }

    @Override
    public void delete(Venda venda) throws DataBaseException {
        if (venda != null) {
                String sql = "delete from vendas where vendas.id_venda = " + venda.getIdVenda() + ";";
                dbm.runSQL(sql);
            } else {
                throw new DataBaseException("Venda nula");
            }
        }

    @Override
    public Venda read(long id) throws DataBaseException {
        Venda venda = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas where vendas.id_venda=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                long cpfFunc = rs.getLong("cpf_func");
                long cpfCli = rs.getLong("cpf_cli");
                String idVenda = Integer.toString(rs.getInt("id_venda"));
                String data = rs.getString("data");
                int pag = rs.getInt("pagamento");
                venda = new Venda(idVenda, cpfFunc, cpfCli, data, pag);
            }
            return venda;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
    
    public ArrayList<Venda> readCpfFunc(long id) throws DataBaseException{
    ArrayList<Venda> vendas = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas where vendas.cpf_func = " + id);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpfFunc = rs.getLong("cpf_func");
                    long cpfCli = rs.getLong("cpf_cli");
                    String idVenda = Integer.toString(rs.getInt("id_Venda"));
                    String data = rs.getString("data");
                    int pag = rs.getInt("pagamento");
                    Venda v = new Venda(idVenda, cpfFunc, cpfCli, data, pag);
                    vendas.add(v);
                }
            }
            return vendas;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
    
    public ArrayList<Venda> readCpfClie(long id) throws DataBaseException{
    ArrayList<Venda> vendas = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas where vendas.cpf_cli = " + id);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpfFunc = rs.getLong("cpf_func");
                    long cpfCli = rs.getLong("cpf_cli");
                    String idVenda = Integer.toString(rs.getInt("id_Venda"));
                    String data = rs.getString("data");
                    int pag = rs.getInt("pagamento");
                    Venda v = new Venda(idVenda, cpfFunc, cpfCli, data, pag);
                    vendas.add(v);
                }
            }
            return vendas;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
    
    public ArrayList<Venda> readCpfBoth(long cli, long func) throws DataBaseException{
    ArrayList<Venda> vendas = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas where vendas.cpf_cli = " + cli + " and vendas.cpf_func = " + func);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpfFunc = rs.getLong("cpf_func");
                    long cpfCli = rs.getLong("cpf_cli");
                    String idVenda = Integer.toString(rs.getInt("id_Venda"));
                    String data = rs.getString("data");
                    int pag = rs.getInt("pagamento");
                    Venda v = new Venda(idVenda, cpfFunc, cpfCli, data,pag);
                    vendas.add(v);
                }
            }
            return vendas;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Venda> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> readAll() throws DataBaseException {
        ArrayList<Venda> vendas = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpfFunc = rs.getLong("cpf_func");
                    long cpfCli = rs.getLong("cpf_cli");
                    String idVenda = Integer.toString(rs.getInt("id_Venda"));
                    String data = rs.getString("data");
                    int pag = rs.getInt("pagamento");
                    Venda v = new Venda(idVenda, cpfFunc, cpfCli, data,pag);
                    vendas.add(v);
                }
            }
            return vendas;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
}
