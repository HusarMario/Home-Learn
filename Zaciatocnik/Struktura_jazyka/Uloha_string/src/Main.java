public class Main {

    public static void main(String[] args) {

        String word1 = "Liska";
        String word2 = "Kocur";
        String word3 = "Liska";
        String word4 = "Kocour";
        String word5 = "liska";
        String word6 = "KOCUR";

        allUpper(word1);
        System.out.println(allUpper(word3));

        compareStrings(word1,word2);
        compareStrings(word1,word3);
        compareStrings(word2,word6);

        System.out.println(compareStringsBoo(word1,word2));
        System.out.println(compareStringsBoo(word1,word3));
        System.out.println(compareStringsBoo(word2,word6));
    }

    static String allUpper(String word){

        System.out.println(word.toUpperCase());
        return word.toUpperCase();
    }

    static void compareStrings(String word1, String word2){
        if (word1.equals(word2))
            System.out.println("True");
        else
            System.out.println("False");
    }

    static boolean compareStringsBoo(String word1, String word2){
        return word1.equals(word2);
    }





}
