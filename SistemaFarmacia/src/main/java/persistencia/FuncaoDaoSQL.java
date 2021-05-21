package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Funcao;

public class FuncaoDaoSQL implements FuncaoDao {

    private DataBaseConnectionManager dbm;

    public FuncaoDaoSQL() throws DataBaseException {
      
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager(); }

    @Override
    public void create(Funcao funcao) throws DataBaseException, DuplicateKeyException {
        if (funcao != null) {
            String sql = "insert into funcao values(" + funcao.getCodigo() + " ,' " + funcao.getDescricao() + "'); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Função nula");
        }
    }

    @Override
    public void edit(Funcao funcao) throws DataBaseException {
        if (funcao != null) {
            String sql = "update funcao set descricao='" + funcao.getDescricao() + "' where funcao.codigo = " + funcao.getCodigo() + "; ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Função nula");
        }
    }

    @Override
    public void delete(Funcao funcao) throws DataBaseException {
        if (funcao != null) {
            String sql = "delete from funcao where funcao.codigo=" + funcao.getCodigo();
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Função nula");
        }
    }

    @Override
    public Funcao read(long id) throws DataBaseException {
        Funcao f = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from funcao where funcao.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String desc = rs.getString("descricao");
                f = new Funcao(codigo, desc);
            }
            return f;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Funcao> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcao> readAll() throws DataBaseException {
        ArrayList<Funcao> funcao = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from funcao;");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String desc = rs.getString("descricao");
                    Funcao f = new Funcao(codigo, desc);
                    funcao.add(f);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return funcao;
    }
}
