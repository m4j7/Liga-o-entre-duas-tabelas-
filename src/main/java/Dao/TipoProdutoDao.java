package Dao;

import Factory.ConectionFactory;
import Model.Produto;
import Model.TipoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoProdutoDao {

    private Connection connection;

    public TipoProdutoDao() {
        this.connection = new ConectionFactory().getConnection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS TIPOprodCadastrados ("+
                "idTipoDoProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Tipo Produto criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(TipoProduto tPproduto){

        String sql = "INSERT INTO TIPOprodCadastrados" +
                " (nome) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, tPproduto.getTipoProduto());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                tPproduto.setIdDoProduto(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TipoProduto> mostraLista(){

        String sql = "SELECT * FROM TIPOprodCadastrados";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<TipoProduto> TipoList = new ArrayList<>();
            TipoProduto tipoProduto;

            while (resultSet.next()) {
                TipoProduto tp = new TipoProduto();
                tp.setTipoProduto(resultSet.getString("nome"));
                tp.setIdDoProduto(resultSet.getInt("idTipoDoProduto"));
                TipoList.add(tp);
            }

            return TipoList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }


    public TipoProduto SelecionaTipoId (int id){

        String sql = "SELECT * FROM TIPOprodCadastrados WHERE idTipoDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto.setIdDoProduto(resultSet.getInt("idTipoDoProduto"));
                tipoProduto.setTipoProduto(resultSet.getString("nome"));

                return tipoProduto;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }


    public void removeProdutoDoBanco(TipoProduto tipoProduto){
        String sql = "DELETE FROM TIPOprodCadastrados WHERE idDoProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, tipoProduto.getIdDoProduto());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
