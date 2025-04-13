public class Personagem {
    private String nome;
    private int energia;
    private int conscientizacao;
    private int poluicao;

    public Personagem(String nome) {
        this.nome = nome;
        this.energia = 100;
        this.conscientizacao = 20;
        this.poluicao = 20;
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public int getConscientizacao() {
        return conscientizacao;
    }

    public int getPoluicao() {
        return poluicao;
    }

    public void setEnergia(int valor) {
        energia = Math.max(0, Math.min(100, energia + valor));
    }

    public void setconscientizacao(int valor) {
        conscientizacao = Math.max(0, Math.min(100, conscientizacao + valor));
    }

    public void setPoluicao(int valor) {
        poluicao = Math.max(0, Math.min(100, poluicao + valor));
    }

    public boolean estarVivo() {
        return energia > 0 && poluicao < 100;
    }

    public boolean venceu () {
        return conscientizacao >= 80 && estarVivo();
    }
}
