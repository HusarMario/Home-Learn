import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String text = ("Alebo Na vyhľadávanie použi postup hľadania a porovnávania po znakoch." +
                " Pri porovnaní zhody znakov je povolené použiť len charAt metódu v Stringu." +
                " Cykly, pomocné premenné alebo podmienky, alebo samozrejme môžeš použiť alebo");

        String word = ("alebo");

        findWord(text, word);
    }

    static boolean alphabet(char c){
        char [] alphabet = new char[52];
        int alphabetnum = 0;
        for(int i = 65; i<123; i++)
        {
            if(i<91||i>96) {
                alphabet[alphabetnum] = (char) i;
                alphabetnum++;
            }
        }

        for (char chars : alphabet) {
            if(chars == c)
                return false;
        }

        return true;
    }

    static void findWord(String text, String word) {
        text = text.toLowerCase();
        word = word.toLowerCase();
        int wordcount = 0;

        for (int i = 0; i < text.length() - word.length() + 1; i++) {
            if (text.charAt(i) == word.charAt(0))
                if((i == 0)||(alphabet(text.charAt(i-1))))
                    for (int j = 0; j < word.length(); j++) {
                        if (text.charAt(i + j) == word.charAt(j)) {
                            if (word.length() == j + 1)
                                if((i+j<text.length())||(alphabet(text.charAt(i+j+1))))
                                    wordcount++;
                        }
                        else
                            break;
                    }
        }

        System.out.println(wordcount);
    }

}
