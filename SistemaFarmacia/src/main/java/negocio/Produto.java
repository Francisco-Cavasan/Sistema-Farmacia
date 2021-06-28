
package negocio;


public class Produto {

    private String nome;
    private int codigo;
    private int fabricante;
    private String quantidade;
    private Double valor;
    private String descricao;
    private int categoria;

    public Produto(int codigo, String nome, int fabricante, String quantidade, Double valor, String descricao, int categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Produto(int codigo, String nome, int fabricante, String quantidade, Double valor, int categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = null;
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
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

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
