public class Main {

    public static void main(String[] args) {

        BlueUnit blueUnit = new BlueUnit();
        RedUnit redUnit = new RedUnit();

        blueUnit.showStats();
        redUnit.showStats();

        blueUnit.steady();
        redUnit.steady();

        blueUnit.showStats();
        redUnit.showStats();
    }


}
