
package negocio;


public class Produto {

    private String nome;
    private int codigo;
    private String fabricante;
    private String quantidade;
    private String valor;
    private String descricao;

    public Produto(int codigo, String nome, String fabricante, String quantidade, String valor, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Produto(int codigo, String nome, String fabricante, String quantidade, String valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
