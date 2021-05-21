
package negocio;

public class Venda {
    
    private long cpfFunc;
    private long cpfCli;
    private int codProd;
    private double valor;
    private String data;
    private int quantidade;

    public Venda(long cpfFunc, long cpfCli, int codProd, double valor, String data, int quantidade) {
        this.cpfFunc = cpfFunc;
        this.cpfCli = cpfCli;
        this.codProd = codProd;
        this.valor = valor;
        this.data = data;
        this.quantidade = quantidade;
    }

    public long getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public long getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
