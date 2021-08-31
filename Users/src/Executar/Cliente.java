package Executar;

public class Cliente extends Usuario {

    public Cliente(String nome, String cpf , String data, int idade) {
        super(nome, TipoUsuario.CLIENTE, cpf, data, idade);
    }
}
