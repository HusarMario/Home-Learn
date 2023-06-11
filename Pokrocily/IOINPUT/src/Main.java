    
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Path textin = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\TEXTin.txt");
        Path textpath = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT");
        Path textout = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\TEXTout.txt");
        Path removepath = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\REMOVEABLE"); //add before running

        Path from = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\FROM\\MOVEME.rtf");
        Path to = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\TO\\MOVEME.rtf");

        String name = "created.txt";

        method1(textin);
        System.out.println();
        method2(textout);
        System.out.println();
        method3(textin);
        System.out.println();
        method4(textin);
        System.out.println();
        method5(textin);
        method5(textpath);
        System.out.println();
        method6(textpath);
        System.out.println();
        //method7(removepath);
        //method8(from,to);
        System.out.println(method9(name));


    }

    static void method1(Path textin) {
        try (Scanner scanner = new Scanner(Files.newBufferedReader(textin))){
            while (scanner.hasNext())
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void method2(Path textout) {
        try (BufferedWriter bw = Files.newBufferedWriter(textout)) {
            bw.write("Toto je text ktory vlozim do suboru");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void method3(Path textin){
        String text = "";
        try (Scanner scanner = new Scanner(Files.newBufferedReader(textin))){
            while (scanner.hasNext()) {
                text = text + scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words;
        String longestWord = "";
        words = text.split("\\W");

        for (String word : words){
            if(word.length() > longestWord.length()){
                longestWord = word;
            }
        }

        System.out.println(longestWord);

    }

    static void method4(Path textin){
        try {
            System.out.println("Size of file is : "+Files.size(textin)+" bytes.");
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void method5(Path path){
        if(Files.isDirectory(path))
            System.out.println("Je to priecinok");
        else
            System.out.println("Je to subor");
    }

    static void method6(Path path){
        Object[] lists = {};
        try {
            lists = Files.list(path).toArray();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        for (Object list : lists) {
            System.out.println(list);
        }
    }

    static void method7(Path path){
        try {
            Files.delete(path);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void method8(Path from,Path to){
        try {
            Files.copy(from,to);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Path method9(String name){
        Path newFile = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\IOINPUT\\TO\\"+name);
        try {
            Files.createFile(newFile);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }
}




