package Dao;

import Factory.ConectionFactory;
import Model.Produto;
import Model.TipoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConectionFactory().getConnection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS produtosCadastrados ("+
                "idDoProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "idTipoDoProdutoFK INT," +
                "FOREIGN KEY (idTipoDoProdutoFK)" +
                "REFERENCES TIPOprodCadastrados(idTipoDoProduto)" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Produto criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Produto produto){

        String sql = "INSERT INTO produtosCadastrados" +
                " (nome, idTipoProdutoFK) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipoProduto().getTipoProduto());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                produto.setIdDoProduto(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> mostraLista(){

        String sql = "SELECT * FROM produtosCadastrados";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Produto> produtos = new ArrayList<>();
            Produto produto;

            while (resultSet.next()) {
                produto = new Produto();
                produto.setNome(resultSet.getString("nome"));
                produto.setIdDoProduto(resultSet.getInt("idDoProduto"));
                produtos.add(produto);

                TipoProdutoDao tpDAO = new TipoProdutoDao();
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto  = tpDAO.SelecionaTipoId(resultSet.getInt("idTipoProdutoFK"));

                produto.setTipoProduto(tipoProduto);
            }

            ProdutoDao pd = new ProdutoDao();


            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }


    public Produto SelecionaId (int id){

        String sql = "SELECT * FROM produtosCadastrados WHERE idDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setIdDoProduto(resultSet.getInt("idDoProduto"));
                produto.setNome(resultSet.getString("nome"));

                TipoProdutoDao tpDAO = new TipoProdutoDao();
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto  = tpDAO.SelecionaTipoId(resultSet.getInt("idTipoProdutoFK"));
                produto.setTipoProduto(tipoProduto);

                return produto;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    public Produto SelecionaProdutoId(int id){

        String sql = "SELECT * FROM produtosCadastrados WHERE idDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setIdDoProduto(resultSet.getInt("idDoProduto"));
                produto.setNome(resultSet.getString("nome"));

                TipoProdutoDao tpDAO = new TipoProdutoDao();
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto  = tpDAO.SelecionaTipoId(resultSet.getInt("idTipoProdutoFK"));

                produto.setTipoProduto(tipoProduto);

                return produto;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }


    public void editarProdutoDoBanco(Produto produto){
        String sql = "UPDATE produtosCadastrados SET nome = ? WHERE idDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getIdDoProduto());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void removeProdutoDoBanco(Produto produto){
        String sql = "DELETE FROM produtosCadastrados WHERE idDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getIdDoProduto());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
