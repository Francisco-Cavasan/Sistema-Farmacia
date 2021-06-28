package negocio;

public class Categoria {

    private int codigo;
    private String nome;

    public Categoria(int codigo, String descricao) {
        this.codigo = codigo;
        this.nome = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
