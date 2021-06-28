package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;

public class RelatorioClientes implements Report {

    private String nomeInicial;
    private String nomeFinal;
    private String sexo;
    private int cidade;

    public String getNomeInicial() {
        return nomeInicial;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public void setNomeInicial(String nomeInicial) {
        this.nomeInicial = nomeInicial;
    }

    public String getNomeFinal() {
        return nomeFinal;
    }

    public void setNomeFinal(String nomeFinal) {
        this.nomeFinal = nomeFinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public HashMap getParameters() {
HashMap map = new HashMap();

map.put("Sexo", sexo.toLowerCase());
map.put("Cidade", cidade);
map.put("nomeInicial", nomeInicial.trim());
map.put("nomeFinal", nomeFinal.trim()+"zzzzz");
return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatórioClientesSexo.jrxml";
    }

}
