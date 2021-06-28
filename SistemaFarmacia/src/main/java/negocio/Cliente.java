
package negocio;


public class Cliente {
    
    private String nome;
    private long CPF;
    private String telefone;
    private String email;
    private String dataCadastro;
    private String sexo;
    private int codCity;

    public Cliente(String nome, long CPF, String telefone, String email, String dataCadastro, String sexo, int codCity) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.sexo = sexo;
        this.codCity = codCity;
    }

    public Cliente(String nome, long CPF, String telefone, String dataCadastro, String sexo, int codCity) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.sexo = sexo;
        this.codCity = codCity;
    }

    public int getCodCity() {
        return codCity;
    }

    public void setCodCity(int codCity) {
        this.codCity = codCity;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
