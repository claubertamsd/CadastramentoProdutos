package Armazenamento;
import Executar.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuariosBD {
    private List<Usuario> usuarioList = new ArrayList<>();

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void addUsuario(Usuario usuario){
        int id = usuarioList.size() + 1;
        usuario.setId(id);
        usuarioList.add(usuario);
    }
    public void printList(){
        List<Usuario> print = usuarioList.stream().collect(Collectors.toList());
        System.out.println("------------------------------");
        print.forEach(l-> System.out.println(" |ID: "+ l.getId() + " \n |Nome do usuário:  "+ l.getNome()+ " " +
                "\n |Número de CPF : " + l.getCpf() + "\n |Idade :"+ l.getIdade() +
                "\n |Tipo da conta: " + l.getTipoUsuario() + "\n |Data " + l.getData() +
                "\n ------------------------------"));

    }


}
