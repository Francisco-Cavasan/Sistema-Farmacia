package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;


public class RelatorioMaisVendidos implements Report{
    
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public RelatorioMaisVendidos(int num) {
        this.num = num;
    }
   

    @Override
    public HashMap getParameters() {
       HashMap map = new HashMap();
       map.put("max", num);
       return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatorioMaisVendidos.jrxml";
    }
    
}
