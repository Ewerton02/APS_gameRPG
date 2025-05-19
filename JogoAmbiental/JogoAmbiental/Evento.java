 import java.util.InputMismatchException;
 import java.util.List;
 import java.util.Scanner;

public class Evento {

    // Atributo
    private String descricao;
    private String opcao1;
    private String opcao2;
    private int[] efeitosOpcao1;
    private int[] efeitosOpcao2;


    // Construtor
    public Evento(String descricao, String opcao1, int[] efeitos1, String opcao2, int[] efeitos2) {
        this.descricao = descricao;
        this.opcao1 = opcao1;
        this.efeitosOpcao1 = efeitos1;
        this.opcao2 = opcao2;
        this.efeitosOpcao2 = efeitos2;
    }


    // Metodo
    // Exibe as informações de cada evento
    public void apresentarEvento(Personagem p, List<String> inventario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + descricao);
        System.out.println("1 - " + opcao1);
        System.out.println("2 - " + opcao2);
        System.out.print("Escolha (1 ou 2): ");


        while (true) {
            // Tratando a exceção caso o usuario digite uma string
            try {
                // Usando int para funcionar tanto como inventaio, como número
                String escolha = scanner.nextLine();
                if (escolha.equals("1")) {
                    this.aplicarEfeitos(p, this.efeitosOpcao1);
                    break;
                } else if (escolha.equals("2")) {
                    this.aplicarEfeitos(p, this.efeitosOpcao2);
                    break;
                } else if (escolha.equalsIgnoreCase("inventario")) {
                    p.showInventario();
                    p.useItem(inventario);
                }
                else {
                    System.out.println("Infelizmente a poluição causou confusão no personagem, o que o levou a tomar a decisão errada.");
                    this.aplicarEfeitos(p, this.efeitosOpcao2);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Você está digitando errado. Escolha entre 1 e 2.");
                System.out.println(e);

            }

        }


        // Atributos do personagem
        p.mostrarAtibutos();
    }

    // Aplica os efeitos no personagem
    private void aplicarEfeitos(Personagem p, int[] efeitos) {
        // É criado um array em um metodo do main, ao qual se refere a efeitos
        p.mudarEnergia(efeitos[0]);
        p.mudarConscientizacao(efeitos[1]);
        p.mudarPoluicao(efeitos[2]);
    }

}