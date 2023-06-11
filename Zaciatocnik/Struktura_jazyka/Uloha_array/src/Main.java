public class Main {

    public static void main(String[] args) {

        int[][] pole2D = new int[5][];
        pole2D[0] = new int[]{1,3,7,6,9,5,12,48};
        pole2D[1] = new int[]{8,61,31,84,31,514,9};
        pole2D[2] = new int[]{8,9,41,32,15,167,1};
        pole2D[3] = new int[]{4,13,2,8516,4,4156,15,32,15,2};
        pole2D[4] = new int[]{4,15,3,48,159,448,15,151,12,44,1};

        int[] pole1D = new int[]{1,1,2,1,2,6,1,1,1,2};

        System.out.println("Prva uloha:");
        printFirstTwo(pole2D);

        System.out.println("Druha uloha:");
        sucetSucin(pole1D);

        System.out.println("Tretia uloha:");
        sucetSucin2(pole2D);

        System.out.println("Stvrta uloha:");
        vypisIndexu(pole2D);
    }

    static void printFirstTwo(int[][] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i][0]+" "+array[i][1]);
            System.out.println();
        }
    }

    static void sucetSucin(int[] array){
        long sucet = 0;
        long sucin = 1;

        for(int i=0;i<array.length;i++){
            sucet = sucet + array[i];
            sucin = sucin * array[i];
        }

        System.out.println("Sucet cisel je : "+sucet);
        System.out.println("Sucin cisel je : "+sucin);
    }

    static void sucetSucin2(int[][] array){
        long sucet = 0;
        long sucin = 1;

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                sucet = sucet + array[i][j];
                sucin = sucin * array[i][j];
            }
        }

        System.out.println("Sucet cisel je : "+sucet);
        System.out.println("Sucin cisel je : "+sucin);
    }

    static void vypisIndexu(int[][] array){
        int arrayLength = 0;

        for(int i=0;i<array.length;i++){
            if(array[i].length > arrayLength)
                arrayLength = array[i].length;
        }

        int[] sideArray = new int[arrayLength];

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                sideArray[j] = sideArray[j]+array[i][j];
            }
        }

        for(int i=0;i<sideArray.length;i++){
            System.out.println("Riadok cislo "+(i+1)+" ma sucet hodnot vysledny "+sideArray[i]);
        }
    }
}
