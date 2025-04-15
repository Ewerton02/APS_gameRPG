public class FaseIncendio {
    private double vegetacao;
    private double queimada;
    private double k;
    private int turno;
    private int turnoi;

    public void conseguirApoio(boolean ajuda){
        turno=1;
        System.out.println("Turno Atual: "+turno);
        System.out.println("Você foi informado que no há uma queimada em uma floresta nas proximidades da cidade " +
                "\num incêndio. Devido aos acontecimentos recentes, há uma quantidade significativa de bombeiros" +
                "\nincapacitados. Uma possível maneira de contornar este problema seria pedir ajuda de voluntários." +
                "\nVocê dever decidir se deve gastar algum tempo e pedir ajuda de voluntários ou" +
                "\ndecidir partir imediatamente.");
        if (ajuda){
            turno=3;
            k=0.5;
        }
        else{
            turno=1;
            k=0.00875;
        }
        System.out.println("turno: "+turno);
    }

    public void combateAoIncendio(boolean renovavel){
        System.out.println("Agora você deve decidir qual o método para se locomover para o local de incêndio. Caso" +
                "\nescolha ir com combustível renovável, seu grupo irá chegar ao local em 3 turnos. Caso escolha o " +
                "\ncombustível não renovável, chegará ao destinho em um turno." +
                "\nDeseja escolher o combustível renovável?");
        System.out.println("turno: "+turno);
        if (renovavel){
            turno=turno +3;
        }
        else{
            turno=turno +1;
        }
        System.out.println("turno antes de ir apagar o incendio: "+turno);
        for ( turnoi=turno; turnoi<=20 ; turnoi++) {
            vegetacao = -0.25 * turnoi * turnoi  + 100;
            System.out.println("Turnoi atual: "+turnoi);
            queimada = 0.25*turnoi*turnoi-(turnoi-turno)*(turnoi-turno)*(turnoi-turno)*k;
            System.out.println("Estado da vegetacao: "+vegetacao);
            System.out.println("'Poder de fogo': "+queimada);
            if (queimada<=0) {
                System.out.println("A queimada foi parada e a vegetação preservada foi de "+vegetacao);
                if(vegetacao>=77) {
                    System.out.println("Você conseguiu conter boa parte da flora e fauna ao redor da cidade. É provável" +
                            "\n que a situação seja revertida e a área verde consiga se regenerar.");
                }
                else{
                    System.out.println("Boa parte da área florestal perto da cidade foi destruida. É incerto se a região" +
                            "\n se a região próxima da região será revertida.");
                }
                break;
            }
            if (vegetacao==0){
                System.out.println("Infelizmente você não conseguiu apagar o incêndio na região florestal próxima à " +
                        "\ncidade. Como consequência, muitos gases nocivos foram liberados, influenciando a qualidade+" +
                        "\ndo ar da metrópole. Além disso, a flora e fauna próxima foram destruidas o que pode " +
                        "\ncontribuir para a desertificação da cidade.");
                break;
            }
        }
    }
}
