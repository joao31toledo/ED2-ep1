public class Item {
    Pentamino peca;
    int linha;
    int coluna;
    int indexPeca;

    public void setItem(Pentamino peca, int linha, int coluna, int indexPeca)
    {
        this.peca = peca;
        this.linha = linha;
        this.coluna = coluna;
        this.indexPeca = indexPeca;
    }
}
