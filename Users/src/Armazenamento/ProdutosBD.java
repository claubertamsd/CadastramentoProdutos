package Armazenamento;
import Executar.Produtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutosBD {
    private Map<Integer, Produtos> produtosList = new HashMap<>();

    public List<Produtos> getProdutosList() {
        List<Produtos> produtoss = new ArrayList<>();
        for(Map.Entry<Integer,Produtos> produto :produtosList.entrySet()){
            produtoss.add(produto.getValue());
        }
        return produtoss;
    }
    public void addNovoProduto(Produtos produto){
        int id = getProdutosList().size() + 1;
        produto.setId(id);
        produtosList.put(produto.getId(), produto);
    }
    public Produtos getProdutoPorId(int id ){
       return produtosList.get(id);

    }


}
