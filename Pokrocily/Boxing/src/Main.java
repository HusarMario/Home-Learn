/* Napíš si program, ktorý bude obsahovať metódy, ktoré budú na vstupe akceptovať a na výstupe vracať nasledovné typy premenných.
Metóda zoberie vstupný parameter pripočíta k nemu číslo 1 a vráti výsledok.


1. metóda – vstup: int – výstup: Integer
2. metóda – vstup: double – výstup: Double
3. metóda – vstup: long – výstup: Long
4. metóda – vstup: Integer – výstup: int
5. metóda – vstup: Double – výstup: double
6. metóda – vstup: Long – výstup: long

Na tomto príklade si precvičíš vytváranie metód a pod rukou si vyskúšaš ako funguje boxing a unboxing. */


public class Main {

    public static void main(String[] args) {

        int first = 1;
        double second = 2.3;
        long third = 3L;
        Integer fourth = 4;
        Double fifth = 5.6;
        Long sixth = 6L;

        System.out.println(first_method(first));
        System.out.println(second_method(second));
        System.out.println(third_method(third));
        System.out.println(fourth_method(fourth));
        System.out.println(fifth_method(fifth));
        System.out.println(sixth_method(sixth));
    }

    static Integer first_method(int input){
        Integer output = (input+1);
        return output;
    }

    static Double second_method(double input){
        Double output = (input+1);
        return output;
    }

    static Long third_method(Long input){
        Long output = (input+1);
        return output;
    }

    static int fourth_method(Integer input){
        int output = input+1;
        return output;
    }

    static double fifth_method(Double input){
        double output = input+1;
        return output;
    }

    static long sixth_method(Long input){
        long output = input+1;
        return output;
    }





}
