
package persistencia;

import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.SistemaFarmacia;
import negocio.Pagamento;


public class PagamentoDaoSQL implements PagamentoDao{
    
        private DataBaseConnectionManager dbm;
        
        public PagamentoDaoSQL(){
             this.dbm = SistemaFarmacia.getInstance().getDataBaseManager(); 
        }
        
    @Override
    public void create(Pagamento pag) throws DataBaseException, DuplicateKeyException {
       if (pag != null) {
            String sql = "insert into pagamento values(" + pag.getCodigo() + " ,'" + pag.getNome().trim() + "'); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Forma de pagamento nula");
        }
    }

    @Override
    public void edit(Pagamento pag) throws DataBaseException {
      if (pag != null) {
            String sql = "update pagamento set nome='" + pag.getNome().trim() + "' where pagamento.codigo = " + pag.getCodigo() + "; ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Forma de pagamento nula");
        }
    }

    @Override
    public void delete(Pagamento pag) throws DataBaseException {
      if (pag != null) {
            String sql = "delete from pagamento where pagamento.codigo=" + pag.getCodigo();
            dbm.runSQL(sql);
        } else {
           throw new DataBaseException("Forma de pagamento nula");
        }
    }

    @Override
    public Pagamento read(long id) throws DataBaseException {
         Pagamento p = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from pagamento where pagamento.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                p = new Pagamento(codigo, nome);
            }
            return p;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Pagamento> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pagamento> readAll() throws DataBaseException {
         ArrayList<Pagamento> funcao = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from pagamento;");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    Pagamento p = new Pagamento(codigo, nome);
                    funcao.add(p);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return funcao;
    }
    
}
