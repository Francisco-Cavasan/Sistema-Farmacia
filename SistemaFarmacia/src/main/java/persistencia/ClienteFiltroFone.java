/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import br.univates.system32.db.Filter;
import negocio.Cliente;


public class ClienteFiltroFone implements Filter<Cliente>{
    
    private String ddd;
    
    public ClienteFiltroFone(String ddd){
        this.ddd = ddd;
    }

    @Override
    public boolean isApproved(Cliente obj) {
        if(obj.getTelefone().startsWith(ddd)){
            return true;
        }
      return false;
    }
    
}
