package Executar;
public class Estoque {

    private Produtos Produto;
    private String id;
    private int quantidade;

    public Estoque(String id, Produtos produto, int quantidade) {
        Produto = produto;
        this.id = id;
        this.quantidade = quantidade;
    }


    public Produtos getProduto() {
        return Produto;
    }

    public void setProduto(Produtos produto) {
        Produto = produto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}