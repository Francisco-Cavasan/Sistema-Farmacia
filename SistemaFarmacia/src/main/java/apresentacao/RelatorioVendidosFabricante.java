package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;


public class RelatorioVendidosFabricante implements Report{
    
    private int num;
    private int fabricante;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public RelatorioVendidosFabricante(int num, int fabricante) {
        this.num = num;
        this.fabricante = fabricante;
    }
   
    @Override
    public HashMap getParameters() {
       HashMap map = new HashMap();
       map.put("fabricante", fabricante);
       map.put("max", num);
       return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatorioVendasFabricante.jrxml";
    }
    
}
