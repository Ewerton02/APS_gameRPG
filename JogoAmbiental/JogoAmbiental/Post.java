import java.util.ArrayList;
import java.util.List;

public class Post {

    // Atributos
    private String titulo;
    private String descricao;

    private List<String> comentarios = new ArrayList<>();

    // Construtores
    public Post() {
    }

    public Post(String titulo, String descrição) {
        this.titulo = titulo;
        this.descricao = descrição;
    }

    //Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Metodo
    public void addToComents(String texto) {
        comentarios.add(texto);
    }

    public String chooseComents(int index) {
        return comentarios.get(index);
    }

    public boolean checkAnswer(String txt) {

        txt = txt.toLowerCase();

        if (txt.length() < 3) return false;

        String[] palavras = {" a ", "ante", "após", "até", "com", "contra", "de", "desde", "em", "entre", "para", "per", "perante", "por", "sem", "sob", "sobre", "trás", "eu", "mas", "ou", "porque", "portanto", "contudo", "porém", "logo", "embora", "caso", "enquanto", "quando", "se", "como", "que", "pois", "assim", "todavia", "ainda que", "vc", "voce", "você", "obrigado", "muito", "é", " e ", " o "};
        for (String palavra : palavras) {
            if (txt.contains(palavra)) {
                return true;
            }
        }

        return false;
    }
}
