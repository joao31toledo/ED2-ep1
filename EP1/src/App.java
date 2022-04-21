import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Declaracao dos objetos pentaminos e suas propriedades
        // Pentaminos do tipo I
        Pentamino I1 = new Pentamino();
        I1.setPentamino("I1", 'I', 5, 1, "11111", false);
        Pentamino I2 = new Pentamino();
        I2.setPentamino("I2", 'I', 1, 5, "11111", false);

        // Pentaminos do tipo L
        Pentamino L1 = new Pentamino();
        L1.setPentamino("L1", 'L', 4, 2, "10101011", false);
        Pentamino L2 = new Pentamino();
        L2.setPentamino("L2", 'L', 2, 4, "00011111", false);
        Pentamino L3 = new Pentamino();
        L3.setPentamino("L3", 'L', 4, 2, "11010101", false);
        Pentamino L4 = new Pentamino();
        L4.setPentamino("L4", 'L', 2, 4, "11111000", false);
        Pentamino L5 = new Pentamino();
        L5.setPentamino("L5", 'L', 4, 2, "01010111", false);
        Pentamino L6 = new Pentamino();
        L6.setPentamino("L6", 'L', 2, 4, "10001111", false);
        Pentamino L7 = new Pentamino();
        L7.setPentamino("L7", 'L', 4, 2, "11101010", false);
        Pentamino L8 = new Pentamino();
        L8.setPentamino("L8", 'L', 2, 4, "11110001", false);

        // Pentaminos do tipo V
        Pentamino V1 = new Pentamino();
        V1.setPentamino("V1", 'V', 3, 3, "100100111", false);
        Pentamino V2 = new Pentamino();
        V2.setPentamino("V2", 'V', 3, 3, "001001111", false);
        Pentamino V3 = new Pentamino();
        V3.setPentamino("V3", 'V', 3, 3, "111001001", false);
        Pentamino V4 = new Pentamino();
        V4.setPentamino("V4", 'V', 3, 3, "111100100", false);

        // Pentaminos do tipo P
        Pentamino P1 = new Pentamino();
        P1.setPentamino("P1", 'P', 3, 2, "111110", false);
        Pentamino P2 = new Pentamino();
        P2.setPentamino("P2", 'P', 2, 3, "110111", false);
        Pentamino P3 = new Pentamino();
        P3.setPentamino("P3", 'P', 3, 2, "011111", false);
        Pentamino P4 = new Pentamino();
        P4.setPentamino("P4", 'P', 2, 3, "111011", false);
        Pentamino P5 = new Pentamino();
        P5.setPentamino("P5", 'P', 3, 2, "111101", false);
        Pentamino P6 = new Pentamino();
        P6.setPentamino("P6", 'P', 2, 3, "111110", false);
        Pentamino P7 = new Pentamino();
        P7.setPentamino("P7", 'P', 3, 2, "101111", false);
        Pentamino P8 = new Pentamino();
        P8.setPentamino("P8", 'P', 2, 3, "011111", false);

        // Pentaminos do tipo T
        Pentamino T1 = new Pentamino();
        T1.setPentamino("T1", 'T', 3, 3, "111010010", false);
        Pentamino T2 = new Pentamino();
        T2.setPentamino("T2", 'T', 3, 3, "100111100", false);
        Pentamino T3 = new Pentamino();
        T3.setPentamino("T3", 'T', 3, 3, "010010111", false);
        Pentamino T4 = new Pentamino();
        T4.setPentamino("T4", 'T', 3, 3, "001111001", false);

        // Pentaminos do tipo C
        Pentamino C1 = new Pentamino();
        C1.setPentamino("C1", 'C', 2, 3, "101111", false);
        Pentamino C2 = new Pentamino();
        C2.setPentamino("C2", 'C', 3, 2, "110111", false);
        Pentamino C3 = new Pentamino();
        C3.setPentamino("C3", 'C', 2, 3, "111101", false);
        Pentamino C4 = new Pentamino();
        C4.setPentamino("C4", 'C', 3, 2, "111011", false);

        // Pentaminos do tipo Z
        Pentamino Z1 = new Pentamino();
        Z1.setPentamino("Z1", 'Z', 3, 3, "110010011", false);
        Pentamino Z2 = new Pentamino();
        Z2.setPentamino("Z2", 'Z', 3, 3, "001111100", false);
        Pentamino Z3 = new Pentamino();
        Z3.setPentamino("Z3", 'Z', 3, 3, "011010110", false);
        Pentamino Z4 = new Pentamino();
        Z4.setPentamino("Z4", 'Z', 3, 3, "100111001", false);

        // Pentaminos do tipo N
        Pentamino N1 = new Pentamino();
        N1.setPentamino("N1", 'N', 4, 2, "01011110", false);
        Pentamino N2 = new Pentamino();
        N2.setPentamino("N2", 'N', 2, 4, "11100011", false);
        Pentamino N3 = new Pentamino();
        N3.setPentamino("N3", 'N', 4, 2, "01111010", false);
        Pentamino N4 = new Pentamino();
        N4.setPentamino("N4", 'N', 2, 4, "11000111", false);
        Pentamino N5 = new Pentamino();
        N5.setPentamino("N5", 'N', 4, 2, "10101101", false);
        Pentamino N6 = new Pentamino();
        N6.setPentamino("N6", 'N', 2, 4, "00111110", false);
        Pentamino N7 = new Pentamino();
        N7.setPentamino("N7", 'N', 4, 2, "10110101", false);
        Pentamino N8 = new Pentamino();
        N8.setPentamino("N8", 'N', 2, 4, "01111100", false);

        // Pentaminos do tipo y
        Pentamino Y1 = new Pentamino();
        Y1.setPentamino("Y1", 'Y', 4, 2, "10111010", false);
        Pentamino Y2 = new Pentamino();
        Y2.setPentamino("Y2", 'Y', 2, 4, "01001111", false);
        Pentamino Y3 = new Pentamino();
        Y3.setPentamino("Y3", 'Y', 4, 2, "01011101", false);
        Pentamino Y4 = new Pentamino();
        Y4.setPentamino("Y4", 'Y', 2, 4, "11110010", false);
        Pentamino Y5 = new Pentamino();
        Y5.setPentamino("Y5", 'Y', 4, 2, "01110101", false);
        Pentamino Y6 = new Pentamino();
        Y6.setPentamino("Y6", 'Y', 2, 4, "11110100", false);
        Pentamino Y7 = new Pentamino();
        Y7.setPentamino("Y7", 'Y', 4, 2, "10101110", false);
        Pentamino Y8 = new Pentamino();
        Y8.setPentamino("Y8", 'Y', 2, 4, "00101111", false);

        // Pentaminos do tipo W
        Pentamino W1 = new Pentamino();
        W1.setPentamino("W1", 'W', 3, 3, "100110011", false);
        Pentamino W2 = new Pentamino();
        W2.setPentamino("W2", 'W', 3, 3, "001011110", false);
        Pentamino W3 = new Pentamino();
        W3.setPentamino("W3", 'W', 3, 3, "110011001", false);
        Pentamino W4 = new Pentamino();
        W4.setPentamino("W4", 'W', 3, 3, "011110100", false);

        // Pentaminos do tipo F
        Pentamino F1 = new Pentamino();
        F1.setPentamino("F1", 'F', 3, 3, "011110010", false);
        Pentamino F2 = new Pentamino();
        F2.setPentamino("F2", 'F', 3, 3, "110011010", false);
        Pentamino F3 = new Pentamino();
        F3.setPentamino("F3", 'F', 3, 3, "100111010", false);
        Pentamino F4 = new Pentamino();
        F4.setPentamino("F4", 'F', 3, 3, "010111100", false);
        Pentamino F5 = new Pentamino();
        F5.setPentamino("F5", 'F', 3, 3, "010011110", false);
        Pentamino F6 = new Pentamino();
        F6.setPentamino("F6", 'F', 3, 3, "010110011", false);
        Pentamino F7 = new Pentamino();
        F7.setPentamino("F7", 'F', 3, 3, "010111001", false);
        Pentamino F8 = new Pentamino();
        F8.setPentamino("F8", 'F', 3, 3, "001111010", false);

        // PENTAMINO X
        Pentamino X = new Pentamino();
        X.setPentamino("X", 'X', 3, 3, "010111010", false);

        // array com todos os pentaminos
        Pentamino[] pentaminos = {
                I1, I2,
                L1, L2, L3, L4, L5, L6, L7, L8,
                V1, V2, V3, V4,
                P1, P2, P3, P4, P5, P6, P7, P8,
                T1, T2, T3, T4,
                C1, C2, C3, C4,
                Z1, Z2, Z3, Z4,
                N1, N2, N3, N4, N5, N6, N7, N8,
                Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8,
                W1, W2, W3, W4,
                F1, F2, F3, F4, F5, F6, F7, F8,
                X };

        Pilha<Item> pilha = new Pilha<Item>(); // Cria a pilha que servirá de base para o backtrack;
        Item item = new Item();
        Scanner scan = new Scanner(System.in); // Cria um scanner para ler a entrada do usuario;

        System.out.println("Quantas linhas terá a tabela?");
        int nLinhas = scan.nextInt();

        System.out.println("Quantas colunas terá a tabela?");
        int nColunas = scan.nextInt();

        // peça que será utilizada para facilitar o programa;
        Pentamino peca = new Pentamino();

        // cria a tabela com as dimensões recebidas na entrada
        Tabela tabela = new Tabela(nLinhas, nColunas);
        tabela.inicializaTabela();
        tabela.preenchimentoInicial();
        
        tabela.tentativa(0, 0, 0, pentaminos, pilha);


        for (int x = 0; x < nLinhas; x++) {
            for (int y = 0; y < nColunas; y++) {
                System.out.print(tabela.matriz[x][y]);
            }
            System.out.println("");
        }
    }
}