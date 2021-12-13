package Model;

public class TipoProduto {

    private int idDoProduto;
    private String tipoProduto;

    public int getIdDoProduto() {
        return idDoProduto;
    }

    public void setIdDoProduto(int idDoProduto) {
        this.idDoProduto = idDoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public TipoProduto() {
    }

    public TipoProduto(int idDoProduto, String tipoProduto) {
        this.idDoProduto = idDoProduto;
        this.tipoProduto = tipoProduto;
    }

    public TipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public String toString() {
        return "TipoProduto{" +
                "idDoProduto=" + idDoProduto +
                ", tipoProduto='" + tipoProduto + '\'' +
                '}';
    }
}
