import java.util.*;
import java.util.logging.Filter;

public class Main {

    public static void main(String[] args) {

        List<String> cities;

        String textwiki = "Banská Bystrica, Banská Štiavnica, Bardejov, Bánovce nad Bebravou, Brezno, Bratislava, " +
                "Turčianske Teplice, Tvrdošín, Veľký Krtíš, Vranov nad Topľou, Zlaté Moravce, Zvolen, Žarnovica, Žiar nad Hronom, Žilina";

        cities = Arrays.asList(textwiki.split(", "));

        //printCities(cities);

        //System.out.println();

        //printFiltrated(cities, s -> !s.contains(" "));

        //System.out.println();

        //printFiltrated(cities, s -> s.startsWith("B"));



        int number1 = 5;
        int number2 = 15;

        addToNum(number1,i -> System.out.println(i+number2));
    }

    static void addToNum(int i, Process process){
        process.process(i);
    }

    interface Process {
        void process(int i);
    }












    static void printCities(List<String> cities){
        for(String city:cities){
            System.out.println(city);
        }
    }

    static void printFiltrated(List<String> cities, Filter filter){
        for(String city:cities){
            if(filter.filtrated(city))
                System.out.println(city);
        }
    }

    interface Filter{
        boolean filtrated(String s);
    }



}

