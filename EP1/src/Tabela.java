
import java.util.Scanner;

public class Tabela {
    int nLinhas;
    int nColunas;
    char[][] matriz;

    public Tabela(int nLinhas, int nColunas) {
        this.nLinhas = nLinhas;
        this.nColunas = nColunas;
        this.matriz = new char[this.nLinhas][this.nColunas];

    }

    public void Print(String descr)
    {
        System.out.println(descr);
        for (var i = 0; i < nLinhas; i++)
        {
            System.out.print(i);
            System.out.print('\t');
            for (var j = 0; j < nColunas; j++)
            {
                System.out.print(this.matriz[i][j]);
                System.out.print('\t');
            }
            System.out.println();
        }
    }

    public void inicializaTabela() {
        // inicializa todas as casas da tabela como 0;

        for (int i = 0; i < this.nLinhas; i++) {
            for (int j = 0; j < this.nColunas; j++) {
                this.matriz[i][j] = '0';
            }
        }
    }

    public void preenchimentoInicial() {
        // no caso que alguma casa esteja previamente preenchida pelo usuário, essa
        // função pergunta para ele quantas são e quais as coordenadas dessa casa.
        Scanner scan = new Scanner(System.in);
        System.out.println("Deseja preencher alguma casa antes de iniciar? (s/n)");
        String resp = scan.nextLine();

        if (resp.equals("s")) {
            System.out.println("Quantas casas deseja preencher previamente?");
            int preenchidas = Integer.parseInt(scan.next());
            int i = 0;
            while (i < preenchidas) {
                System.out.print("Qual a linha da casa que deseja preencher?");
                int linhaPreenchida = Integer.parseInt(scan.next());
                System.out.print("Qual a coluna da casa que deseja preencher?");
                int colunaPreenchida = Integer.parseInt(scan.next());
                i++;

                this.matriz[linhaPreenchida][colunaPreenchida] = '*';
            }
        }
    }

    public boolean completa() {
        for (int i = 0; i < this.nLinhas; i++) {
            for (int j = 0; j < nColunas; j++) {
                if (this.matriz[i][j] == '0')
                    return false;
            }
        }

        return true;
    }

    public void preencheTabela(Pentamino peca, int i, int j) {
        // preenche a tabela com a peça que foi selecionada.

        String conteudo = peca.conteudo;
        // Lê a partir da posicao recebida as dimensões da peça.
        for (int linha = i; linha < peca.altura + i; linha++) {
            for (int coluna = j; coluna < peca.largura + j; coluna++) {
                // insere o simbolo da peça se a posição na tabela está livre.

                if (conteudo.charAt(0) == '1') {
                    this.matriz[linha][coluna] = peca.simbolo;
                }
                conteudo = conteudo.substring(1);
            }

        }
    }

    public void limpaTabela(Pentamino peca, int i, int j) {

        String conteudo = peca.conteudo;
        // Lê a partir da posicao recebida as dimensões da peça.
        for (int linha = i; linha < peca.altura + i; linha++) {
            for (int coluna = j; coluna < peca.largura + j; coluna++) {
                // insere o simbolo da peça se a posição na tabela está livre.

                if (conteudo.charAt(0) == '1' && this.matriz[linha][coluna] == peca.simbolo) {
                    this.matriz[linha][coluna] = '0';
                }
                conteudo = conteudo.substring(1);
            }

        }
    }


    public void f1(int linha, int coluna, int ponteiro)
    {

    }


    public void tenta(int linha, int coluna,
            int indexPeca, Pilha<Item> pilha,
            Pentamino[] pentaminos,
            int level)
    {
        System.out.println("\t\t\t\t" + level + "\ttentativa(l:" + linha + ", c:" + coluna + ", " + indexPeca + ", pilha(" + pilha.size() + "), ...)"); 

        for (var k = linha; k < this.nLinhas; ++k)
        {
            System.out.println("k = " + k);
            for (var j = coluna; j < this.nColunas; ++j)
            {
                System.out.println("\tj = " + j);
                for (var i = indexPeca; i < pentaminos.length; ++i)
                {
                    Pentamino peca = pentaminos[i];
                    System.out.println("\t\ti = " + i + " -> " + peca.nome);
                    if (peca.verificaEncaixe(k, j, this)) 
                    {
                        // coloca peça
                        // e empilha
                        this.preencheTabela(peca, k, j);
                        Print("ENCAIXOU A PEÇA " + peca.nome + " NA POSIÇÃO " + k + " X " + j);
                        peca.setaOcupados(pentaminos);
                        Item item = new Item();
                        item.setItem(peca, k, j, indexPeca);
                        pilha.push(item);

                        break;
                    }
                }
            }
        }
    }



    public void tentativa(int linha, int coluna, int indexPeca, Pilha<Item> pilha, Pentamino[] pentaminos, int level) {
        Pentamino peca = pentaminos[indexPeca];

        System.out.println("\t\t\t\t" + level + "\ttentativa(l:" + linha + ", c:" + coluna + ", " + indexPeca + ", pilha(" + pilha.size() + "), ...)"); 
        if (peca.verificaEncaixe(linha, coluna, this) == true) {
            // System.out.println("ENCAIXOU A PEÇA " + peca.nome + " NA POSIÇÃO " + linha + " X " + coluna);
            this.preencheTabela(peca, linha, coluna);
            Print("ENCAIXOU A PEÇA " + peca.nome + " NA POSIÇÃO " + linha + " X " + coluna);
            peca.setaOcupados(pentaminos);
            Item item = new Item();
            item.setItem(peca, linha, coluna, indexPeca);
            pilha.push(item);
            
            if (coluna < this.nColunas - 1)
                coluna++;

            else if (linha < this.nLinhas - 1)
                linha++;

            if (indexPeca < pentaminos.length)
                indexPeca++;

            tentativa(linha, coluna, indexPeca, pilha, pentaminos, level + 1);
        }

        else {
            // System.out.println("A peça " + peca.nome + " não cabe na posição " + linha + " x " + coluna);
            if (indexPeca < pentaminos.length - 1) {
                indexPeca++;
                tentativa(linha, coluna, indexPeca, pilha, pentaminos, level + 1);
            } else if (coluna < this.nColunas - 1) {
                coluna++;
                indexPeca = 0;
                tentativa(linha, coluna, indexPeca, pilha, pentaminos, level + 1);
            } else if (linha < this.nLinhas - 1) {
                linha++;
                coluna = 0;
                indexPeca = 0;
                tentativa(linha, coluna, indexPeca, pilha, pentaminos, level + 1);
            }
            else if(!pilha.isEmpty())
            {
                Item item = pilha.pop();
                this.limpaTabela(item.peca, item.linha, item.coluna);
                item.peca.liberaPeca(pentaminos);

                Print("Última peça removida: " + item.peca.nome + " de " + item.linha + " x " + item.coluna);

                tentativa(item.linha, item.coluna, item.indexPeca + 1, pilha, pentaminos, level + 1);
            }
        }
    }
}
