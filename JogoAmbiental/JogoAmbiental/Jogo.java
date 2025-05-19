import java.util.*;

public class  Jogo {

    // Atributos
    private Personagem jogador;
    private Personagem adversario;
    private List<Evento> eventos;

    // Metodo
    public void iniciar() {
        // Mensagem inicial do jogo
        System.out.println("Bem-vindo ao EcoMetrópole RPG!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o nome do personagem: (Sugestão: Dollynho)");
        System.out.print("> ");
        String nomePersonagem = scanner.nextLine();

        // Instancia os objetos
        jogador = new Personagem(nomePersonagem);
        adversario = new Personagem("Pennywise");

        List<String> respostas = new ArrayList<>();
        List<String> itens = new ArrayList<>(Arrays.asList("Mascara", "Energético", "Medalha"));
        int resisteciaPoluicao = 2;


        //Blog
        Post post = new Post();
        criarPosts(post);

        System.out.println("\n" + jogador.getNome() + " faz um post em seu blog: ");
        System.out.println("-------------".repeat(3));
        System.out.println("Título: " + post.getTitulo());
        System.out.println("-------------".repeat(3));
        System.out.println(post.getDescricao());
        System.out.println("-------------".repeat(3));

        //Tutorial
        System.out.println("\nDepois de seu post, você vai fazer sua caminhada matinal como todos os dias,\n" +
                "mas durante sua caminhada, voce se depara com diversas escolhas que precisa tomar.\n" +
                "\nRegras:");
        System.out.println("1 - Você começa com os seguintes atributos: Energia: 100 | Conscientização: 20 | Poluição: 20");
        System.out.println("2 - Seu trabalho é lutar contra a poluição e não deixá-la chegar a 100 ou ela pode te matar.");
        System.out.println("3 - Cada decisão importa, ou seja, afetará seus atributos e o seu final.");
        System.out.println("4 - Eu vou saber caso suas interações com outros personagens sejam compostas por caracteres aleatórios.");
        System.out.println("5 - Você precisa tomar as decisões corretas pelos próximos 5 dias.");
        System.out.println("6 - Você pode escrever a palavra \"inventário\" para usar e ver seus itens.");
        System.out.println("7 - Você tem um adversário chamado Pennywise. Seu objetivo é ter um denempenho melhor que o dele.");


        //Eventos
        criarEventos();

        Collections.shuffle(eventos);

        int eventoIndex = 0;

        // Lógica de dias no jogo
        for (int dia = 1; dia <= 5; dia++) {
            System.out.println("\n Dia " + dia + ":");

            for (int i = 0; i < 5; i++) {

                // Caso a poluiçao chegue a 100
                if (!jogador.estaVivo()) {
                    System.out.println(jogador.getNome() + ": \"Passei acreditando que cada ação pudesse ajudar a construir um futuro melhor.\nAchava que, se eu conseguisse convencer uma pessoa, já estaria tornando o mundo um lugar mais justo, e que a razão sempre prevaleceria.\nMas, agora, doente, vejo rios poluídos, árvores caídas e ouço o silêncio onde antes havia esperança.\"");
                    System.out.println("Então me pergunto: foi tudo em vão?");
                    System.out.println("Você não resistiu aos impactos ambientais...");
                    return;
                }

                if (eventoIndex >= eventos.size()) {
                    Collections.shuffle(eventos);
                    eventoIndex = 0;
                }

                Evento e = eventos.get(eventoIndex);
                e.apresentarEvento(jogador, jogador.getInventario());
                eventoIndex++;

            }

            if (dia == 1) {
                System.out.println(jogador.getNome() + " chegou em casa e teve a notícia que um post viralizou e há diversos sobre este post.");
            }
            System.out.println("Você decide responder o seguinte comentário que chamou sua atenção: ");
            System.out.println(post.chooseComents(dia-1).toString());
            System.out.println("Qual será a sua resposta em relação ao comentário?");
            String resposta = scanner.nextLine();
            respostas.add(resposta);

            // Verifica se os comentários sao coerentes.
            if (post.checkAnswer(resposta)) {
                System.out.println("Voce fez um bom comentário.");
                jogador.mudarEnergia(-5);
                jogador.mudarConscientizacao(5);
                System.out.println("Os atributos de "+jogador.getNome()+" são:");
                jogador.mostrarAtibutos();
                System.out.println("Os atributos de Pennywise são: ");
                adversario.mudarEnergia(15);
                adversario.mudarConscientizacao(2*dia+3);
                adversario.mudarPoluicao(2*dia+10);
                adversario.mostrarAtibutos();

                // Adiciona os itens ao inventário
                if (dia <= 3) {
                    jogador.addItem(itens.get(dia-1));
                    System.out.println("Voce ganhou um item:" + itens.get(dia-1));
                }


            } else {
                System.out.println("Comentário ruim.");
                jogador.mudarEnergia(-5);
                jogador.mudarConscientizacao(-5);
                jogador.mudarPoluicao(5+resisteciaPoluicao);
                System.out.println("Os atributos de "+jogador.getNome()+" são:");
                jogador.mostrarAtibutos();
                adversario.mudarEnergia(-10);
                adversario.mudarConscientizacao(10);
                adversario.mudarPoluicao(-1);
                System.out.println("Os atributos de Pennywise são: ");
                adversario.mostrarAtibutos();
            }
        }

        //Mensagem se o jogador vence e perde no final do jogo
        if ((jogador.venceu())&&jogador.getConscientizacao()>adversario.getConscientizacao() && jogador.getPoluicao()<adversario.getPoluicao() ){
            System.out.print(jogador.getNome() + ": \"Por tanto tempo, eu andei contra a corrente. Que vezes me chamaram de ingênuo, um sonhador, fora da casinha?\nUsei palavras, fiz coisas, tive paciência — não pra ganhar holofote, mas por viver, pela Terra chorando, em silêncio.\nAgora, vejo pela janela árvores no lugar da fumaça, água limpa onde só tinha lixo…\nAcredito, no fim, que tudo teve seu valor.\"");
            System.out.println("\nAlém disso, consegui um desempenho melhor que meu adversário Pennywise.");
            System.out.println("\nParabéns! Você sobreviveu e se tornou um exemplo ambiental!");

        } else {
            System.out.print(jogador.getNome() + ": \"Eu lutei pela Terra, falei em seu nome e convenci muitas pessoas. Mas só agora, depois de tudo, percebo que também fiz parte do problema.\nAcreditei que era suficiente plantar árvores e mover corações, mas ignorei as vezes em que escolhi o conforto em vez da coerência, \nou quando abandonei a busca para a complexidade do mundo, na esperança de encontrar respostas fáceis.\"");
            System.out.println("\nMesmo com um desempenho mediocre, Pennywise conseguiu fazer um trabalho melhor que o meu. Acho que o subestimei.");
            System.out.println("\nVocê sobreviveu, mas ainda falta muito para ser um cidadão consciente.");
        }

        // Mensagem final do jogo
        System.out.println("Todos os seus comentarios: ");
        for (String resp : respostas) {
            System.out.println("-------".repeat(3));
            System.out.println(resp);


        }

        System.out.println("-------".repeat(3));
        jogador.showHistoricoInventario();
    }

    // Metodo
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

    private void criarPosts(Post post) {
        post.setTitulo("Luta pela Poluição");
        post.setDescricao("A gente compra produtos “verdes” embalados em plástico. Fala de sustentabilidade enquanto está voando para conferências sobre o clima.\n" +
                "A gente defende o planeta nas redes sociais, mas acaba clicando em links que vendem conveniência disfarçada de avanço.\n" +
                "A batalha contra a poluição é mais sutil do que parece. Ela se esconde por trás de slogans e boas intenções.\n" +
                "Talvez o primeiro passo verdadeiro para enfrentá-la seja deixar de nos enxergar como os salvadores — e passar a nos ver como cúmplices desse problema.");
        post.addToComents("Finalmente alguém está fazendo algo. Estamos todos envolvidos nisso.");
        post.addToComents(jogador.getNome() + " está tomando atitudes sustentáveis. Mas será que é o suficiente?");
        post.addToComents("Mais um ambientalista querendo pagar de herói do planeta. Tô fora.");
        post.addToComents("Concordo as atitudes de " +jogador.getNome() +". Mas o jeito que ele fala e age parece arrogante.");
        post.addToComents("As atitudes de "+jogador.getNome()+" são necessárias. De difícil execução mas verdadeiras.");

    }
}
