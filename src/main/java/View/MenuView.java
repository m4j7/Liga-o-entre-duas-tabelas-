package View;
import View.TipoProdutoView;
import java.util.Scanner;

public class MenuView {

   public void Menu(){


           Scanner leitor = new Scanner(System.in).useDelimiter("\n");
           ProdutoView pv = new ProdutoView();
           TipoProdutoView tp = new TipoProdutoView();

           pv.criaTabela();

           System.out.println("Escolha uma opção:");

           System.out.println("  1 - Cadastrar Produto ");
           System.out.println("  2 - Mostrar Produtos  ");
           System.out.println("  3 - Editar Produto    ");
           System.out.println("  5 - Deletar Produto   ");
           System.out.println("  6 - Cadastrar Tipo Produto ");
           System.out.println("  7 - Mostrar Tipo Produtos  ");
           System.out.println("  8 - Deletar Tipo Produto   ");

           switch (leitor.nextInt()) {
               case 1:
                   pv.criaTabela();
                   tp.mostraListaTipo();
                   pv.cadastraProduto();
                   this.Menu();
                   break;
               case 2:
                   pv.mostraLista();
                   this.Menu();
                   break;
               case 3:
                   pv.mostraLista();
                   pv.editarProduto(pv.retornaById());
                   this.Menu();
                   break;
               case 4:
                   pv.mostraLista();
                   pv.deletarProduto(pv.retornaById());
                   this.Menu();
                   break;
               case 5 :
                   tp.criaTabela();
                   tp.cadastraTipoProduto();
                   this.Menu();
                   break;
               case 6:
                   tp.mostraListaTipo();
                   this.Menu();
                   break;
               case 7:
                   tp.mostraListaTipo();
                   tp.deletarTipoProduto(tp.retornaId());
                   this.Menu();
                   break;
               case 8:
                   tp.mostraListaTipo();
                   tp.retornaIdBanco();
                   this.Menu();
               default:
                   System.out.println("Opção invalida");
           }

   }

}
