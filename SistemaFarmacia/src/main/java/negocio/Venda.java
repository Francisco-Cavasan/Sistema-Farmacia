
package negocio;

public class Venda {
    
    private String idVenda;
    private long cpfFunc;
    private long cpfCli;
    private String data;
    private int pagamento;


    public Venda(String idVenda, long cpfFunc, long cpfCli, String data, int pagamento) {
       this.idVenda = idVenda;
        this.cpfFunc = cpfFunc;
        this.cpfCli = cpfCli;
        this.data = data;
        this.pagamento = pagamento;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
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
