    public class Main {

    public static void main(String[] args) {


        priemer(5,5,5);
        priemer(1,3,5);
        priemer(3,5,2);

        den(1);
        den(6);
        den(3);
        den(12);
    }




    // Nemozno pouzit double v switch
    static void priemer(int znamka1,int znamka2,int znamka3){
        double priemer;
        priemer = ((znamka1+znamka2+znamka3)/3);

        if (priemer<1.5)
            System.out.println("Znamka : 1");
        else if (priemer<2.5)
            System.out.println("Znamka : 2");
        else if (priemer<3.5)
            System.out.println("Znamka : 3");
        else if (priemer<4.5)
            System.out.println("Znamka : 4");
        else
            System.out.println("Znamka : 5");
    }

    static void den(int num){
        switch(num) {
            case 1:
                System.out.println("Pondelok");
                break;
            case 2:
                System.out.println("Utorok");
                break;
            case 3:
                System.out.println("Streda");
                break;
            case 4:
                System.out.println("Stvrtok");
                break;
            case 5:
                System.out.println("Piatok");
                break;
            case 6:
            case 7:
                System.out.println("Vikend");
                break;
            default:
                System.out.println("Zle cislo");
        }
    }

}
