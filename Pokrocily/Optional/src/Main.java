import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> hodnota1 = Optional.of("hodnota");
        Optional<String> hodnota2 = Optional.empty();
        String hodnota3 = "hodnota";
        String hodnota4 = null;

        System.out.println(hodnota1);
        System.out.println(hodnota1.get());
        System.out.println(hodnota2);
        System.out.println(Optional.ofNullable(hodnota3));
        System.out.println(Optional.ofNullable(hodnota4));

        if(hodnota2.isPresent()){
            System.out.println(hodnota1);
        }else
            System.out.println("NIE JE ");

        hodnota1.ifPresent(System.out::println);
        hodnota2.ifPresent(System.out::println);

        System.out.println(hodnota1.orElse("nic"));
        System.out.println(hodnota2.orElse("nic"));
        System.out.println(hodnota2.orElseGet(()->"nic"));





    }
}
