package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Jornada;
import negocio.Pagamento;

public class JornadaDaoSQL implements JornadaDao {

    private DataBaseConnectionManager dbm;

    public JornadaDaoSQL() {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Jornada jor) throws DataBaseException, DuplicateKeyException {
        if (jor != null) {
            String sql = "insert into jornada values('" + jor.getInicio() + "' ,'" + jor.getFim() + "', " + jor.getCpf() + ", '" + jor.getNome() + "');";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Jornada nula");
        }
    }

    @Override
    public void edit(Jornada entity) throws DataBaseException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Jornada entity) throws DataBaseException {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jornada read(long id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Jornada readData(String data) throws DataBaseException {
        Jornada j = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from jornada where jornada.inicio between" + data + " and " + data + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                String inicio = rs.getString("inicio");
                String nome = rs.getString("nome");
                long cpf = rs.getLong("cpf");
                String fim = rs.getString("final");
                j = new Jornada(inicio, fim, cpf, nome);
            }
            return j;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    public ArrayList<Jornada> readFuncionario(long cpf, String inicial, String fim) throws DataBaseException {
        ArrayList<Jornada> jornadas = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from jornada where jornada.inicio between '" + inicial + "' and '" + fim + "'" + "and cpf=" + cpf + ");");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String inicio = rs.getString("inicio");
                    String nome = rs.getString("nome");
                    long cpfF = rs.getLong("cpf");
                    String fimD = rs.getString("final");
                    Jornada j = new Jornada(inicio, fimD, cpfF, nome);
                    jornadas.add(j);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return jornadas;
    }


@Override
public ArrayList<Jornada> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
public ArrayList<Jornada> readAll() throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
