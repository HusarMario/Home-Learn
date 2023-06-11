import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile("Tokyo",32));
        profileList.add(new Profile("Berlin",43));
        profileList.add(new Profile("Arturito",52));
        profileList.add(new Profile("Denver",25));

        List<Integer> ages = profileList.stream()
                .filter(profile -> profile.getAge()<50)
                .map(Profile::getAge)
                .collect(Collectors.toList());

        ages.forEach(System.out::println);
    }
}
