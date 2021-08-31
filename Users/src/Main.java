import Armazenamento.ProdutosBD;
import Armazenamento.UsuariosBD;
import Executar.Admin;
import Executar.Cliente;
import Armazenamento.EstoquesBD;
import Executar.Estoque;
import Executar.Produtos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao = 0;

        UsuariosBD usuariosBD = new UsuariosBD();
        ProdutosBD produtosBD = new ProdutosBD();
        EstoquesBD estoques = new EstoquesBD();

        do {
            System.out.println("...Menu...");
            System.out.println("1.| Cadastrar ADMINISTRADOR");
            System.out.println("2.| Cadastrar CLIENTE");
            System.out.println("3.| Usuarios Cadastrados");
            System.out.println("4.| Cadastrar Produto");
            System.out.println("5.| Cadastrar Estoques");
            System.out.println("6.| Estoques Cadastrados");
            System.out.println("7.| Produtos Cadastrados");

            Scanner ts = new Scanner(System.in);
            opcao = ts.nextInt();

            switch (opcao) {
                case 1: {
                    System.out.println("-------------------------------------------");
                    System.out.println("--------CADASTRADO DE ADMINISTADOR---------");
                    System.out.println("-------------------------------------------");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Digite o nome do ADMINISTRADOR: ");
                    String nome1 = scanner.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite a sua Idade:");
                    int idade = scanner.nextInt();

                    // Formatação da Data que será preenchida automáticamente
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String date = formatter.format(new Date());

                    // Formatação de CPF
                    if (cpf != null) {
                        cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                    } else {
                        System.out.println("CPF INVÁLIDO");
                        return;
                    }

                    Admin novoAdmin = new Admin(nome1, cpf, date, idade);
                    usuariosBD.addUsuario(novoAdmin);
                }
                    break;

                case 2: {
                    System.out.println("-------------------------------------------");
                    System.out.println("----------CADASTRADO DE CLIENTES-----------");
                    System.out.println("-------------------------------------------");

                    Scanner Cliente = new Scanner(System.in);
                    System.out.println("Digite o nome do CLIENTE: ");
                    String nomes = Cliente.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf1 = Cliente.nextLine();

                    System.out.println("Digite a sua Idade:");
                    int idade1 = Cliente.nextInt();

                    // Formatação da Data que será preenchida automáticamente
                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                    String data = formatter1.format(new Date());

                    // Formatação de CPF
                    if (cpf1 != null) {
                        cpf1 = cpf1.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                    } else {
                        System.out.println("CPF INVÁLIDO");
                        return;
                    }

                    Cliente cliente = new Cliente(nomes, cpf1, data, idade1);
                    usuariosBD.addUsuario(cliente);
                }

                    break;

                case 3:
                    usuariosBD.printList();
                    break;

                case 4: {
                    Scanner scanner = new Scanner(System.in);
                    Scanner teste = new Scanner(System.in);

                    System.out.println("-------------------------------------------");
                    System.out.println("----------CADASTRADO DE PRODUTOS-----------");
                    System.out.println("-------------------------------------------");

                    /*
                     * System.out.print("Digite a ID do produto:"); int id = scanner.nextInt();
                     */

                    System.out.println("Digite o nome do Produto:");
                    String nomeProduto = teste.nextLine();

                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                    String data = formatter2.format(new Date());

                    System.out.print("Qual o valor do Produto: ");
                    Double valor = scanner.nextDouble();

                    Produtos produtos = new Produtos(data, valor, nomeProduto);

                    produtosBD.addNovoProduto(produtos);
                }

                    break;

                case 5: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("-------------------------------------------");
                    System.out.println("----------CADASTRADO DE ESTOQUES-----------");
                    System.out.println("-------------------------------------------");

                    System.out.println("Digite a identificação do Estoque:");
                    String id = scanner.nextLine();

                    System.out.println("Qual produto que será adicionado ao estoque(informe o ID):");
                    int produtoId = scanner.nextInt();

                    Produtos produto = produtosBD.getProdutoPorId(produtoId);

                    System.out.println("PRODUTO ID :" + produto.getId());
                    System.out.println("PRODUTO DESCRIÇÃO:" + produto.getDescricao());
                    System.out.println("PRODUTO VALIDADE:" + produto.getData());
                    System.out.println("VALOR DO PRODUTO: " + produto.getPreco());

                    System.out.print("Qual a quantidade de produto a ser adicionado ao estoque:");
                    int quantidade = scanner.nextInt();

                    Estoque novo = new Estoque(id, produto, quantidade);
                    estoques.addEstoque(novo);


                }
                    break;

                case 6:
                    System.out.println("-------------------------------------------");
                    System.out.println("------------LISTA DE ESTOQUE---------------");
                    System.out.println("-------------------------------------------");
                    for (Estoque estoque : estoques.getEstoques()) {

                        System.out.println("ID :" + estoque.getId());
                        System.out.println("PRODUTO:" + estoque.getProduto().getDescricao());
                        System.out.println("PREÇO: " + estoque.getProduto().getPreco());
                        System.out.println("QUANTIDADE:" + estoque.getQuantidade());
                        System.out.println("-------------------------");
                    }

                    break;

                case 7:

                    System.out.println("-------------------------------------------");
                    System.out.println("------------LISTA DE PRODUTO---------------");
                    System.out.println("-------------------------------------------");

                    for (Produtos produtos : produtosBD.getProdutosList()) {
                        System.out.println("ID : " + produtos.getId());
                        System.out.println("PRODUTO: " + produtos.getDescricao());
                        System.out.println("PREÇO: " + produtos.getPreco());
                        System.out.println("DATA DO CADASTRO: " + produtos.getData());
                        System.out.println("-------------------------------------------");
                    }
                    break;
            }

        } while (opcao != 0);
    }
}
