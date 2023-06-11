public class Main {

    public static void main(String[] args) {

        tvar1(3);
        System.out.println();
        tvar1(5);
        System.out.println();
        tvar2(4);
        System.out.println();
        tvar2(5);

    }

    static void tvar1(int num){
        int i;
        int j;

        for(i=num;i>0;i--){
            for(j=i;j>0;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void tvar2(int num){
        int i;
        int j;

        for(i=0;i<num;i++){
            for(j=0;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
