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

import negocio.Produto;

public class ProdutoDaoSQL implements ProdutoDao {

    private DataBaseConnectionManager dbm;

    public ProdutoDaoSQL() throws DataBaseException {
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Produto produto) throws DataBaseException, DuplicateKeyException {
        if (produto != null) {
            String sql = "insert into produto values(" + produto.getCodigo() + ", '" + produto.getNome().trim() + "', " + produto.getQuantidade() + ", '" + produto.getDescricao() + "', " + produto.getValor() + ", " + produto.getCategoria() + ", " + produto.getFabricante() + ");";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Produto nulo");
        }
    }

    @Override
    public void edit(Produto produto) throws DataBaseException {
        if (produto != null) {
            String sql = "update produto set nome='" + produto.getNome() + "', fabricante=" + produto.getFabricante() + ", quantidade=" + produto.getQuantidade() + ", descricao='" + produto.getDescricao() + "', valor=" + produto.getValor() + ",categoria=" + produto.getCategoria() + " where produto.codigo=" + produto.getCodigo() + ";";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Produto nulo");
        }
    }

    public void editStock(Produto produto) throws DataBaseException {
        if (produto != null) {
            String sql = "update produto set quantidade=" + produto.getQuantidade() + "where produto.codigo=" + produto.getCodigo() + ";";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Produto nulo");
        }
    }

    @Override
    public void delete(Produto produto) throws DataBaseException {
        if (produto != null) {
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
                String sql = "delete from produto where codigo=" + produto.getCodigo();
                dbm.runSQL(sql);
            } else {
                throw new DataBaseException("Produto nulo");
            }
        }
    }

    public ArrayList<Produto> readCodName(int cod, String nome) throws DataBaseException {
        ArrayList<Produto> prods = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from produto where produto.codigo=" + cod + " and nome= '" + nome + "';");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String name = rs.getString("nome");
                int fabricante = rs.getInt("fabricante");
                String quantidade = rs.getString("quantidade");
                String descricao = rs.getString("descricao");
                Double valor = rs.getDouble("valor");
                int categoria = rs.getInt("categoria");
                if (!descricao.isBlank()) {
                    Produto p = new Produto(codigo, name, fabricante, quantidade, valor, descricao, categoria);
                    prods.add(p);
                } else {
                    Produto p = new Produto(codigo, name, fabricante, quantidade, valor, categoria);
                    prods.add(p);
                }
            }
            return prods;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    public ArrayList<Produto> readEvery(int cod, String nome, double value, int quant, int cat) throws DataBaseException {
        ArrayList<Produto> prods = new ArrayList();
        try {
            ResultSet rs = dbm.runQuerySQL("select * from produto where produto.codigo=" + cod + "and nome='" + nome + "'and valor= "
                    + value + "and quantidade=" + quant + "and categoria=" + cat + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String name = rs.getString("nome");
                int fabricante = rs.getInt("fabricante");
                String quantidade = rs.getString("quantidade");
                String descricao = rs.getString("descricao");
                Double valor = rs.getDouble("valor");
                int categoria = rs.getInt("categoria");
                if (!descricao.isBlank()) {
                    Produto p = new Produto(codigo, name, fabricante, quantidade, valor, descricao, categoria);
                    prods.add(p);
                } else {
                    Produto p = new Produto(codigo, name, fabricante, quantidade, valor, categoria);
                    prods.add(p);
                }
            }
            return prods;
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public Produto read(long id) throws DataBaseException {
        Produto prod = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from produto where produto.codigo=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                int fabricante = rs.getInt("fabricante");
                String quantidade = rs.getString("quantidade");
                String descricao = rs.getString("descricao");
                Double valor = rs.getDouble("valor");
                int categoria = rs.getInt("categoria");
                if (!descricao.isBlank()) {
                    prod = new Produto(codigo, nome, fabricante, quantidade, valor, descricao, categoria);
                } else {
                    prod = new Produto(codigo, nome, fabricante, quantidade, valor, categoria);
                }
            }
            return prod;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Produto> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> readAll() throws DataBaseException {
        ArrayList<Produto> prods = new ArrayList();
        try {
            String sql = "select * from produto;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    int fabricante = rs.getInt("fabricante");
                    String quantidade = rs.getString("quantidade");
                    String descricao = rs.getString("descricao");
                    Double valor = rs.getDouble("valor");
                    int categoria = rs.getInt("categoria");
                    Produto p = new Produto(codigo, nome, fabricante, quantidade, valor, descricao, categoria);
                    prods.add(p);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return prods;
    }

}
