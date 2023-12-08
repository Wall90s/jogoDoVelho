import java.util.Scanner;

public class Main {

    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        telaInicial();
    }

    public static void telaInicial() {
        rodape();
        System.out.println("       _                   \r\n" + //
                "      | |                  \r\n" + //
                "      | | ___   __ _  ___  \r\n" + //
                "  _   | |/ _ \\ / _` |/ _ \\ \r\n" + //
                " | |__| | (_) | (_| | (_) |\r\n" + //
                "  \\____/ \\___/ \\__, |\\___/ \r\n" + //
                "     | |        __/ |      \r\n" + //
                "   __| | ___   |___/       \r\n" + //
                "  / _` |/ _ \\              \r\n" + //
                " | (_| | (_) |             \r\n" + //
                " _\\__,_|\\___/_ _           \r\n" + //
                " \\ \\    / / | | |          \r\n" + //
                "  \\ \\  / /__| | |__   ___  \r\n" + //
                "   \\ \\/ / _ \\ | '_ \\ / _ \\ \r\n" + //
                "    \\  /  __/ | | | | (_) |\r\n" + //
                "     \\/ \\___|_|_| |_|\\___/ \r\n" + //
                "");
        System.out.println("escolha uma opção");
        System.out.println(" 1 - Novo jogo");
        System.out.println(" 2 - Como jogar");
        System.out.println(" 3 - Créditos");
        System.out.println();
        System.out.println("feito com <3 por Wall90s");
        System.out.println("         2023");
        rodape();

        int opcao = leia.nextInt();

        switch (opcao) {
            case 1:
                limpaConsole();
                jogar();
                break;

            case 2:
                limpaConsole();
                comoJogar();
                break;

            case 3:
                limpaConsole();
                creditos();
                break;

            default:
                System.out.println("Opção inválida, por favor reveja a seleção.");
                rodape();
                break;
        }
    }

    public static void jogar() {

        String[] posicoes = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        boolean[] posicoesEscolhidas = { false, false, false, false, false, false, false, false, false };

        int posicao;
        boolean jogada = true;
        String jogador = "X";

        while (situacaoDoJogo(posicoes) && !verificaTabuleiroPreenchido(posicoesEscolhidas)) {

            if (jogada) {
                jogador = "X";
            } else {
                jogador = "O";
            }

            System.out.println("Jogador " + jogador + " faça sua escolha");
            tabuleiro(posicoes);

            posicao = leia.nextInt();

            int posicaoEscolhida = posicao - 1;

            if (posicoes[posicaoEscolhida].matches("\\d")) {
                posicoes[posicaoEscolhida] = jogador;
                posicoesEscolhidas[posicaoEscolhida] = true;
                jogada = !jogada;
            } else {
                System.out.println("Posicao já escolhida, verifique sua jogada");
                System.out.println();
            }

        }

        tabuleiro(posicoes);
        telaFinal(jogador, posicoesEscolhidas);
    }

    public static boolean verificaTabuleiroPreenchido(boolean posicoesEscolhidas[]) {
        for (int i = 0; i < posicoesEscolhidas.length; i++) {
            if (posicoesEscolhidas[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void tabuleiro(String posicoes[]) {
        System.out.println();
        System.out.println(" " + posicoes[0] + " | " + posicoes[1] + " | " + posicoes[2] + "");
        System.out.println("-----------");
        System.out.println(" " + posicoes[3] + " | " + posicoes[4] + " | " + posicoes[5] + "");
        System.out.println("-----------");
        System.out.println(" " + posicoes[6] + " | " + posicoes[7] + " | " + posicoes[8] + "");
        System.out.println();
    }

    public static boolean situacaoDoJogo(String posicoes[]) {
        // Primeira linha
        if (posicoes[0].equals(posicoes[1]) && posicoes[0].equals(posicoes[2])) {
            return false;
        }

        // Segunda linha
        if (posicoes[3].equals(posicoes[4]) && posicoes[3].equals(posicoes[5])) {
            return false;
        }

        // Terceira linha
        if (posicoes[6].equals(posicoes[7]) && posicoes[6].equals(posicoes[8])) {
            return false;
        }

        // Primeira coluna
        if (posicoes[0].equals(posicoes[3]) && posicoes[0].equals(posicoes[6])) {
            return false;
        }

        // Segunda coluna
        if (posicoes[1].equals(posicoes[4]) && posicoes[1].equals(posicoes[7])) {
            return false;
        }

        // Terceira coluna
        if (posicoes[2].equals(posicoes[5]) && posicoes[2].equals(posicoes[8])) {
            return false;
        }

        // Primeira diagnonal
        if (posicoes[0].equals(posicoes[4]) && posicoes[0].equals(posicoes[8])) {
            return false;
        }

        // Segunda diagonal
        if (posicoes[2].equals(posicoes[4]) && posicoes[2].equals(posicoes[6])) {
            return false;
        }

        return true;

    }

    public static void telaFinal(String jogador, boolean posicoesEscolhidas[]) {
        if (verificaTabuleiroPreenchido(posicoesEscolhidas)) {
            System.out.println("Fim de jogo!");
            System.out.println("Jogo empatado");
            System.out.println();
            aperteEnterParaContinuar();
            limpaConsole();
            rodape();
            telaInicial();
        } else {
            System.out.println("Fim de jogo!");
            System.out.println("Jogador " + jogador);
            System.out.println("é o vencedor");
            System.out.println();
            aperteEnterParaContinuar();
            limpaConsole();
            rodape();
            telaInicial();
        }
    }

    public static void comoJogar() {
        System.out.println(" - Como jogar -");
        System.out.println();
        System.out.println("Jogo do Velho é um jogo tradicional \r\n" + //
                "de jogo da velha\r\n" + //
                "Então as regras e modo de jogar são\r\n" + //
                "os mesmos\r\n" + //
                "\r\n" + //
                "A primeira pessoa a jogar começa com o \r\n" + //
                "símbolo [X]\r\n" + //
                "Selecione um número de 1 a 9 do tabuleiro \r\n" + //
                "para escolher em qual posição será \r\n" + //
                "colocado o símbolo [X]");
        System.out.println();
        aperteEnterParaContinuar();
        limpaConsole();

        System.out.println(
                "Depois dessa jogada a próxima pessoa a \r\n" + //
                        "jogar utiliza o símbolo [O]                         \r\n" + //
                        "Basta fazer o mesmo e escolher um lugar\r\n" + //
                        "utilizando um número disponível\r\n" + //
                        "\r\n" + //
                        "Posições já escolhidas não podem ser\r\n" + //
                        "escolhidas novamente\r\n" + //
                        "\r\n" + //
                        "O jogo acaba quando uma das pessoas \r\n" + //
                        "conseguir completar uma linha\r\n" + //
                        "Ou caso todas as posições sejam \r\n" + //
                        "preenchidas                     \r\n" + //
                        "\r\n" + //
                        "Bom jogo!");
        System.out.println();

        aperteEnterParaContinuar();
        limpaConsole();
        rodape();
        telaInicial();
    }

    public static void creditos() {
        System.out.println(" - Créditos -");
        System.out.println();
        System.out.println("               Jogo feito por");
        System.out.println("             Wallace Silva Brito");
        System.out.println();
        System.out.println("Olá, sou um desenvolvedor que ama tecnologia.");
        System.out.println("Me siga aqui e acolá para novidades.");
        System.out.println();
        System.out.println("- GitHub");
        System.out.println("https://github.com/Wall90s");
        System.out.println("- LinkedIn");
        System.out.println("https://www.linkedin.com/in/wallacesb/");
        System.out.println("- Portifólio");
        System.out.println("https://linktr.ee/wall90s");
        System.out.println();
        aperteEnterParaContinuar();
        limpaConsole();
        rodape();
        telaInicial();
    }

    public static void rodape() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();
    }

    public static void aperteEnterParaContinuar() {
        System.out.println(" aperte [Enter] para continuar");
        try {
            System.in.read();
            leia.nextLine();
        } catch (Exception e) {
        }
    }

    public static void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
