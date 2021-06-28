
package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;


public class RelatorioVendasUf implements Report {
    
    private int uf;
    
    public RelatorioVendasUf(int uf){
        this.uf = uf;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    @Override
    public HashMap getParameters() {
       HashMap map = new HashMap();
       map.put("UF", uf);
       return map;
    }

    @Override
    public String getPath() {
       return "/resources/reports/RelatorioVendasEstado.jrxml";
    }
    
}
