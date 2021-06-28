package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;

public class RelatorioItensVenda implements Report {
    
    int idVenda;

    public RelatorioItensVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
   
    @Override
    public HashMap getParameters() {
        HashMap map = new HashMap();
        map.put("idVenda", idVenda);
        return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatorioItensVenda.jrxml";
    }
    
}
