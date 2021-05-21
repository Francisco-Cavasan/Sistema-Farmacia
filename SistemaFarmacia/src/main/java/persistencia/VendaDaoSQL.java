package persistencia;

import apresentacao.Warning;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.SistemaFarmacia;
import negocio.Venda;

public class VendaDaoSQL implements VendaDao {

    private DataBaseConnectionManager dbm;

    public VendaDaoSQL() throws DataBaseException {
        
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager(); }

    @Override
    public void create(Venda venda) throws DataBaseException, DuplicateKeyException {
        if (venda != null) {
            String sql = "insert into vendas values(" + venda.getCpfFunc() + ",   " + venda.getCodProd() + "  ,  "
                    + venda.getCpfCli() + " ,  "
                    + venda.getValor() + " , ' "
                    + venda.getData() + " ',  "
                    + venda.getQuantidade() + " ); '";
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
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
                String sql = "delete from vendas where vendas.cpf_func=" + venda.getCpfFunc()
                        + " and vendas.id_prod=  " + venda.getCodProd()
                        + " and vendas.cpf_cli=  "
                        + venda.getCpfCli() + ";";
                dbm.runSQL(sql);
            } else {
                throw new DataBaseException("Venda nula");
            }
        }
    }

    @Override
    public Venda read(long id) throws DataBaseException {
        Venda venda = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from vendas where vendas.cpf_func=" + venda.getCpfFunc()
                    + " and vendas.id_prod=  " + venda.getCodProd()
                    + " and vendas.cpf_cli=  "
                    + venda.getCpfCli() + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                long cpfFunc = rs.getLong("cpf_func");
                long cpfCli = rs.getLong("cpf_cli");
                int codProd = rs.getInt("id_prod");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                int quantidade = rs.getInt("quantidade");
                venda = new Venda(cpfFunc, cpfCli, codProd, valor, data, quantidade);
            }
            return venda;

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
                    int codProd = rs.getInt("id_prod");
                    double valor = rs.getDouble("valor");
                    String data = rs.getString("data");
                    int quantidade = rs.getInt("quantidade");
                    Venda v = new Venda(cpfFunc, cpfCli, codProd, valor, data, quantidade);
                    vendas.add(v);
                }
            }
            return vendas;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
}
