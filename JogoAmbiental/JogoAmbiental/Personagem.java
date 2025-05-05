import java.util.ArrayList;
import java.util.List;

public class Personagem {

    // Atributos
    private String nome;
    private int energia;
    private int conscientizacao;
    private int poluicao;

    private List<String> inventario = new ArrayList<>();

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

    // Metodos
    public void mudarEnergia(int valor) {
        energia = Math.max(0, Math.min(100, energia + valor));
    }

    public void mudarConscientizacao(int valor) {
        conscientizacao = Math.max(0, Math.min(100, conscientizacao + valor));
    }

    public void mudarPoluicao(int valor) {
        poluicao = Math.max(0, Math.min(100, poluicao + valor));
    }

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
    }

    // Mostra o inventário
    public void showInventario() {
        if (inventario.size() > 0) {
            System.out.println("Inventario: ");
            for (int i=0; i < inventario.size(); i++) {
                System.out.println((i + 1) + " - " + inventario.get(i));
            }
        } else {
            System.out.println("Seu inventário está vazio.");
        }
    }
}