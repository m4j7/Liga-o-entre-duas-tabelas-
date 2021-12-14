package View;

import Controller.ProdutosController;
import Controller.TipoProdutoController;
import Model.Produto;
import Model.TipoProduto;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProdutoView {

  Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
  TipoProdutoView tp = new TipoProdutoView();

  public void criaTabela() {

    ProdutosController produtoController = new ProdutosController();
    produtoController.criaTabela();

  }

  public void cadastraProduto() {


    TipoProduto tipo = tp.retornaId();

    System.out.println("Digite o nome do produto");
    String nome = leitor.next();

    Produto produto = new Produto(nome, tipo);

    ProdutosController produtoController = new ProdutosController();
    ProdutosController.cadastraProduto(produto);

  }

  public void mostraLista() {

    ProdutosController pc = new ProdutosController();
    List<Produto> listaDeProdutos = pc.mostraTabela();
    for (int i = 0; i < listaDeProdutos.size(); i++) {
      System.out.println(listaDeProdutos.get(i));
    }

  }

  public Produto retornaById() {

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    Produto prod = new Produto();
    ProdutosController pc = new ProdutosController();

    System.out.println("Qual o id você quer selecionar:");

    prod = pc.seleionaById(entrada.nextInt());

    System.out.println("O produto selecionado foi:");
    System.out.println(prod);

    return prod;
  }


  public void editarProduto(Produto prod) {

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    ProdutosController pc = new ProdutosController();


    System.out.println("Escolha o que você quer editar: ");

    System.out.println("1-Nome--");

    switch (entrada.nextInt()) {
      case 1:
        prod.setNome(entrada.next());
        break;

      default:
        System.out.println("error");
    }

    pc.editarProduto(prod);

    System.out.println("Produto Editado!");
    System.out.println("Deseja Continuar?");
    System.out.println("1-Sim;2-Não;");

    switch (entrada.nextInt()) {
      case 1:
        this.editarProduto(prod);
        break;
      case 2:
        System.out.println("Retornando ao Menu");
        break;
      default:
        System.out.println("Opção invalida");
    }
  }

  public void deletarProduto(Produto produto) {

    ProdutosController pc = new ProdutosController();
    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    System.out.println("Tem certeza que deseja deletar o produto?");
    System.out.println("1-Sim;2-Não;");

    switch (entrada.nextInt()) {
      case 1:
        pc.deletaProduto(produto);
        break;
      case 2:
        System.out.println("Operação cancelada");
        break;
      default:
        System.out.println("Opção invalida");
    }
  }

}
