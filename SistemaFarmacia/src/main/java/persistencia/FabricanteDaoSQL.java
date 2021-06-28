package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Fabricante;

public class FabricanteDaoSQL implements FabricanteDao {

    private DataBaseConnectionManager dbm;

    public FabricanteDaoSQL() {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Fabricante fab) throws DataBaseException, DuplicateKeyException {
        if (fab != null) {
            String sql = "insert into fabricante values(" + fab.getCodigo() + " ,'" + fab.getNome().trim() + "'); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Fabricante nulo");
        }
    }

    @Override
    public void edit(Fabricante fab) throws DataBaseException {
        if (fab != null) {
            String sql = "update fabricante set nome='" + fab.getNome().trim() + "' where fabricante.codigo = " + fab.getCodigo() + "; ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Fabricante nulo");
        }
    }

    @Override
    public void delete(Fabricante fab) throws DataBaseException {
        if (fab != null) {
            String sql = "delete from fabricante where fabricante.codigo=" + fab.getCodigo();
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Fabricante nulo");
        }
    }

    @Override
    public Fabricante read(long id) throws DataBaseException {
        Fabricante f = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from fabricante where fabricante.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                f = new Fabricante(codigo, nome);
            }
            return f;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Fabricante> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fabricante> readAll() throws DataBaseException {
        ArrayList<Fabricante> fabricantes = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from fabricante;");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    Fabricante f = new Fabricante(codigo, nome);
                    fabricantes.add(f);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return fabricantes;
    }
}
