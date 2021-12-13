package View;

import Controller.ProdutosController;
import Controller.TipoProdutoController;
import Model.Produto;
import Model.TipoProduto;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TipoProdutoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);


    public void criaTabela() {

        TipoProdutoController produtoController = new TipoProdutoController ();
        TipoProdutoController.criaTabela();

    }

    public void cadastraTipoProduto() {

        System.out.println("Cadastre o tipo do produto: ");
        String tipoProduto = leitor.next();

        TipoProduto tipo = new TipoProduto(tipoProduto);

        TipoProdutoController produtoController = new TipoProdutoController();
        TipoProdutoController.cadastraTipoProduto(tipo);
    }

    public void mostraListaTipo() {

        TipoProdutoController pc = new TipoProdutoController();
        List<TipoProduto> listaDeTipo = pc.mostraTabela();
        for (int i = 0; i < listaDeTipo.size(); i++) {
            System.out.println(listaDeTipo.get(i));
        }

    }

    public TipoProduto retornaId() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        TipoProduto tipoProduto = new TipoProduto();

        TipoProdutoController pc = new TipoProdutoController();
        System.out.println("Qual o id você quer selecionar:");

        tipoProduto = pc.seleionaById(entrada.nextInt());

        System.out.println("O tipo selecionado foi:");
        System.out.println(tipoProduto);

        return tipoProduto;
    }


    public void deletarTipoProduto(TipoProduto tipo) {

        TipoProdutoController pc = new TipoProdutoController();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Tem certeza que deseja deletar o produto?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()) {
            case 1:
                pc.deletaProduto(tipo);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }
}
