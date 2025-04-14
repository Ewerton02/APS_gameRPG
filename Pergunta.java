import java.util.ArrayList;
import java.util.List;

public class Pergunta {

    // Atributos
    //private Evento evento; -- Vou adicionar evento aqui depois que a classe for criada certinha
    private String enunciado;

    private List<Alternativa> alternativas = new ArrayList<>();

    // Construtores
    public Pergunta() {
    }

    public Pergunta(String enunciado, List<Alternativa> alternativas) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
    }

    // Getters e Setters
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    // Metodos
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(("-----".repeat(5)) + "\n"
                + enunciado + "\n"
        + ("-----".repeat(5)) + "\n");
        for (int i = 0; i < alternativas.size(); i++) {
            text.append("[" + i + "] " + alternativas.get(i));
        }

        return text.toString();

    }
}
