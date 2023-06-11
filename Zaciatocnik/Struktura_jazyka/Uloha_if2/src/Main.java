public class Main {

    public static void main(String[] args) {

        fizzBuzz(45);
        fizzBuzz(56);
        fizzBuzz(18);
        fizzBuzz(25);

    }

        static void fizzBuzz(int number){
            if((number % 3 == 0) && (number % 5 ==0))
                System.out.println("FizzBuzz");
            else if (number % 3 == 0)
                System.out.println("Fizz");
            else if (number % 5 == 0)
                System.out.println("Buzz");
        }

}
