public class Alternativa {

    // Atributos
    private String texto;

    // Construtores
    public Alternativa() {
    }

    public Alternativa(String texto) {
        this.texto = texto;
    }

    //Getters e Setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    // Metodos
    @Override
    public String toString() {
        return texto + "\n";
    }
}
