public class Main {

    public static void main(String[] args) {

    // 1. 1-10

        printTen();

    // 2. 1-100 even num

        printEven();

    // 3. 1-100 mod 5

        printFives();

    // 4. all odd all even

        printEvenOdd(1,7);

    // 5. Omeleta

        doOmelete();
}

    static void printTen(){
        int output = 1;

        while (output < 11){
            System.out.println(output);
            output++;
        }
    }

    static void printEven(){
        int output = 2;

        while(output < 101){
            System.out.println(output);
            output = output + 2;
        }
    }

    static void printFives(){
        int output = 5;

        while(output < 101){
            System.out.println(output);
            output = output + 5;
        }
    }

    static void printEvenOdd(int from, int to){
        int odd = 0;
        int even = 0;

        while(from<=to) {
            if (from % 2 == 0)
                even = even + from;
            else
                odd = odd + from;
            from++;
        }

        System.out.println("Even: "+ even);
        System.out.println("Odd: "+ odd );
    }


    static void doOmelete(){
        boolean hunger = true;
        int eggs = 1;
        boolean pan = true;
        boolean oil = true;
        boolean salt = true;
        boolean shopOpen = true;

        if(hunger == true){
            System.out.println("Skontroluj potraviny!");

            if(eggs>3 && pan==true && oil==true && salt==true) {
                System.out.println("Mozes spravit omeletu!");
                hunger = false;
            }else{
                System.out.println("Musis nakupit potraviny!");
                if(shopOpen==true){
                    while(eggs>2)
                        eggs = eggs+1;
                    if(pan==false)
                        pan=true;
                    if(oil==false)
                        oil=true;
                    if(salt==false)
                        salt=true;
                    System.out.println("Nakupil si vsetky potraviny!");
                    System.out.println("Mozes spravit omeletu!");
                    hunger = false;
                }else{
                    System.out.println("Bohuzial obchod je zatvoreny!");
                    System.out.println("Objednaj si radsej pizzu!");
                }
            }
        }else System.out.println("Nie si hladny!");
    }
}
