
package negocio;


public class CompraEstoque {
    
    private int codigo;
    private int codProd;
    private int quantidade;
    private double valor;
    private long cpfFunc;
    private int fabricante;
    private String data;

    public CompraEstoque(int codigo, int codProd, int quantidade, double valor, long cpfFunc, int fabricante, String data) {
        this.codigo = codigo;
        this.codProd = codProd;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cpfFunc = cpfFunc;
        this.fabricante = fabricante;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
}
