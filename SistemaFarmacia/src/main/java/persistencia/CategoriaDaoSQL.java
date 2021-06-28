
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
import negocio.Categoria;


public class CategoriaDaoSQL implements CategoriaDao{
    
    private DataBaseConnectionManager dbm;
    
    public CategoriaDaoSQL(){
          this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Categoria categoria) throws DataBaseException, DuplicateKeyException {
        if (categoria != null) {
            String sql = "insert into categoria values(" + categoria.getCodigo() + ",  '" + categoria.getNome() + "');";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Categoria nula");
        }
    }

    @Override
    public void edit(Categoria categoria) throws DataBaseException {
       if (categoria != null) {
            String sql = "update categoria set nome='" + categoria.getNome()+ ";";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Categoria nula");
        }
    }  

    @Override
    public void delete(Categoria categoria) throws DataBaseException {
       if (categoria != null) {
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
                String sql = "delete from categoria where categoria.id = " + categoria.getCodigo();
                dbm.runSQL(sql);
            } else {
                throw new DataBaseException("Cliente nulo");
            }    
       }
    }

    @Override
    public Categoria read(long id) throws DataBaseException {
       Categoria cat = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from categoria where categoria.id=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int cod = rs.getInt("id");
                String nome = rs.getString("nome");
                cat = new Categoria(cod, nome);
            }
            return cat;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } }

    @Override
    public ArrayList<Categoria> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> readAll() throws DataBaseException {
       ArrayList<Categoria> categorias = new ArrayList();
        try {
            String sql = "select * from categoria;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    Categoria c = new Categoria(id, nome);
                    categorias.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return categorias;
    } 
}   

