import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Jogo {
    private Personagem jogador;
    private List<Evento> eventos;

    public void iniciar() {
        System.out.println("Bem-vindo ao EcoMetrópole RPG!");
        jogador = new Personagem("Dollynho");
        criarEventos();

        Collections.shuffle(eventos);

        int eventoIndex = 0;

        for (int dia = 1; dia <= 5; dia++) {
            System.out.println("\n Dia " + dia + ":");

            for (int i = 0; i < 5; i++) {
                if (!jogador.estaVivo()) {
                    System.out.println("Você não resistiu aos impactos ambientais...");
                    return;
                }

                if (eventoIndex >= eventos.size()) {
                    Collections.shuffle(eventos);
                    eventoIndex = 0;
                }

                Evento e = eventos.get(eventoIndex);
                e.apresentarEvento(jogador);
                eventoIndex++;
            }
        }

        if (jogador.venceu()) {
            System.out.println("\nParabéns! Você sobreviveu e se tornou um exemplo ambiental!");
        } else {
            System.out.println("\nVocê sobreviveu, mas ainda falta muito para ser um cidadão consciente.");
        }
    }
    
    private void criarEventos() {
        eventos = new ArrayList<>();

        eventos.add(new Evento(
            "Você vê uma garrafa plástica jogada na rua.",
            "Pegar e reciclar (+10 cons, -2 energia)", new int[]{-2, 10, -5},
            "Ignorar e seguir em frente", new int[]{0, 0, 5}
        ));

        eventos.add(new Evento(
            "Choveu muito durante a noite e a rua está alagada.",
            "Procurar outro caminho (+2 poluição)", new int[]{-5, 2, 2},
            "Tentar atravessar mesmo assim (-15 energia, +5 poluição)", new int[]{-15, 0, 5}
        ));

        eventos.add(new Evento(
            "Um grupo propõe plantar árvores no bairro.",
            "Participar (+15 cons, -5 energia)", new int[]{-5, 15, -5},
            "Recusar", new int[]{0, 0, 5}
        ));

        eventos.add(new Evento(
            "Você tem a opção de usar transporte público ou carro.",
            "Usar transporte público (+5 cons)", new int[]{0, 5, -5},
            "Usar carro particular (+10 poluição)", new int[]{0, 0, 10}
        ));

        eventos.add(new Evento(
            "Você percebe que seu vizinho está queimando lixo no quintal.",
            "Conversar e alertá-lo sobre os riscos (+10 cons)", new int[]{-2, 10, -5},
            "Ignorar a situação", new int[]{0, 0, 8}
        ));

        eventos.add(new Evento(
            "Há uma campanha para reduzir o uso de sacolas plásticas.",
            "Levar sacola reutilizável ao mercado (+5 cons)", new int[]{0, 5, -2},
            "Usar sacolas plásticas normalmente", new int[]{0, 0, 4}
        ));

        eventos.add(new Evento(
            "Seu chuveiro está vazando água.",
            "Consertar imediatamente (-5 energia, +5 cons)", new int[]{-5, 5, -2},
            "Deixar para depois", new int[]{0, 0, 3}
        ));

        eventos.add(new Evento(
            "Um amigo convida para um piquenique em área verde urbana.",
            "Aceitar e aproveitar o contato com a natureza (+5 cons, -2 poluição)", new int[]{0, 5, -2},
            "Recusar e ficar em casa", new int[]{0, 0, 0}
        ));

        eventos.add(new Evento(
            "Você vê um animal silvestre ferido na rua.",
            "Ligar para um órgão ambiental (+10 cons)", new int[]{-3, 10, -2},
            "Ignorar e seguir", new int[]{0, 0, 2}
        ));

        eventos.add(new Evento(
            "Uma lixeira reciclável está próxima, mas a comum está mais perto.",
            "Separar o lixo e ir até a reciclável (+5 cons)", new int[]{-1, 5, -1},
            "Jogar no lixo comum", new int[]{0, 0, 3}
        ));

        eventos.add(new Evento(
            "Você é convidado para participar de uma limpeza comunitária em um parque.",
            "Participar da ação voluntária (+15 cons, -10 energia)", new int[]{-10, 15, -5},
            "Recusar e descansar", new int[]{5, 0, 2}
        ));

        eventos.add(new Evento(
            "Você encontra uma campanha sobre compostagem de resíduos orgânicos.",
            "Participar e aprender (+10 cons)", new int[]{-2, 10, -3},
            "Ignorar a informação", new int[]{0, 0, 2}
        ));
        
        eventos.add(new Evento(
    	    "Seu prédio propõe trocar as lâmpadas comuns por LED.",
    	    "Apoiar a proposta (+5 cons, -3 poluição)", new int[]{0, 5, -3},
    	    "Ignorar e manter o padrão atual", new int[]{0, 0, 2}
    	));

    	eventos.add(new Evento(
    	    "Você precisa imprimir um documento de 10 páginas.",
    	    "Imprimir frente e verso (+3 cons)", new int[]{0, 3, -1},
    	    "Imprimir página por página", new int[]{0, 0, 2}
    	));

    	eventos.add(new Evento(
    	    "Um influenciador está promovendo consumo consciente de roupas.",
    	    "Compartilhar e aderir à ideia (+7 cons)", new int[]{-1, 7, -2},
    	    "Ignorar e seguir consumindo moda rápida", new int[]{0, 0, 3}
    	));

    	eventos.add(new Evento(
    	    "Você observa acúmulo de lixo em um terreno baldio perto de casa.",
    	    "Reportar à prefeitura (+8 cons)", new int[]{-1, 8, -4},
    	    "Fingir que não viu", new int[]{0, 0, 5}
    	));

    	eventos.add(new Evento(
    	    "Seu computador está ligado sem uso há horas.",
    	    "Desligar e economizar energia (+2 cons)", new int[]{0, 2, -1},
    	    "Deixar ligado", new int[]{0, 0, 2}
    	));

    	eventos.add(new Evento(
    	    "Uma feira de produtos orgânicos acontece em seu bairro.",
    	    "Visitar e aprender (+5 cons, -2 poluição)", new int[]{-2, 5, -2},
    	    "Ignorar e comprar produtos industrializados", new int[]{0, 0, 2}
    	));

    	eventos.add(new Evento(
    	    "Seu amigo joga bitucas de cigarro na rua.",
    	    "Repreender e conscientizar (+6 cons)", new int[]{-1, 6, -1},
    	    "Deixar pra lá", new int[]{0, 0, 3}
    	));

    	eventos.add(new Evento(
    	    "Há uma goteira em seu tanque e ela pinga o dia todo.",
    	    "Chamar um encanador (-3 energia, +4 cons)", new int[]{-3, 4, -2},
    	    "Ignorar o vazamento", new int[]{0, 0, 4}
    	));
    	
    	eventos.add(new Evento(
	    "A escola do bairro está organizando uma palestra sobre sustentabilidade.",
	    "Ir à palestra (+7 cons)", new int[]{-2, 7, -1},
	    "Não participar", new int[]{0, 0, 1}
	));

	eventos.add(new Evento(
	    "Você nota que a calçada está tomada por entulho de obra.",
	    "Denunciar para órgãos públicos (+6 cons)", new int[]{-1, 6, -3},
	    "Deixar como está", new int[]{0, 0, 4}
	));

	eventos.add(new Evento(
	    "No supermercado, há uma promoção de produtos a granel.",
	    "Aproveitar e evitar embalagens (+5 cons)", new int[]{-1, 5, -2},
	    "Comprar produtos embalados", new int[]{0, 0, 2}
	));

	eventos.add(new Evento(
	    "Você encontra pilhas usadas jogadas em uma lixeira comum.",
	    "Separar e levar ao ponto de coleta (+8 cons)", new int[]{-2, 8, -3},
	    "Ignorar e seguir", new int[]{0, 0, 3}
	));

	eventos.add(new Evento(
	    "Seu bairro organizou um mutirão de coleta de óleo de cozinha usado.",
	    "Contribuir com o óleo usado de casa (+6 cons)", new int[]{-1, 6, -2},
	    "Não participar", new int[]{0, 0, 2}
	));

    }
}
