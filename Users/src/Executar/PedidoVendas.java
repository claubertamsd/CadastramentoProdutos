package Executar;

public class PedidoVendas {
    private int id;
    private Estoque estoque;
    private Usuario usuarios ;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoVendas(Estoque estoque, Usuario usuarios, int quantidade) {
        this.estoque = estoque;
        this.usuarios = usuarios;
        this.quantidade = quantidade;
    }

//    public double valorTotalVendas(){
//        return quantidade * produtos.getPreco();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
}
