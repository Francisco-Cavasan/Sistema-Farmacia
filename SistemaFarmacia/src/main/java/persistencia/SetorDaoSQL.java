package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.SistemaFarmacia;

import negocio.Setor;

public class SetorDaoSQL implements SetorDao {

    private DataBaseConnectionManager dbm;

    public SetorDaoSQL() throws DataBaseException {
     
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();}

    @Override
    public void create(Setor setor) throws DataBaseException, DuplicateKeyException {
        if (setor != null) {
            String sql = "insert into setor values(" + setor.getCodigo() + " ,' " + setor.getDescricao() + "'); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Setor nulo");
        }
    }

    @Override
    public void edit(Setor setor) throws DataBaseException {

        if (setor != null) {
            String sql = "update setor set descricao='" + setor.getDescricao() + " ' where setor.codigo= " + setor.getCodigo() + "; ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Setor nulo");
        }
    }

    @Override
    public void delete(Setor setor) throws DataBaseException {
        if (setor != null) {
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
            String sql = "delete from funcao where funcao.codigo=" + setor.getCodigo();
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Setor nulo");
        }
        }
    }

    @Override
    public Setor read(long id) throws DataBaseException {
        Setor s = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from setor where setor.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String desc = rs.getString("descricao");
                s = new Setor(codigo, desc);
            }
            return s;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Setor> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Setor> readAll() throws DataBaseException {
        ArrayList<Setor> setor = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from setor;");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String desc = rs.getString("descricao");
                    Setor s = new Setor(codigo, desc);
                    setor.add(s);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return setor;
    }

}
