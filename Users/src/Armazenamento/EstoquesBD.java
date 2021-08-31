package Armazenamento;
import Executar.Estoque;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoquesBD {
    private Map<String, Estoque> estoquesBd  = new HashMap();

    public Map<String, Estoque> getEstoquesDbMap() {
        return estoquesBd;
    }
       public List<Estoque> getEstoques(){
        List<Estoque> estoquesList = new ArrayList<>();
        for(Map.Entry<String, Estoque> estoque : estoquesBd.entrySet()){
              estoquesList.add(estoque.getValue());
        }

        return estoquesList;
    }

    public void addEstoque(Estoque estoques){
      estoquesBd.put(estoques.getId(),estoques);

    }
}

