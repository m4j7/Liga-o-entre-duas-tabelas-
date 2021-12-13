package Controller;

import Dao.ProdutoDao;
import Model.Produto;

import java.util.List;

public class ProdutosController {

    public void criaTabela(){

        ProdutoDao prodDao = new ProdutoDao();
        prodDao.criaTabela();

    }

    public static void cadastraProduto(Produto produto){

        ProdutoDao prodDao = new ProdutoDao();
        prodDao.gravaNoBanco(produto);

    }

    public List<Produto> mostraTabela(){

        ProdutoDao prodDao = new ProdutoDao();
        return prodDao.mostraLista();

    }

    public Produto seleionaById(int id){

        ProdutoDao pd = new ProdutoDao();
        return pd.SelecionaProdutoId(id);
    }

    public void editarProduto(Produto produto){
        ProdutoDao prodDao = new ProdutoDao();
        prodDao.editarProdutoDoBanco(produto);
    }

    public void deletaProduto(Produto produto){
        ProdutoDao prodDao = new ProdutoDao();
        prodDao.removeProdutoDoBanco(produto);
    }


}
