import javax.print.DocFlavor;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        String text = "Jarko sa hrá s pieskom, lopatkou, kladivkom a je mu fajn.";
        String meno = " František Ferdinand Veľký";
        String change = "[header]Ac mi[/header] massa ac [code]praesent eget[/code], aliquam egestas suscipit, " +
                "potenti massa, porttitor [link:www.learn2code.sk] gravida quis ac velit facilisi[/link], imperdiet " +
                "massa rhoncus felis arcu. Ut nullam, mauris vitae, ligula quisque est.";

        System.out.println("Uloha 1");
        System.out.println(method1(text));
        System.out.println();

        System.out.println("Uloha 2");
        System.out.println(method2(text));
        System.out.println();

        System.out.println("Uloha 3");
        System.out.println(method3(text));
        System.out.println();

        System.out.println("Uloha 4");
        System.out.println(method4(text));
        System.out.println();

        System.out.println("Uloha 5");
        System.out.println(method5(text));
        System.out.println();

        System.out.println("Uloha 6");
        System.out.println(method6(text));
        System.out.println();

        System.out.println("Uloha 7");
        System.out.println(method7(meno));
        System.out.println();

        System.out.println("Uloha 8");
        System.out.println(method8(change));
        System.out.println();
    }

    static String method1(String input){
        input = input.toLowerCase();
        char[] text = input.toCharArray();

        for(int i=0;i<input.length();i++)
        {
            if(!Character.isLetter(text[i]))
            {
                text[i-1] = Character.toUpperCase(text[i-1]);
            }
        }

        StringBuilder inputBuilder = new StringBuilder();
        for (char c : text) {
            inputBuilder.append(c);
        }
        input = inputBuilder.toString();

        return input;
    }

    static String method2(String input){
        input = input.replace('a','@');
        input = input.replace('A','@');
        return input;
    }

    static String method3(String input){
        input = input.substring(0,input.lastIndexOf(','));

        return input;
    }

    static String method4(String input){
        String text1;
        String text2;

        text1 = input.substring(0,(input.indexOf(',')));
        input = input.replaceFirst(","," ");
        text2 = input.substring((input.indexOf(',')+1),(input.length()-1));

        input = text1 + text2;

        return input;
    }

    static String method5(String input){
        int words = 0;
        int chars = 0;
        int empty = 0;
        int comma = 0;
        int upper = 0;

        for(int i = 0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i)) && i+1<input.length() && !Character.isLetter(input.charAt(i+1)))
                words++;

            if(Character.isWhitespace(input.charAt(i)))
                empty++;
            else
                chars++;

            if(input.charAt(i) == ',' || input.charAt(i) == '.')
                comma++;

            if(Character.isUpperCase(input.charAt(i)))
                upper++;


        }

        if(Character.isLetter(input.charAt(input.length()-1)))
            words++;

        System.out.println("Slova : " +words);
        System.out.println("Znaky : " +chars);
        System.out.println("Empty : " +empty);
        System.out.println(". / , : " +comma);
        System.out.println("Velke : " +upper);

        return input;
    }

    static String method6(String input){
        String text1;
        String text2;

        input = input.replaceAll(",","");
        input = input.replaceAll("\\.","");

        text1 = input;
        text2 = input;

        text1 = text1.toLowerCase();
        text2 = text2.toUpperCase();

        char[] znaky1 = text1.toCharArray();
        char[] znaky2 = text2.toCharArray();

        boolean prechod = true;
        StringBuilder inputBuilder = new StringBuilder();
        for(int i=0;i<input.length();i++)
        {
            if(!Character.isLetter(input.charAt(i)))
                inputBuilder.append(znaky1[i]);
            else
                if(prechod)
                {
                    inputBuilder.append(znaky1[i]);
                    prechod = false;
                }
                else{
                    inputBuilder.append(znaky2[i]);
                    prechod = true;
                }
        }

        input = inputBuilder.toString();
        return input;
    }

    static String method7(String input){
        StringBuilder inputBuilder = new StringBuilder();
        for(int i=0;i<input.length();i++)
        {
            if(Character.isUpperCase(input.charAt(i))) {
                inputBuilder.append(input.charAt(i));
                inputBuilder.append('.');
            }
        }
        inputBuilder.deleteCharAt(inputBuilder.length()-1);
        input = inputBuilder.toString();
        return input;
    }

    static String method8(String input){

        input = input.replace("[code]","<code>");
        input = input.replace("[/code]","</code>");
        input = input.replace("[header]","<;h1>");
        input = input.replace("[/header]","</h1>");
        input = input.replace("[/link]","</a>");
        input = input.replace("[link:","< a href = \"");
        input = input.replace("]","\">");

        return input;
    }

}
