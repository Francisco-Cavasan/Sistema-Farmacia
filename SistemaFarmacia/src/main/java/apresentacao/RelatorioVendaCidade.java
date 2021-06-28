
package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;


public class RelatorioVendaCidade implements Report {
    
    private int codigo;
    
    public RelatorioVendaCidade(int cod){
        this.codigo = cod;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
            

    @Override
    public HashMap getParameters() {
       HashMap map = new HashMap();
        map.put("Cidade", codigo);
        return map; 
    }

    @Override
    public String getPath() {
         return "/resources/reports/RelatorioVendasCidade.jrxml";
    }
    
}
