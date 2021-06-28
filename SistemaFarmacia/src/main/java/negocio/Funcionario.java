package negocio;

public class Funcionario {
    
    private String nome;
    private long CPF;
    private String funcao;
    private String setor;
    private String dataNascimento;
    private String dataAdmissao;
    private boolean admin;
    private String sexo;
    private String hash;
   
    public Funcionario(long cpf, String nome, String hash, String dataNascimento, String setor, String funcao, String dataAdmissao, String sexo, boolean admin) {
        this.nome = nome;
        this.CPF = cpf;
        this.hash = hash;
        this.funcao = funcao;
        this.setor = setor;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.admin = admin;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHash() {
        return hash;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String datanascimento) {
        this.dataNascimento = datanascimento;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
