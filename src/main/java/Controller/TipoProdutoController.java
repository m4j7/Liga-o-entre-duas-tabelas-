package Controller;

import Dao.TipoProdutoDao;
import Model.Produto;
import Model.TipoProduto;

import java.util.List;

public class TipoProdutoController {

    public static void criaTabela(){

        TipoProdutoDao prodDao = new TipoProdutoDao();
        prodDao.criaTabela();
    }

    public static void cadastraTipoProduto(TipoProduto tpProduto){
        TipoProdutoDao tpProd = new TipoProdutoDao();
        tpProd.gravaNoBanco(tpProduto);
    }

    public List<TipoProduto> mostraTabela(){
        TipoProdutoDao TPproduto = new TipoProdutoDao();

        return TPproduto.mostraLista();
    }

    public TipoProduto seleionaById(int id){
        TipoProdutoDao TPproduto = new TipoProdutoDao();
        return TPproduto.SelecionaTipoId(id);
    }


    public void deletaProduto( TipoProduto tipo){
        TipoProdutoDao prodTipoDao = new TipoProdutoDao();
        prodTipoDao.removeProdutoDoBanco(tipo);
    }


}
