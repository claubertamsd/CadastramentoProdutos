package Executar;

public class Admin extends Usuario {

    public Admin(String nome, String cpf, String data, int idade) {
        super(nome, TipoUsuario.ADMIN, cpf,data, idade);
    }
}
