public class FaseIncendio {
    private double vegetacao;
    private double queimada;
    private double k;
    private int turno;
    private int turnoi;
    private int turnof;
   // private boolean ajuda;
   // private boolean renovavel;

    public void conseguirApoio(boolean ajuda){
        turno=0;
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
        System.out.println("turno: "+turno);
        for ( turnoi=0; turnoi<=turno ; turnoi++) {
            vegetacao = -0.25 * turnoi * turnoi  + 100;
            queimada = 0.25*turnoi*turnoi;
            System.out.println("Estado da vegetação: "+vegetacao);
            System.out.println("Turnoi atual: "+turnoi);
            System.out.println("Turno atual: "+turno);
            for (turnof=6; turnof<=20;turnof++){
                queimada = 0.25*turnof*turnof-(turnof-turnoi)*(turnof-turnoi)*(turnof-turnoi)*k;
                System.out.println("Estado da vegetacao: "+vegetacao);
                if (queimada<=0){
                    break;
                }
            }
        }
    }
}
