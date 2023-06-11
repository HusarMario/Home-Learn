import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception{

        //method1();

        //Person person = method2();
        //System.out.println(person.getName());
        //System.out.println(person.getSurname());

        //method3();

        //method4();

        //LocalTime time = LocalTime.now();
        //method5(time);
        //method5(time,4);

        //LocalDate birthdate = LocalDate.parse("1999-12-26");
        //method7(date);

        //LocalDate date = LocalDate.parse("2020-02-27");
        //method8(date);

    }

    static void method1(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Enter text: ");
            String input = scanner.nextLine();

            if(input.equals("q"))
            {
                System.out.println("You stopped the program.");
                break;
            }

            System.out.println(input);
            System.out.println();
        }
        scanner.close();
    }

    static Person method2(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Vytvaras novu osobu");

        System.out.print("Meno: ");
        String scanName = scanner.nextLine();
        System.out.println();

        System.out.print("Priezvisko: ");
        String scanSurname = scanner.nextLine();
        System.out.println();

        scanner.close();
        return new Person(scanName,scanSurname);

    }

    static void method3() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int number;
        try {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                throw new NumberException("Je potrebne vlozit cislo!");
            }

            System.out.println(number);
        } catch (NumberException exception){
            System.out.println(exception.getMessage());
        }
        scanner.close();

    }

    static void method4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj priklad vo formate: cislo operator cislo");

        String equasion = scanner.nextLine();
        if (equasion.matches("\\d+([+\\-*/])\\d+")){

            char[] operators = {'+','-','*','/'};
            char operator = ' ';
            for (char c : operators)
                if (equasion.lastIndexOf(c) != -1)
                    operator = c;

            String[] numbers;
            numbers = equasion.split("\\D");
            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);

            switch (operator){
                case '+' -> System.out.println(number1 +" "+operator+" "+number2+" = "+(number1+number2));
                case '-' -> System.out.println(number1 +" "+operator+" "+number2+" = "+(number1-number2));
                case '*' -> System.out.println(number1 +" "+operator+" "+number2+" = "+(number1*number2));
                case '/' -> System.out.println(number1 +" "+operator+" "+number2+" = "+(number1/number2));
            }
        }
        else
            System.out.println("Nespravny format prikladu");
    }

    static void method5(LocalTime time) {
        time = time.plusHours(8);
        System.out.println(time.truncatedTo(ChronoUnit.SECONDS));
    }

    static void method5(LocalTime time,int hours){
        time = time.plusHours(hours);
        System.out.println(time.truncatedTo(ChronoUnit.SECONDS));
    }

    static void method7(LocalDate date){
        for(int i=20;i<40;i++){
            System.out.println("V roku 20"+i+" budes mat narodeniny v "+date.withYear(i).getDayOfWeek());
        }
    }

    static void method8(LocalDate date){
        switch (date.getMonth()){
            case JANUARY -> {
                switch (date.getDayOfMonth()){
                    case 1 -> System.out.println("Den vzniku Slovenskej republiky");
                    case 6 -> System.out.println("Zjavenie Pana");
                    default -> System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case MAY -> {
                switch (date.getDayOfMonth()) {
                    case 1 -> System.out.println("Sviatok prace");
                    case 8 -> System.out.println("Den vitazstva nad fasizmom");
                    default -> System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case JULY -> {
                if (date.getDayOfMonth() == 5) {
                    System.out.println("Sviatok svateho Cyrila a Metoda");
                } else {
                    System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case AUGUST -> {
                if (date.getDayOfMonth() == 29) {
                    System.out.println("Vyrocie SNP");
                } else {
                    System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case SEPTEMBER -> {
                switch (date.getDayOfMonth()) {
                    case 1 -> System.out.println("Den ustavy SR");
                    case 15 -> System.out.println("Sedembolestna Panna Maria");
                    default -> System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case NOVEMBER -> {
                switch (date.getDayOfMonth()) {
                    case 1 -> System.out.println("Sviatok vsetkych svatych");
                    case 17 -> System.out.println("Den boja za slobodu a demokraciu");
                    default -> System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            case DECEMBER -> {
                switch (date.getDayOfMonth()) {
                    case 24 -> System.out.println("Stedry den");
                    case 25 -> System.out.println("1. sviatok vianocny");
                    case 26 -> System.out.println("2. sviatok vianocny");
                    default -> System.out.println("Dnes nie je ziadny sviatok");
                }
            }
            default -> System.out.println("Dnes nie je ziadny sviatok");
        }

    }
}
