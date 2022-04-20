public class Pentamino {
    String nome; // nome da peça, indica qual o tipo de pentomino mais a sua rotacao
    char simbolo; // simbolo que sera utilizado para preencher a tabela
    int altura; // quantas unidades ele ocupa na vertical
    int largura; // quantas unidades o pentomino ocupa na horizontal
    String conteudo; // dadas suas dimensoes altura e largura, define se a posicao esta ocupada (1)
                     // ou livre (0)
    boolean utilizado; // se esse tipo de pentomino já foi utilizado, para evitar repeticao na tabela.

    public void setPentamino(String nome, char simbolo, int altura, int largura, String conteudo, boolean utilizado) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.altura = altura;
        this.largura = largura;
        this.conteudo = conteudo;
        this.utilizado = utilizado;
    }

    public boolean verificaEncaixe(int i, int j, Tabela tabela) {
        // recebe as posições iniciais e a tabela e, a partir de suas dimensões,
        // verifica se essa peça pode ser encaixada na tabela.
        // se a peça já foi utilizada, então ela não pode ser utilizada.
        if (this.utilizado == true)

             return false;

        String conteudo = this.conteudo;

        // se o tamanho da peça vai além das dimensões da tabela, então não pode ser
        // utilizada.
        if (j + this.largura > tabela.nColunas || i + this.altura > tabela.nLinhas) {
            return false;

        } else {
            for (int linha = i; linha < this.altura + i; linha++) {
                for (int coluna = j; coluna < this.largura + j; coluna++) {
                    // se a tabela já está preenchida (ou não está vazia) e a peça possui um pedaço
                    // nessa posição, então não pode ser colocada.
                    if (tabela.matriz[linha][coluna] != ('0') && conteudo.charAt(0) == '1')
                        return false;

                    // se esse primeiro pedaço pode ser colocado, avalia o proximo.
                    conteudo = conteudo.substring(1);
                }

            }
            
        }
        return true;

    }

    public void setaOcupados(Pentamino[] pentaminos) {
        this.utilizado = true;
        // se um pentamino foi ocupado, então todas as suas rotações não podem mais ser utilizadas.
        for (int k = 0; k < pentaminos.length; k++)
            // lê os pentaminós e sinaliza todos que são do mesmo 'tipo' como ocupados.
            if (pentaminos[k].simbolo == this.simbolo)
                pentaminos[k].utilizado = true;
    }
 
    public void liberaPeca(Pentamino[] pentaminos) {
        this.utilizado = false;
        for(int k = 0; k < pentaminos.length; k++)
        {
            if(pentaminos[k].simbolo == this.simbolo)
            {
                pentaminos[k].utilizado = false;
            }
        }
    }

    public boolean todosOcupados(Pentamino[] pentaminos)
    {
        for(int i = 0; i < pentaminos.length; i++)
        {
            if (pentaminos[i].utilizado == false)
                return false;
        }
        return true;
    }
}
