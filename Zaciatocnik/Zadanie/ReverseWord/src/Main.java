import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        reverseStrings(input.nextLine());
    }

    static void reverseStrings(String original){
        String [] split = original.split(" ");
        char [] reverse = new char [original.length()];
        int j = 0;

        for(int i = 0; i<split[0].length(); i++){
            reverse[j] = split[0].charAt(split[0].length()-i-1);
            j++;
        }

        reverse[j] = ' ';
        j++;

        for(int i = 0; i<split[1].length(); i++){
            reverse[j] = split[1].charAt(split[1].length()-i-1);
            j++;
        }

        System.out.println(reverse);
    }

}

