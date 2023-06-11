public class Main {

    static final String LANGUAGE = "SK";

    public static void main(String[] args) {

        for (Days day:Days.values()) {
            dayOfTheWeek(day);
        }

        for (Directions direction:Directions.values()){
            goDirection(direction);
        }
    }


    static void dayOfTheWeek(Days day){
        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Je pracovny tyzden.");
            case SATURDAY, SUNDAY -> System.out.println("Je vikend.");
        }
    }

    static void goDirection(Directions direction){
        if (LANGUAGE.equals("EN")) {
            System.out.println("Go "+direction.getNameEN());
        }

        if (LANGUAGE.equals("SK")) {
            System.out.println("Chod na "+direction.getNameSK());
        }

    }

}
