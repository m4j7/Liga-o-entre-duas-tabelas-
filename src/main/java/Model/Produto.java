package Model;

public class Produto {

    private int idDoProduto;
    private String nome;
    private TipoProduto tipoProduto;

    public int getIdDoProduto() {
        return idDoProduto;
    }

    public void setIdDoProduto(int idDoProduto) {
        this.idDoProduto = idDoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idDoProduto=" + idDoProduto +
                ", nome='" + nome + '\'' +
                ", tipoProduto=" + tipoProduto +
                '}';
    }
}

