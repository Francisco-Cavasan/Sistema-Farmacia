
package negocio;

public class Venda {
    
    private String idVenda;
    private long cpfFunc;
    private long cpfCli;
    private String data;


    public Venda(String idVenda, long cpfFunc, long cpfCli, String data) {
       this.idVenda = idVenda;
        this.cpfFunc = cpfFunc;
        this.cpfCli = cpfCli;
        this.data = data;
    }

    public long getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(long cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public long getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
    
}
