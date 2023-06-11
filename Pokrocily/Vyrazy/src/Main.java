import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String mail = "ohnochvostik.123@azet.en";
        String pass = "Ja1n2evi3em69l";
        String profilePic = "cuteuwupic.bmp";
        String birthDate = "14/02/2003";
        String descripton = "I’m the kind of romantic who will order you Uber Eats for our virtual date.";

        method1(mail);
        method2(pass);
        method3(profilePic);
        method4(birthDate);
        method5(descripton);
        method6(pass);

    }

    static void method1(String mail){
        System.out.println(mail.matches("\\S+@\\w+\\.\\S+"));
    }

    static void method2(String pass){
        System.out.println(pass.matches("(?=.*\\d+.*)(?=.*\\p{Upper}.*)\\S{8,}"));
    }

    static void method3(String pic){
        System.out.println(pic.matches(".*\\.(jpeg|jpg|png|bmp)"));
    }

    static void method4(String date){
        System.out.println(date.matches("(0[1-9]|[1-2][0-9]|30|31)/(0[1-9]|1[0-2])/(19[2-9][0-9]|20[0-1][1-9]|2020)"));
    }

    static void method5(String text){
        String[] words;
        words = text.split("\\W");
        for(String s : words){
            if(s.matches("\\p{Upper}.*"))
                System.out.println(s);
        }
    }

    static void method6(String text){
        String[] words;
        words = text.split("\\D");
        for(String s : words){
            if(s.matches("\\d+"))
                System.out.println(s);
        }
    }



}
