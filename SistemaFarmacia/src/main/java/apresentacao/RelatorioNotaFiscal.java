
package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;


public class RelatorioNotaFiscal implements Report{
    
    private int idvenda;
    
    public RelatorioNotaFiscal(int idvenda){
        this.idvenda = idvenda;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    @Override
    public HashMap getParameters() {
        HashMap map = new HashMap();
        map.put("idvenda", idvenda);
        return map;
    }

    @Override
    public String getPath() {
       return "/resources/reports/NotaFiscal.jrxml";
    }
    
}
