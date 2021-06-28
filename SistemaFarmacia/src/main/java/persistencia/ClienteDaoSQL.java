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
import negocio.Cliente;

public class ClienteDaoSQL implements ClienteDao {

    private DataBaseConnectionManager dbm;

    public ClienteDaoSQL() throws DataBaseException {
       
       
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Cliente cliente) throws DataBaseException, DuplicateKeyException {
        if (cliente != null) {
            String sql = "insert into cliente values(" + cliente.getCPF() + ",  '" + cliente.getNome().trim() + "' , '"
                    + cliente.getTelefone() + "', '"
                    + cliente.getEmail().trim() + "', '"
                    + cliente.getDataCadastro() + "', '"
                    + cliente.getSexo().trim() + "',  '" + cliente.getCodCity() + "');";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Cliente nulo");
        }
    }

    @Override
    public void edit(Cliente cliente) throws DataBaseException {
        if (cliente != null) {
            String sql = "update cliente set nome='" + cliente.getNome().trim() + "' ,telefone= '"
                    + cliente.getTelefone() + "',email= '"
                    + cliente.getEmail().trim() + "', data_cadastro='"
                    + cliente.getDataCadastro() + "', sexo= '"
                    + cliente.getSexo() + "',cidade='"+ cliente.getCodCity() + "' where cliente.cpf = " + cliente.getCPF() + ";";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Cliente nulo");
        }
    }

    @Override
    public void delete(Cliente cliente) throws DataBaseException {
        if (cliente != null) {
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
                String sql = "delete from cliente where cliente.cpf = " + cliente.getCPF();
                dbm.runSQL(sql);

            } else {
                throw new DataBaseException("Cliente nulo");
            }
        }
    }

    @Override
    public Cliente read(long id) throws DataBaseException {
        Cliente cliente = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from cliente where cliente.cpf=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                long cpf = rs.getLong("CPF");
                String nome = rs.getString("nome");
                String telefone = rs.getString("cliente");
                String email = rs.getString("email");
                String data = rs.getString("data_cadastro");
                String sexo = rs.getString("sexo");
                int codCity = rs.getInt("cidade");
                cliente = new Cliente(nome, cpf, telefone, email, data, sexo, codCity);
            }
            return cliente;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Cliente> read(Filter filter) throws DataBaseException {
         ArrayList<Cliente> clienteFiltro = new ArrayList();
          ArrayList<Cliente> clientes = this.readAll();
          for(Cliente cliente : clientes){
              if(filter.isApproved(cliente)){
                  clienteFiltro.add(cliente);
              }
          }
          return clienteFiltro;
    }

    @Override
    public ArrayList<Cliente> readAll() throws DataBaseException {
        ArrayList<Cliente> cliente = new ArrayList();
        try {
            String sql = "select * from cliente;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpf = rs.getLong("cpf");
                    String nome = rs.getString("nome");
                    String telefone = rs.getString("telefone");
                    String email = rs.getString("email");
                    String data = rs.getString("data_cadastro");
                    String sexo = rs.getString("sexo");
                    int codCity = rs.getInt("cidade");
                    Cliente c = new Cliente(nome, cpf, telefone, email, data, sexo, codCity);
                    cliente.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return cliente;
    }

}
