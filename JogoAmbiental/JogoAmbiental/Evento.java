 import java.util.Scanner;

public class Evento {
    private String descricao;
    private String opcao1;
    private String opcao2;
    private int[] efeitosOpcao1;
    private int[] efeitosOpcao2;

    public Evento(String descricao, String opcao1, int[] efeitos1, String opcao2, int[] efeitos2) {
        this.descricao = descricao;
        this.opcao1 = opcao1;
        this.efeitosOpcao1 = efeitos1;
        this.opcao2 = opcao2;
        this.efeitosOpcao2 = efeitos2;
    }

    public void apresentarEvento(Personagem p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + descricao);
        System.out.println("1 - " + opcao1);
        System.out.println("2 - " + opcao2);
        System.out.print("Escolha (1 ou 2): ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            aplicarEfeitos(p, efeitosOpcao1);
        } else {
            aplicarEfeitos(p, efeitosOpcao2);
        }

        System.out.println("Energia: " + p.getEnergia() +
                " | Conscientização: " + p.getConscientizacao() +
                " | Poluição: " + p.getPoluicao());
    }

    private void aplicarEfeitos(Personagem p, int[] efeitos) {
        p.mudarEnergia(efeitos[0]);
        p.mudarConscientizacao(efeitos[1]);
        p.mudarPoluicao(efeitos[2]);
    }
}