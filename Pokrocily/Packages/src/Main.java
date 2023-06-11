import Package1.Profile;

public class Main {

    public static void main(String[] args) {
        Profile login = new Profile("raven","pyro123");
        Package2.Profile info = new Package2.Profile("Barbora","Bujdosova",16);

        System.out.println("Info uctu "+login.getNickname());
        System.out.println("Meno : "+info.getName());
        System.out.println("Priezvisko : "+info.getSurname());
        System.out.println("Vek : "+info.getAge());
    }
}
