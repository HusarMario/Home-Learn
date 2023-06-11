import Computer.Case;
import Computer.Screen;

public class Main {

    public static void main(String[] args) {
        Screen screen1 = new Screen("2020HD","HP");
        Screen screen2 = new Screen("OldUglyScreen","Samsung");
        Case case1 = new Case("RTX2060","I7H9750","TRC96","FastnFurious","Apple");

        screen1.showInfo();
        screen2.showInfo();

        screen1.showStatus();
        screen2.showStatus();

        screen1.turnOnScreen();

        screen1.showStatus();
        screen2.showStatus();

        screen2.setBrightness(99);
        screen2.setContrast(109);
        screen2.setContrast(0);

        screen1.showStatus();
        screen2.showStatus();

        case1.showInfo();
        case1.turnOnComputer();
        case1.turnOnComputer();
    }
}
