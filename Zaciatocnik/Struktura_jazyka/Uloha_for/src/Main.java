public class Main {

    public static void main(String[] args) {

        for(int j = 4; j>0; j--) {
            for (int i = 1; i < j+1; i++){
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();

        for(int j = 1; j<5; j++){
            for (int i = 1; i < j+1; i++){
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();

        for(int j = 1; j<5; j++){
            for(int i = 1; i<5; i++) {
                if(i==j)
                    System.out.print("_");
                else
                System.out.print(i);
            }
            System.out.println();
        }





    }
}
