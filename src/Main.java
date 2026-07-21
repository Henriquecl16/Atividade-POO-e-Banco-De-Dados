import java.util.List;
import java.util.Scanner;
import dao.ProdutoDao;
import modelos.Produto;
import modelos.Cliente;
import dao.ClienteDao;


public class Main {

    public static void main(String[] args) {

    	ProdutoDao dao = new ProdutoDao();
    	ClienteDao dao1 = new ClienteDao();

        Cliente cliente = dao1.consultar(1);

        System.out.println(cliente.getNome());
        System.out.println(cliente.getEmail());

        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int opcaoProduto;
        
     
        
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

        		    	dao1.salvar(produto);

        		    	System.out.println("Produto cadastrado com sucesso!");
        		        break;

        		    case 2:
        		       List<Produto> produtos = dao1.consultar();
        		       
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

        		        Produto produtoConsultado = dao1.consultar(id);

        		        if (produtoConsultado != null) {

        		            System.out.println("----------------");
        		            System.out.println("ID: " + produtoConsultado.getId());
        		            System.out.println("Descrição: " + produtoConsultado.getDescricao());
        		            System.out.println("Preço: " + produtoConsultado.getPreco());

        		        } else {
        		            System.out.println("Produto não encontrado!");
        		        }
        		        break;

        		    case 4:
        		    	  System.out.print("Digite o ID do produto: ");
        		    	    int idAlterar = teclado.nextInt();

        		    	    Produto produtoAlterar = dao1.consultar(idAlterar);

        		    	    if (produtoAlterar != null) {

        		    	        teclado.nextLine();

        		    	        System.out.print("Nova descrição: ");
        		    	        String descricaoNova = teclado.nextLine();

        		    	        System.out.print("Novo preço: ");
        		    	        double precoNovo = teclado.nextDouble();
        		    	        
        		    	        System.out.println("Novo estoque: ");
        		    	        int estoqueNovo = teclado.nextInt();

        		    	        produtoAlterar.setDescricao(descricaoNova);
        		    	        produtoAlterar.setPreco(precoNovo);
        		    	        produtoAlterar.setEstoque(estoqueNovo);

        		    	        dao1.alterar(produtoAlterar);

        		    	        System.out.println("Produto alterado com sucesso!");

        		    	    } else {
        		    	        System.out.println("Produto não encontrado!");
        		    	    }

        		        break;

        		    case 5:
        		    	 System.out.print("Digite o ID do produto: ");
        		    	    int idExcluir = teclado.nextInt();

        		    	    Produto produtoExcluir = dao1.consultar(idExcluir);

        		    	    if (produtoExcluir != null) {

        		    	        dao1.deletar(idExcluir);

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
        	    break;
        	    

        	
        	case 2:

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

        	    Cliente cliente = new Cliente(cpf, nome, email, rua,
        	            numero, bairro, cep, cidade, estado);

        	    Cliente retorno = clienteDao.salvar(cliente);

        	    if (retorno != null) {
        	        System.out.println("Cliente cadastrado com sucesso!");
        	        System.out.println("ID do cliente: " + retorno.getId());
        	    } else {
        	        System.out.println("Erro ao cadastrar cliente!");
        	    }

        	    break;

        	case 3:
        	    System.out.println("Menu de Pedidos");
        	    break;

        	case 0:
        	    System.out.println("Encerrando o sistema...");
        	    break;

        	default:
        	    System.out.println("Opção inválida!");
        	}
        		
        }while(opcao !=0);
        	
        

    }

}
		
	
		
	




//CÓDIGOS ANTIGOS//

/*dao.deletar(3);
Produto p = dao.consultar(3);
if(p != null) {
	System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());
}else {
	System.out.println("Produto não encontrado");*/



/*Produto retorno = dao.salvar(p1);
System.out.println(retorno.getId() + " " + retorno.getDescricao());*/
/*List<Produto> lista = dao.consultar();
for (Produto p : lista ) {
	System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());	
}*/

/*Produto p = dao.consultar(4);
System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());

p.setDescricao("Alcatra");
p.setPreco(39.99);
dao.alterar(p);

Produto alterado = dao.consultar(4);
System.out.println(alterado.getId() + " " + alterado.getDescricao() + " " + alterado.getPreco());*/