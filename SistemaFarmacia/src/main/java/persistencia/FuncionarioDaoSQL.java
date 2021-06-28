package persistencia;

import apresentacao.Warning;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.SistemaFarmacia;
import negocio.Funcionario;

public class FuncionarioDaoSQL implements FuncionarioDao {

    private DataBaseConnectionManager dbm;

    public FuncionarioDaoSQL() throws DataBaseException {
       
        this.dbm = SistemaFarmacia.getInstance().getDataBaseManager();
    }

    @Override
    public void create(Funcionario func) throws DataBaseException, DuplicateKeyException {
        if (func != null) {
            String sql = "insert into funcionario values(" + func.getCPF() + ",  ' " + func.getNome().trim() + " ' , ' "
                    + func.getHash() + " ', ' "
                    + func.getDataNascimento() + " ', ' "
                    + func.getSetor() + " ', ' "
                    + func.getFuncao() + "', '"
                    + func.getDataAdmissao()
                    + " ', '" + func.getSexo().trim()
                    + "', " + func.getAdmin() + " ); ";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Funcionário nulo");
        }
    }

    @Override
    public void edit(Funcionario func) throws DataBaseException {
        if (func != null) {
            String sql = "update funcionario set nome='" + func.getNome() + "', nascimento='"
                    + func.getDataNascimento() + "', setor='"
                    + func.getSetor() + "', funcao='"
                    + func.getFuncao() + "', data_admissao='"
                    + func.getDataAdmissao()
                    + "', sexo='" + func.getSexo()
                    + "', admin='" + func.getAdmin()
                    + "' where cpf=" + func.getCPF() + ";";
            dbm.runSQL(sql);
        } else {
            throw new DataBaseException("Funcionário nulo");
        }
    }

    @Override
    public void delete(Funcionario func) throws DataBaseException {
        if (func != null) {
            String[] op = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Você confirma a exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, "Sim");
            if (x == 0) {
                String sql = "delete from funcionario where funcionario.cpf=" + func.getCPF();
                dbm.runSQL(sql);
            }

        } else {
            throw new DataBaseException("Funcionário nulo");
        }
    }

    @Override
    public Funcionario read(long id) throws DataBaseException {
        Funcionario func = null;
        try {
            ResultSet rs = dbm.runQuerySQL("select * from funcionario where funcionario.cpf=" + id + ";");
            if (rs.isBeforeFirst()) {
                rs.next();
                long cpf = rs.getLong("CPF");
                String nome = rs.getString("nome");
                String hash = rs.getString("hash");
                String nascimento = rs.getString("nascimento");
                String setor = rs.getString("setor");
                String funcao = rs.getString("funcao");
                String dataAdmissao = rs.getString("data_admissao");
                String sexo = rs.getString("sexo");
                boolean admin = rs.getBoolean("admin");
                func = new Funcionario(cpf, nome, hash, nascimento, setor, funcao, dataAdmissao, sexo, admin);
            }
            return func;

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Funcionario> read(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> readAll() throws DataBaseException {
        ArrayList<Funcionario> funcs = new ArrayList();
        try {
            String sql = "select * from funcionario;";
            ResultSet rs = dbm.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long cpf = rs.getLong("CPF");
                    String nome = rs.getString("nome");
                    String hash = rs.getString("hash");
                    String nascimento = rs.getString("nascimento");
                    String setor = rs.getString("setor");
                    String funcao = rs.getString("funcao");
                    String dataAdmissao = rs.getString("data_admissao");
                    String sexo = rs.getString("sexo");
                    boolean admin = rs.getBoolean("admin");
                    Funcionario f = new Funcionario(cpf, nome, hash, nascimento, setor, funcao, dataAdmissao, sexo, admin);
                    funcs.add(f);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return funcs;
    }

}
