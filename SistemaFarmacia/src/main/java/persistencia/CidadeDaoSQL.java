package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Cidade;

public class CidadeDaoSQL implements CidadeDao {

    private DataBaseConnectionManager dbm;

    public CidadeDaoSQL() {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Cidade cidade) throws DataBaseException, DuplicateKeyException {
        if (cidade != null) {
            String sql = "insert into cidades values(" + cidade.getId() + ",  '" + cidade.getNome().trim() + "', "+cidade.getUf() +");";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Cidade nula");
        }
    }

    @Override
    public void edit(Cidade cidade) throws DataBaseException {
        if (cidade != null) {
            String sql = "update cidades set nome='" + cidade.getNome().trim() + "';";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Cidade nula");
        }
    }

    @Override
    public void delete(Cidade cidade) throws DataBaseException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade read(long id) throws DataBaseException {
        Cidade cidade = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from cidades where cidades.id=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int cod = rs.getInt("id");
                String nome = rs.getString("nome");
                int uf = rs.getInt("uf");
                cidade = new Cidade(cod, nome,uf);
            }
            return cidade;
        } catch (SQLException ex) {
            throw new DataBaseException("Cidade nula");
        }
    }

    @Override
    public ArrayList<Cidade> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> readAll() throws DataBaseException {
        ArrayList<Cidade> cidades = new ArrayList();
        try {
            String sql = "select * from cidades;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int uf = rs.getInt("uf");
                    Cidade c = new Cidade(id, nome,uf);
                    cidades.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return cidades;
    }
}
