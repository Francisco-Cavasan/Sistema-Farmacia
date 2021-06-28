package apresentacao;

import br.univates.system32.reports.Report;
import java.util.HashMap;

public class RelatorioFuncionarios implements Report {

    private String nomeInicial;
    private String nomeFinal;
    private String sexo;
    private String setor;
    private String funcao;
    private boolean setorExists;
    private boolean funcaoExists;

    public RelatorioFuncionarios() {
        setorExists = true;
        funcaoExists = true;
    }

    public String getNomeInicial() {
        return nomeInicial;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public boolean isSetorExists() {
        return setorExists;
    }

    public void setSetorExists(boolean setorExists) {
        this.setorExists = setorExists;
    }

    public boolean isFuncaoExists() {
        return funcaoExists;
    }

    public void setFuncaoExists(boolean funcaoExists) {
        this.funcaoExists = funcaoExists;
    }

    @Override
    public HashMap getParameters() {
        HashMap map = new HashMap();
        if (this.setorExists == true) {
            map.put("setor", "'" + setor.trim() + "'");
        } else {
            map.put("setor", "setor");
        }
        if (this.funcaoExists == true) {
            map.put("funcao", "'" + funcao.trim() + "'");
        } else {
            map.put("funcao", "funcao");
        }
        map.put("nomeInicial", nomeInicial.trim());
        map.put("nomeFinal", nomeFinal.trim() + "zzzzz");
        map.put("sexo", sexo.toLowerCase());
        return map;
    }

    @Override
    public String getPath() {
        return "/resources/reports/RelatórioFuncionários.jrxml";
    }

}
