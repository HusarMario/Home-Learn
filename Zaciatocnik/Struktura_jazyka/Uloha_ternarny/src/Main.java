import javax.management.ListenerNotFoundException;

public class Main {

    public static void main(String[] args) {


    // 1 - %2

        mod2(3);
        mod2(8);
        mod2(0);


    // 2 - <10>

        isTen(9);
        isTen(10);
        isTen(11);

    }

    static void mod2(int number){
        System.out.println("Cislo "+number+" : "+(number%2==0 ? "je delitelne 2" : "nie je delitelne 2"));

    }

    static void isTen(int number){
        System.out.println("Cislo "+number+" je: "+(number<10 ? "< 10" : ((number>10) ? "> 10" : "10")));
    }
}
