public class Main {


    static int number = 20;

    public static void main(String[] args) {

        addNums(5,6);
        addNums(7,6);
        addNums(9,10);

        addNums(9,4,3);
        addNums(9, 81, 20);
        addNums(1, 3, 2);

        System.out.println(calculateNums(5,6));
        System.out.println(calculateNums(7,6));
        System.out.println(calculateNums(9,10));

        System.out.println(calculateNums(9,4,3));
        System.out.println(calculateNums(9,81,20));
        System.out.println(calculateNums(1,3,2));

        System.out.println(suma(10));
        System.out.println(suma(20));
        System.out.println(suma(11));

        System.out.println(globalVar(15));
        System.out.println(globalVar(20));
        System.out.println(globalVar(25));




    }

    static void addNums(int a, int b){
        System.out.println(a+b);
    }

    static void addNums(int a,int b,int c){
        System.out.println((a+b+c));
    }

    static int calculateNums(int a,int b){
        int result;
        result = a + b;
        return result;
    }

    static int calculateNums(int a,int b, int c){
        int result;
        result = a+b+c;
        return result;
    }

    static int suma(int num){
        int sum = 0;

        if(num>0){
            num--;
            sum = suma(num);
            num++;
        }

        sum = sum + num;
        return sum;
    }

    static int globalVar(int number){
        return number + Main.number;
    }

}
