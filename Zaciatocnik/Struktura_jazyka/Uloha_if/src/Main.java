public class Main {

    public static void main(String[] args) {

        // 1 - Positive or negative

        int getNum = 50;
        if(getNum > 0)
            System.out.println("Cislo je kladne");
        else if(getNum < 0)
            System.out.println("Cislo je zaporne");
        else
            System.out.println("Cislo je 0");

        // 2 - Omeleta
        boolean hunger = true;
        boolean eggs = true;
        boolean pan = true;
        boolean oil = true;
        boolean salt = true;
        boolean shopOpen = true;


        if(hunger == true){
            System.out.println("Skontroluj potraviny!");

            if(eggs==true && pan==true && oil==true && salt==true) {
                System.out.println("Mozes spravit omeletu!");
                hunger = false;
            }else{
                System.out.println("Musis nakupit potraviny!");
                if(shopOpen==true){
                    if(eggs==false)
                        eggs=true;
                    if(pan==false)
                        pan=true;
                    if(oil==false)
                        oil=true;
                    if(salt==false)
                        salt=true;
                    System.out.println("Nakupil si vsetky potraviny!");
                    System.out.println("Mozes spravit omeletu");
                    hunger = false;
                }else{
                    System.out.println("Bohuzial obchod je zatvoreny!");
                    System.out.println("Objednaj si radsej pizzu!");
                }
            }
        }else System.out.println("Nie si hladny!");

        // 3 - Number of day

        int dayNum = 5;

        if (dayNum > 0 && dayNum < 8) {
            if (dayNum == 1)
                System.out.println("Pondelok");
            else if (dayNum == 2)
                System.out.println("Utorok");
            else if (dayNum == 3)
                System.out.println("Streda");
            else if (dayNum == 4)
                System.out.println("Stvrtok");
            else if (dayNum == 5)
                System.out.println("Piatok");
            else if (dayNum == 6)
                System.out.println("Sobota");
            else if (dayNum == 7)
                System.out.println("Nedela");
        }else System.out.println("Nespravny vstup -> vloz cislo 1-7");

        // 4 - Highest number

        int a = 52;
        int b = 122;
        int c = 8;

        if(a>=b && a>=c)
            System.out.println("Najvyssie cislo je cislo a ---> " + a);
        else if(b>=a && b>=c)
            System.out.println("Najvyssie cislo je cislo b ---> " + b);
        else if(c>=a && c>=b)
            System.out.println("Najvyssie cislo je cislo c ---> " + c);

        // 5 - Low to high

        int x = 5;
        int y = 4;
        int z = 7;

        int first = 0;
        int second = 0;
        int third = 0;

        if(x>=y && x>=z)
            first = x;
        else if(y>=x && y>=z)
            first = y;
        else if(z>=x && z>=y)
            first = z;

        if(x<=y && x<=z)
            third = x;
        else if(y<=x && y<=z)
            third = y;
        else if(z<=x && z<=y)
            third = z;

        if((first == x && third == y) || (first == y && third == x))
            second = z;
        if((first == z && third == y) || (first == y && third == z))
            second = x;
        if((first == x && third == z) || (first == z && third == x))
            second = y;

        System.out.println("Poradie cisel je : " + third +" "+ second +" "+first);
    }
}
