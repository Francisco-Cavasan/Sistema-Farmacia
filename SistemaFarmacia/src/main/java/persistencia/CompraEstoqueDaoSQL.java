package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.CompraEstoque;

public class CompraEstoqueDaoSQL implements CompraEstoqueDao {

    private DataBaseConnectionManager dbm;

    public CompraEstoqueDaoSQL() throws DataBaseException {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(CompraEstoque compra) throws DataBaseException, DuplicateKeyException {
        if (compra != null) {
            String sql = "insert into compraestoque values(" + compra.getCodigo() + ", " + compra.getCodProd() + ", " + compra.getQuantidade() + ", " + compra.getValor() + ", " + compra.getCpfFunc() + ", " + compra.getFabricante() + ", '" + compra.getData() + "');";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Compra nula");
        }
    }

    @Override
    public void edit(CompraEstoque compra) throws DataBaseException {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CompraEstoque entity) throws DataBaseException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompraEstoque read(long id) throws DataBaseException {
        CompraEstoque compra = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from produto where produto.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                int codProd = rs.getInt("codProd");
                int quantidade = rs.getInt("quantidade");
                Double valor = rs.getDouble("valor");
                long cpf = rs.getLong("cpfFuncionario");
                int fabricante = rs.getInt("fabricante");
                String data = rs.getString("data");
                compra = new CompraEstoque(codigo, codProd, quantidade, valor, cpf, fabricante, data);
            }
            return compra;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<CompraEstoque> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompraEstoque> readAll() throws DataBaseException {
        ArrayList<CompraEstoque> compras = new ArrayList();
        try {
            String sql = "select * from compraestoque;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    int codProd = rs.getInt("codProd");
                    int quantidade = rs.getInt("quantidade");
                    Double valor = rs.getDouble("valor");
                    long cpf = rs.getLong("cpfFuncionario");
                    int fabricante = rs.getInt("fabricante");
                    String data = rs.getString("data");
                    CompraEstoque compra = new CompraEstoque(codigo, codProd, quantidade, valor, cpf, fabricante, data);
                    compras.add(compra);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return compras;
    }
}
