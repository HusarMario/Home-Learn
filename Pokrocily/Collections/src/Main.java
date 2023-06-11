import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class Osoba{
    private final String name;
    private final int vek;

    public Osoba(String name, int vek) {
        this.name = name;
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "name='" + name + '\'' +
                ", vek=" + vek +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        method9(names);
        names.add("Jozko");
        names.add("Peter");
        names.add("Julius");
        names.add("Erik");
        names.add("Martin");
        names.add("Rufus");

        List<String> names2 = new ArrayList<>();
        names2.add("Adam");
        names2.add("Richard");
        names2.add("Sebastian");
        names2.add("Zdeno");


        method1();
        method2();
        method3();
        method5(names,(method4(names,"Martin")));
        method5(names,(method4(names,"RS")));

        System.out.println(names);
        method6(names);
        System.out.println(names);
        method7(names,names2);
        System.out.println(names);
        method8(names);
        System.out.println(names);
        method9(names);
        method10(names);


        Osoba osoba1 = new Osoba("Mario",19);
        Osoba osoba2 = new Osoba("Peter",23);
        Osoba osoba3 = new Osoba("David",46);
        HashMap<Integer,Osoba> persons = new HashMap<>();
        persons.put(1,osoba1);
        persons.put(2,osoba2);
        persons.put(3,osoba3);

        System.out.println(persons);
        method12(persons,3);

        ArrayList<Osoba> persons2 = new ArrayList<>();
        method13(persons,persons2);
        System.out.println(persons2);

        ArrayList<Integer> inputs = new ArrayList<>();
        method14(inputs);

        System.out.println(inputs);

        System.out.println("Final");
        method15(names);
        method15(names2);
        method15(persons2);
        method15(inputs);

    }

    static void method1(){
        Set<String> names = new HashSet<>();
        names.add("Jozko");
        names.add("Peter");
        names.add("Julius");
        names.add("Erik");
        names.add("Martin");

        System.out.println(names);
    }

    static void method2(){
        List<String> names = new ArrayList<>();
        names.add("Jozko");
        names.add("Peter");
        names.add("Julius");
        names.add("Erik");
        names.add("Martin");

        names.add(0,"Rufus");

        System.out.println(names);
    }

    static void method3(){
        List<String> names = new ArrayList<>();
        names.add("Jozko");
        names.add("Peter");
        names.add("Julius");
        names.add("Erik");
        names.add("Martin");
        names.add("Rufus");

        Collections.swap(names,2,0);

        System.out.println(names);
    }


    static int method4(List<String> names,String name){
        return names.indexOf(name);
    }

    static void method5(List<String> names, int index){
        if(index>0 && index<names.size())
            System.out.println(names.get(index));
    }

    static void method6(List<String> names){
        names.sort(Comparator.naturalOrder());
    }

    static void method7(List<String> to,List<String> from){
        to.addAll(from);
    }

    static void method8(List<String> list){
        Collections.swap(list,0,list.size()-1);
    }

    static void method9(List<String> list){
        if(list.isEmpty()){
            System.out.println("Prazdna");
        }
        else
            System.out.println("Plna");
    }

    static void method10(List<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }

    static void method12(HashMap<Integer,Osoba> hashMap, int key){
        if(hashMap.containsKey(key)) {
            System.out.println(hashMap.get(key));
        }
    }

    static void method13(HashMap<Integer,Osoba> hashMap,ArrayList<Osoba> list){
        System.out.println(hashMap.keySet());
        for(int i : hashMap.keySet()){
            list.add(hashMap.get(i));
        }
    }

    static void method14(ArrayList<Integer> list){
        Path path = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\Collections\\input.txt");
        try(Scanner scanner = new Scanner(Files.newBufferedReader(path))){
            while (scanner.hasNext()){
                list.add(scanner.nextInt());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static void method15(Collection collection){
        System.out.println(collection);
    }


}
