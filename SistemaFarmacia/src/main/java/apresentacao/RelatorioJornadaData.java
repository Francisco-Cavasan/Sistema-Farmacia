package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;

public class RelatorioJornadaData implements Report {
    
    private String dataInicial;
    private String dataFinal;

    public RelatorioJornadaData(String dataInicial, String dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    
    @Override
    public HashMap getParameters() {
       HashMap map = new HashMap();
       map.put("dataInicial",dataInicial);
       map.put("dataFinal",dataFinal);
       return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatorioJornadaData.jrxml";
    }
    
    
           
    
}
