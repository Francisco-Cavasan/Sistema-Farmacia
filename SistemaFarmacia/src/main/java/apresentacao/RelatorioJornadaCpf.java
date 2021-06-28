package apresentacao;

import br.univates.system32.reports.Report;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioJornadaCpf implements Report {

    private String dataInicialI;
    private String dataFinalI;
    private String dataInicialF;
    private String dataFinalF;
    private long cpf;

    public RelatorioJornadaCpf(String dataInicial, String dataFinal, long cpf) {
        this.dataInicialI = dataInicial;
        this.dataFinalI = dataFinal;
        this.cpf = cpf;
    }

    @Override
    public HashMap getParameters() {
        HashMap map = new HashMap();
        dataInicialI = dataInicialI.replace('/', '-') + " 00:00:00";
        dataInicialF = dataInicialI.replace('/', '-') + " 23:59:00";
        dataFinalI = dataFinalI.replace('/', '-') + " 00:00:00";
        dataFinalF = dataFinalI.replace('/', '-') + " 23:59:00";
        Date inicialI = null;
        Date inicialF = null;
        Date finalI = null;
        Date finalF= null; 
        String pattern = "dd-mm-yyyy HH:mm:ss";
        try {
            inicialI = new SimpleDateFormat(pattern).parse(dataInicialI);
            inicialF = new SimpleDateFormat(pattern).parse(dataInicialF);
            finalI = new SimpleDateFormat(pattern).parse(dataFinalI);
            finalF = new SimpleDateFormat(pattern).parse(dataFinalF);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioJornadaCpf.class.getName()).log(Level.SEVERE, null, ex);
        }

        map.put("dataInicialI",inicialI);
        map.put("dataInicialF",inicialF);
        map.put("dataFinalI",finalI);
        map.put("dataFinalF",finalF);
        map.put("cpf", cpf);
        return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatorioJornadaCpf.jrxml";
    }

}
