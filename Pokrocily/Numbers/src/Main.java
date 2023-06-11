/* Napíš si metódu, ktorá na vstupe bude prijímať premennú typu Number.
Potom si túto metódu zavolaj dvakrát a vlož do nej raz int a raz Double.
Vo vnútri metódy vynásob toto číslo 10timi a vypíš na konzolu.
Naučíš sa ako pracovať s rôznymi typmi údajov. Úloha je kus náročnejšia.
Možno budeš potrebovať pretypovanie a instanceof. */

public class Main {

    public static void main(String[] args) {

        int first =  53;
        Double second = 4.7;
        Long third = 135L;

        method(first);
        method(second);
        method(third);
    }

    static void method(Number input){
        if(input instanceof Integer)
            input = (int)input * 10;

        if(input instanceof Double)
            input = (double)input * 10;

        if(input instanceof Long)
            input = (long)input * 10;

        System.out.println(input);
    }
}
