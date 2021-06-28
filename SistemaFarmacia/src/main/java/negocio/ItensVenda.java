
package negocio;


public class ItensVenda {
    
   private String idVenda;
   private int codProd;
   private int quantidade;
   private double valor;
   private double desconto;
   
    public ItensVenda(String idVenda, int codProd, int quantidade, double valor) {
        this.idVenda = idVenda;
        this.codProd = codProd;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    public ItensVenda(String idVenda, int codProd, int quantidade, double valor, double desconto) {
        this.idVenda = idVenda;
        this.codProd = codProd;
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
   

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
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
   
   
    
    
}
