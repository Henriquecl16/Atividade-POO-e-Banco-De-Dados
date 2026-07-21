import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import dao.ClienteDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Pedido;
import modelos.Produto;

public class Main {

    public static void main(String[] args) {

        ProdutoDao dao = new ProdutoDao();
        ClienteDao dao1 = new ClienteDao();
        List<Pedido> pedidos = new ArrayList<Pedido>();

        Scanner teclado = new Scanner(System.in);

        int opcao = 0;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();

            switch (opcao) {

            case 1:

                int opcaoProduto;

                do {

                    System.out.println("\n===== PRODUTOS =====");
                    System.out.println("1 - Cadastrar Produto");
                    System.out.println("2 - Listar Produtos");
                    System.out.println("3 - Consultar Produto");
                    System.out.println("4 - Alterar Produto");
                    System.out.println("5 - Excluir Produto");
                    System.out.println("0 - Voltar");

                    System.out.print("Escolha uma opção: ");
                    opcaoProduto = teclado.nextInt();


                    switch (opcaoProduto) {

                    case 1:

                        teclado.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = teclado.nextLine();

                        System.out.print("Preço: ");
                        double preco = teclado.nextDouble();

                        System.out.print("Estoque: ");
                        int estoque = teclado.nextInt();


                        Produto produto = new Produto(descricao, preco, estoque);

                        dao.salvar(produto);

                        System.out.println("Produto cadastrado com sucesso!");

                        break;


                    case 2:

                        List<Produto> produtos = dao.consultar();


                        for (Produto p : produtos) {

                            System.out.println("----------------");
                            System.out.println("ID: " + p.getId());
                            System.out.println("Descrição: " + p.getDescricao());
                            System.out.println("Preço: " + p.getPreco());
                            System.out.println("Estoque: " + p.getEstoque());

                        }

                        break;


                    case 3:

                        System.out.print("Digite o ID do produto: ");
                        int id = teclado.nextInt();


                        Produto produtoConsultado = dao.consultar(id);


                        if (produtoConsultado != null) {

                            System.out.println("----------------");
                            System.out.println("ID: " + produtoConsultado.getId());
                            System.out.println("Descrição: " + produtoConsultado.getDescricao());
                            System.out.println("Preço: " + produtoConsultado.getPreco());
                            System.out.println("Estoque: " + produtoConsultado.getEstoque());

                        } else {

                            System.out.println("Produto não encontrado!");

                        }

                        break;


                    case 4:

                        System.out.print("Digite o ID do produto: ");
                        int idAlterar = teclado.nextInt();


                        Produto produtoAlterar = dao.consultar(idAlterar);


                        if (produtoAlterar != null) {

                            teclado.nextLine();


                            System.out.print("Nova descrição: ");
                            String descricaoNova = teclado.nextLine();


                            System.out.print("Novo preço: ");
                            double precoNovo = teclado.nextDouble();


                            System.out.print("Novo estoque: ");
                            int estoqueNovo = teclado.nextInt();



                            produtoAlterar.setDescricao(descricaoNova);
                            produtoAlterar.setPreco(precoNovo);
                            produtoAlterar.setEstoque(estoqueNovo);


                            dao.alterar(produtoAlterar);


                            System.out.println("Produto alterado com sucesso!");

                        } else {

                            System.out.println("Produto não encontrado!");

                        }

                        break;


                    case 5:

                        System.out.print("Digite o ID do produto: ");
                        int idExcluir = teclado.nextInt();


                        Produto produtoExcluir = dao.consultar(idExcluir);


                        if (produtoExcluir != null) {

                            dao.deletar(idExcluir);

                            System.out.println("Produto excluído com sucesso!");

                        } else {

                            System.out.println("Produto não encontrado!");

                        }

                        break;


                    case 0:

                        System.out.println("Voltando...");

                        break;


                    default:

                        System.out.println("Opção inválida!");

                    }


                } while (opcaoProduto != 0);


                break;



           


            case 2:

                int opcaoCliente;

                do {

                    System.out.println("\n===== CLIENTES =====");
                    System.out.println("1 - Cadastrar Cliente");
                    System.out.println("2 - Listar Clientes");
                    System.out.println("3 - Consultar Cliente");
                    System.out.println("4 - Alterar Cliente");
                    System.out.println("5 - Excluir Cliente");
                    System.out.println("0 - Voltar");

                    System.out.print("Escolha uma opção: ");
                    opcaoCliente = teclado.nextInt();


                    switch (opcaoCliente) {


                    case 1:

                        teclado.nextLine();

                        System.out.print("CPF: ");
                        String cpf = teclado.nextLine();

                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();

                        System.out.print("Email: ");
                        String email = teclado.nextLine();

                        System.out.print("Rua: ");
                        String rua = teclado.nextLine();

                        System.out.print("Número: ");
                        int numero = teclado.nextInt();

                        teclado.nextLine();

                        System.out.print("Bairro: ");
                        String bairro = teclado.nextLine();

                        System.out.print("CEP: ");
                        String cep = teclado.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = teclado.nextLine();

                        System.out.print("Estado: ");
                        String estado = teclado.nextLine();


                        Cliente cliente = new Cliente(
                                cpf,
                                nome,
                                email,
                                rua,
                                numero,
                                bairro,
                                cep,
                                cidade,
                                estado
                        );


                        Cliente retorno = dao1.salvar(cliente);


                        if (retorno != null) {

                            System.out.println("Cliente cadastrado com sucesso!");
                            System.out.println("ID do cliente: " + retorno.getId());

                        } else {

                            System.out.println("Erro ao cadastrar cliente!");

                        }

                        break;



                    case 2:

                        List<Cliente> clientes = dao1.consultar();


                        for (Cliente c : clientes) {

                            System.out.println("----------------");
                            System.out.println("ID: " + c.getId());
                            System.out.println("CPF: " + c.getCpf());
                            System.out.println("Nome: " + c.getNome());
                            System.out.println("Email: " + c.getEmail());

                        }

                        break;



                    case 3:

                        System.out.print("Digite o ID do cliente: ");
                        int idCliente = teclado.nextInt();


                        Cliente clienteConsultado = dao1.consultar(idCliente);


                        if (clienteConsultado != null) {

                            System.out.println("----------------");
                            System.out.println("ID: " + clienteConsultado.getId());
                            System.out.println("CPF: " + clienteConsultado.getCpf());
                            System.out.println("Nome: " + clienteConsultado.getNome());
                            System.out.println("Email: " + clienteConsultado.getEmail());
                            System.out.println("Cidade: " + clienteConsultado.getCidade());

                        } else {

                            System.out.println("Cliente não encontrado!");

                        }

                        break;



                    case 4:

                        System.out.print("Digite o ID do cliente: ");
                        int idAlterarCliente = teclado.nextInt();


                        Cliente clienteAlterar = dao1.consultar(idAlterarCliente);


                        if (clienteAlterar != null) {


                            teclado.nextLine();


                            System.out.print("Novo CPF: ");
                            clienteAlterar.setCpf(teclado.nextLine());


                            System.out.print("Novo nome: ");
                            clienteAlterar.setNome(teclado.nextLine());


                            System.out.print("Novo email: ");
                            clienteAlterar.setEmail(teclado.nextLine());


                            System.out.print("Nova rua: ");
                            clienteAlterar.setRua(teclado.nextLine());


                            System.out.print("Novo número: ");
                            clienteAlterar.setNumero(teclado.nextInt());

                            teclado.nextLine();


                            System.out.print("Novo bairro: ");
                            clienteAlterar.setBairro(teclado.nextLine());


                            System.out.print("Novo CEP: ");
                            clienteAlterar.setCep(teclado.nextLine());


                            System.out.print("Nova cidade: ");
                            clienteAlterar.setCidade(teclado.nextLine());


                            System.out.print("Novo estado: ");
                            clienteAlterar.setEstado(teclado.nextLine());


                            dao1.alterar(clienteAlterar);


                            System.out.println("Cliente alterado com sucesso!");


                        } else {

                            System.out.println("Cliente não encontrado!");

                        }


                        break;



                    case 5:

                        System.out.print("Digite o ID do cliente: ");
                        int idExcluirCliente = teclado.nextInt();


                        Cliente clienteExcluir = dao1.consultar(idExcluirCliente);


                        if (clienteExcluir != null) {


                            dao1.deletar(idExcluirCliente);


                            System.out.println("Cliente excluído com sucesso!");


                        } else {

                            System.out.println("Cliente não encontrado!");

                        }


                        break;



                    case 0:

                        System.out.println("Voltando...");

                        break;



                    default:

                        System.out.println("Opção inválida!");

                    }


                } while (opcaoCliente != 0);


                break;



            case 3:

                int opcaoPedido;

                do {

                    System.out.println("\n===== PEDIDOS =====");
                    System.out.println("1 - Criar Pedido");
                    System.out.println("2 - Adicionar produto no carrinho");
                    System.out.println("3 - Remover produto do carrinho");
                    System.out.println("4 - Finalizar pedido");
                    System.out.println("5 - Listar pedidos");
                    System.out.println("0 - Voltar");

                    System.out.print("Escolha uma opção: ");
                    opcaoPedido = teclado.nextInt();


                    switch (opcaoPedido) {


                    case 1:

                        teclado.nextLine();

                        System.out.print("Digite o ID do cliente: ");
                        int idClientePedido = teclado.nextInt();


                        Cliente clientePedido = dao1.consultar(idClientePedido);


                        if (clientePedido != null) {


                            teclado.nextLine();

                            System.out.print("Digite a data do pedido: ");
                            String data = teclado.nextLine();


                            Pedido pedido = new Pedido(clientePedido, data);


                            pedidos.add(pedido);


                            System.out.println("Pedido criado com sucesso!");


                        } else {

                            System.out.println("Cliente não encontrado!");

                        }


                        break;



                    case 2:

                        System.out.print("Digite o ID do pedido: ");
                        int idPedidoAdicionar = teclado.nextInt();


                        if (idPedidoAdicionar <= pedidos.size()) {


                            Pedido pedidoAdicionar = pedidos.get(idPedidoAdicionar - 1);


                            System.out.print("Digite o ID do produto: ");
                            int idProdutoAdicionar = teclado.nextInt();


                            Produto produtoAdicionar = dao.consultar(idProdutoAdicionar);


                            if (produtoAdicionar != null) {


                                pedidoAdicionar.adicionarProduto(produtoAdicionar);


                                System.out.println("Produto adicionado ao carrinho!");


                            } else {

                                System.out.println("Produto não encontrado!");

                            }


                        } else {

                            System.out.println("Pedido não encontrado!");

                        }


                        break;



                    case 3:

                        System.out.print("Digite o ID do pedido: ");
                        int idPedidoRemover = teclado.nextInt();


                        if (idPedidoRemover <= pedidos.size()) {


                            Pedido pedidoRemover = pedidos.get(idPedidoRemover - 1);


                            System.out.print("Digite o ID do produto para remover: ");
                            int idProdutoRemover = teclado.nextInt();


                            Produto produtoRemover = dao.consultar(idProdutoRemover);


                            pedidoRemover.removerProduto(idProdutoRemover);


                            System.out.println("Produto removido do carrinho!");


                        } else {

                            System.out.println("Pedido não encontrado!");

                        }


                        break;



                    case 4:

                        System.out.print("Digite o ID do pedido: ");
                        int idPedidoFinalizar = teclado.nextInt();


                        if (idPedidoFinalizar <= pedidos.size()) {


                            Pedido pedidoFinalizar = pedidos.get(idPedidoFinalizar - 1);


                            pedidoFinalizar.finalizarPedido();


                            System.out.println("Pedido finalizado com sucesso!");


                        } else {

                            System.out.println("Pedido não encontrado!");

                        }


                        break;



                    case 5:

                        for (Pedido p : pedidos) {


                            System.out.println("----------------");
                            System.out.println("Cliente: " + p.getCliente().getNome());
                            System.out.println("Data: " + p.getData());
                            System.out.println("Status: " + p.getStatus());


                            System.out.println("Produtos:");

                            for (Produto prod : p.getProdutos()) {

                                System.out.println("- " + prod.getDescricao());

                            }

                        }


                        break;



                    case 0:

                        System.out.println("Voltando...");

                        break;



                    default:

                        System.out.println("Opção inválida!");

                    }


                } while (opcaoPedido != 0);


                break;



            case 0:

                System.out.println("Encerrando o sistema...");

                break;



            default:

                System.out.println("Opção inválida!");

            }


        } while (opcao != 0);



        teclado.close();

    }

}