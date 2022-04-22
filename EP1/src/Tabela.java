
import java.util.Scanner;
import java.util.*;

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


    public boolean colocaPeca(Pentamino[][] pecasDisponiveis, Pilha<Item> pilha)
    {
        /*
         *   peça <- primeira peça disponível
         *   para cada rotação
         *      para cada linha
         *          para cada coluna
         *              se pode colocar a peça na linha, coluna:
         *                  coloca peça
         *                  empilha ???
         *                  define como ocupado ???
         *                  if (colocaPeca(peçasDisponíveis - peça))
         *                      // achou uma solução
         *                      break
         *                  else
         *                      desempilha
         *                      remove peça
         *                      libera 
         *
         */

        if (pecasDisponiveis.length > 0)
        {
            Pentamino[] rotacoes = pecasDisponiveis[0];

            // this.Print("Peça: " + rotacoes[0].simbolo + "; peças disponíveis: " + pecasDisponiveis.length);

            for (int r = 0; r < rotacoes.length; r++)
            {
                Pentamino peca = rotacoes[r];

                // System.out.println("\t\tTentando peça " + peca.nome + "...");

                // TODO: otimizar 
                int ultimaLinhaParaPeca = this.nLinhas;// - peca.altura + 1;
                int ultimaColunaParaPeca = this.nColunas;// - peca.largura + 1;

                for (int linha = 0; linha < ultimaLinhaParaPeca; ++linha)
                {
                    for (int coluna = 0; coluna < ultimaColunaParaPeca; ++coluna)
                    {
                        if (peca.verificaEncaixe(linha, coluna, this))
                        {
                            // coloca a peça no tabuleiro
                            this.preencheTabela(peca, linha, coluna);

                            // empilha
                            Item item = new Item();
                            item.setItem(peca, linha, coluna, 0);
                            pilha.push(item);

                            // define como ocupado
                            // peca.setaOcupados(pecasDisponiveis);

                            Pentamino[][] novasPecasDisponiveis = Arrays.copyOfRange(pecasDisponiveis, 1, pecasDisponiveis.length);

                            if (colocaPeca(novasPecasDisponiveis, pilha))
                            {
                                // sucesso!
                                this.Print("Sucesso!");
                                return true;
                            }

                            // desempilha
                            item = pilha.pop();

                            // remove a peça do tabuleiro
                            this.limpaTabela(item.peca, item.linha, item.coluna);
                        }
                        // else 
                        // {
                        //     System.out.println("\t\t\t\t\tPeça " + peca.nome + " não cabe em " + linha + ", " + coluna);
                        // }
                    }

                    // System.out.println("\t\t\t\t\t\tPróxima linha: " + (linha + 1));
                }
            }
        }

        return false;
    }

    
}

