import java.util.Arrays;
import java.util.Scanner;

public class Jogo {

    //Atributos
    private String nomeJogador;
    private int opcaoUser;

    private Scanner read = new Scanner(System.in);

    //Metodos
    public void start() {

        System.out.println("====".repeat(10) + "\n"
                + "NOME DO JOGO" + "\n"
                + "O jogo mais pika que voce vai jogar" + "\n"
                + "====".repeat(10));

        System.out.println("Digite o nome do jogador: ");
        nomeJogador = read.nextLine();
    }

    public void gerarPegunta(String enunciado, String altenativa1, String alternativa2) {

        // Aqui cria uma pergunta. Ela possui o enunciado e uma lista de alternativas.
        Pergunta pergunta = new Pergunta(
                enunciado,
                Arrays.asList(new Alternativa(altenativa1),
                        new Alternativa(alternativa2))

        );
        System.out.println(pergunta.toString());

        while (true) {
            try {
                opcaoUser = Integer.parseInt(read.nextLine());
                if (opcaoUser >= 0 && opcaoUser < pergunta.getAlternativas().size()) {
                    if (opcaoUser == 0) {
                        System.out.println("Aumenta um atributo x");
                    } else if (opcaoUser == 1) {
                        System.out.println("Aumenta um atributo x");
                    }
                    break;
                } else {
                    System.out.println("Esta errado fioti!");
                }
            } catch (Exception e) {
                System.out.println("Está se achando o engraçadao, né, seu animal! \nDigita certo isso ai.");
            }

        }

    }

    
}
