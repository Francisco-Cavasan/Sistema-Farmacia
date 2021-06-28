/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import br.univates.system32.db.DataBaseException;


public class DaoFactory {
    
    public static ProdutoDao newProdutoDao() throws DataBaseException{
        return new ProdutoDaoSQL();
    }
     public static ClienteDaoSQL newClienteDao() throws DataBaseException{
        return new ClienteDaoSQL();
    }
      public static FuncionarioDaoSQL newFuncionarioDao() throws DataBaseException{
        return new FuncionarioDaoSQL();
    }
    
}
