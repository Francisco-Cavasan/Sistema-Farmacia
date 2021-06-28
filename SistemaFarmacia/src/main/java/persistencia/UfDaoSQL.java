
package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Uf;


public class UfDaoSQL implements UfDao{
    
      private DataBaseConnectionManager dbm;
      
      public UfDaoSQL(){
             this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
      }

    @Override
    public void create(Uf entity) throws DataBaseException, DuplicateKeyException {
      
    }

    @Override
    public void edit(Uf entity) throws DataBaseException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Uf entity) throws DataBaseException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Uf read(long id) throws DataBaseException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Uf> read(Filter filter) throws DataBaseException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Uf> readAll() throws DataBaseException {
       ArrayList<Uf> ufs = new ArrayList();
        try {
            String sql = "select * from uf;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    Uf f = new Uf(codigo, nome);
                    ufs.add(f);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return ufs;
    }
    }
    
