import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personagem {

    // Atributos
    private String nome;
    private int energia;
    private int conscientizacao;
    private int poluicao;

    private List<String> inventario = new ArrayList<>();

    private List<String> historicoInventario = new ArrayList<>();

    // Construtor
    public Personagem(String nome) {
        this.nome = nome;
        this.energia = 100;
        this.conscientizacao = 20;
        this.poluicao = 20;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public int getEnergia() { return energia; }
    public int getConscientizacao() { return conscientizacao; }
    public int getPoluicao() { return poluicao; }
    public List<String> getInventario() { return inventario; }
    public List<String> getHistoricoInventario() { return historicoInventario; }


    public void mudarEnergia(int valor) {
        energia = Math.max(0, Math.min(100, energia + valor));
    }

    public void mudarConscientizacao(int valor) {
        conscientizacao = Math.max(0, Math.min(100, conscientizacao + valor));
    }

    public void mudarPoluicao(int valor) {
        poluicao = Math.max(0, Math.min(100, poluicao + valor));
    }

    // Metodos
    // Verifica se o personagem esta vivo
    public boolean estaVivo() {
        return energia > 0 && poluicao < 100;
    }

    // Verifica se o jogador venceu
    public boolean venceu() {
        return conscientizacao >= 80 && estaVivo();
    }

    //Mostar os atributos
    public void mostrarAtibutos() {
        System.out.println("------------------".repeat(3));
        System.out.println("Energia: " + energia +
                " | Conscientização: " + conscientizacao +
                " | Poluição: " + poluicao);
        System.out.println("------------------".repeat(3));
    }

    // Adiciona itens ao inventario
    public void addItem(String item) {
        inventario.add(item);
        historicoInventario.add(item);
    }

    // Mostra o inventário
    public void showInventario() {
        if (inventario.size() > 0) {
            System.out.println("Inventario: ");
            for (int i=0; i < inventario.size(); i++) {
                System.out.println((i) + " - " + inventario.get(i));
            }
        } else {
            System.out.println("Seu inventário está vazio.");
        }
    }

    public void showHistoricoInventario() {
        if (historicoInventario.size() > 0) {
            System.out.println("Itens obtidos ao longo da história: ");
            for (int i=0; i < historicoInventario.size(); i++) {
                System.out.println((i) + " - " + historicoInventario.get(i));
            }
        } else {
            System.out.println("Seu inventário está vazio.");
        }
    }

    public void useItem(List<String> inventario) {
        if (inventario.size() <= 0) {
            return;
        }
        System.out.print("Escolha o número do seu item: \n>");
        Scanner scanner = new Scanner(System.in);
        int indexItem = scanner.nextInt();
        // Tratando a exceção caso o jogador digite uma string
        try {
            if (indexItem >= 0 && indexItem < inventario.size()) {

                switch (inventario.get(indexItem)) {
                    case "Mascara":
                        mudarPoluicao(getPoluicao() - 5);
                        System.out.println("Você usou a Mascara: - 5 Poluição");
                        System.out.print("Sua resposta para a pergunta acima:\n>");
                        break;

                    case "Energético":
                        mudarEnergia(getEnergia() + 5);
                        System.out.println("Você usou o Energético: + 5 Energia");
                        System.out.print("Sua resposta para a pergunta acima:\n>");
                        break;

                    case "Medalha":
                        mudarConscientizacao(getConscientizacao() + 5);
                        System.out.println("Você usou a Medalha: + 5 Conscientização");
                        System.out.print("Sua resposta para a pergunta acima:\n>");
                        break;

                    default:
                        System.out.println("Você digitou um número fora do seu inventário.");
                        System.out.println("Você saiu do inventário.");
                        break;

                }

                inventario.remove(indexItem);
            } else {
                System.out.println("Número inválido.");
                System.out.println("Você saiu do inventário.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Digite um número.");
        }

    }
}