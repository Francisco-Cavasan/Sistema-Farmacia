
package negocio;


public class Jornada {
    
    String inicio;
    String fim;
    long cpf;
    String nome;

    public Jornada(String inicio, String fim, long cpf, String nome) {
        this.inicio = inicio;
        this.fim = fim;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
