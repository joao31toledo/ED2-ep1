
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

    public void tentativa(int linha, int coluna, int indexPeca, Pentamino[] pentaminos, Pilha<Item> pilha)
    {
        Pentamino peca = pentaminos[indexPeca];
        
        if(this.completa())
        {
            System.out.println("DEU CERTO PORRA!");
        }

        else if(peca.utilizado == true)
        {
            if(indexPeca < pentaminos.length -1)
            {
                indexPeca++;
                tentativa(linha, coluna, indexPeca, pentaminos, pilha);
            }
        }
        
        else
        {
            
            if(peca.verificaEncaixe(linha, coluna, this) == true)
            {
                System.out.println("ENCAIXOU --------------> peça: " + peca.nome + " | index: " + indexPeca + " |linha: " + linha + " |coluna: " + coluna);
                this.preencheTabela(peca, linha, coluna);
                peca.setaOcupados(pentaminos);
                Item item = new Item();
                item.setItem(peca, linha, coluna, indexPeca);
                pilha.push(item);
                

                indexPeca = 0;
                if(coluna < this.nColunas - 1)
                {
                    coluna++;
                }
                else if(linha < this.nLinhas - 1)
                {
                    coluna = 0;
                    linha++;
                }
                tentativa(linha, coluna, indexPeca, pentaminos, pilha);
                
            }

            
            else{
             //A PEÇA NAO ENCAIXA NA POSIÇÃO

                // vai para a proxima peça, caso tenha;
                if(indexPeca < pentaminos.length - 1)
                {
                    indexPeca++;
                    this.tentativa(linha, coluna, indexPeca, pentaminos, pilha);
                }
                // se já leu todas as peças, vai para a coluna do lado ,caso tenha;
                else if(coluna < this.nColunas - 1)
                {
                    indexPeca = 0;
                    coluna++;
                    this.tentativa(linha, coluna, indexPeca, pentaminos, pilha);
                }
                // se já leu todas as peças e todas as casas da coluna, vai para a próxima linha
                else if(linha < this.nLinhas - 1)
                {
                    indexPeca = 0;
                    coluna = 0;
                    linha++;
                    this.tentativa(linha, coluna, indexPeca, pentaminos, pilha);
                }
                // já leu todas as peças, todas as colunas e todas as linhas, então tem que fazer o backtrack.
                else{
                    Item item = new Item();
                    item = pilha.pop();
                    this.limpaTabela(item.peca, item.linha, item.coluna);
                    item.peca.liberaPeca(pentaminos);
                    System.out.println(" DESEMPILHOU ------------> peça: " + item.peca.nome + " | index: " + item.indexPeca + " |linha: " + item.linha + " |coluna: " + item.coluna);
                    indexPeca = item.indexPeca + 1;
                    this.tentativa(item.linha, item.coluna, indexPeca, pentaminos, pilha);
                }

                
            }
        }
        
    }
}
