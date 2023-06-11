import Components.Card;
import Components.CardType;
import Components.Memory;
import Components.Processor;
import Computer.Computer;
import Computer.Configuration;
import Exceptions.DifferentMemories;

public class Main {

    public static void main(String[] args) throws DifferentMemories {
        Configuration configuration = new Configuration();

        Card card1 = new Card(CardType.ZVUKOVA);
        Card card2 = new Card(CardType.ZVUKOVA);
        Card card3 = new Card(CardType.GRAFICKA);
        Card card4 = new Card(CardType.GRAFICKA);
        Card card5 = new Card(CardType.SIETOVA);
        Card card6 = new Card(CardType.SIETOVA);

        Processor processor1 = new Processor("Intel","3.2");
        Processor processor2 = new Processor("Intel","4.0");
        Processor processor3 = new Processor("Intel","4.2");
        Processor processor4 = new Processor("AMD","3.2");
        Processor processor5 = new Processor("AMD","4.0");
        Processor processor6 = new Processor("AMD","4.2");

        Memory memory1 = new Memory("4GB","1600");
        Memory memory2 = new Memory("4GB","1600");
        Memory memory3 = new Memory("4GB","1600");
        Memory memory4 = new Memory("8GB","1600");
        Memory memory5 = new Memory("8GB","1600");
        Memory memory6 = new Memory("8GB","1600");
        Memory memory7 = new Memory("8GB","1600");
        Memory memory8 = new Memory("8GB","1600");
        Memory memory9 = new Memory("8GB","1600");
        Memory memory10 = new Memory("8GB","3200");
        Memory memory11 = new Memory("8GB","3200");
        Memory memory12 = new Memory("8GB","3200");
        Memory memory13 = new Memory("16GB","3200");
        Memory memory14 = new Memory("16GB","3200");
        Memory memory15 = new Memory("16GB","3200");
        Memory memory16 = new Memory("16GB","3200");

        Computer computer = new Computer();

        try {
            computer.connectMemory(memory7,memory8,memory4,memory3,memory6,memory5,memory1,memory2);
        }   catch (DifferentMemories differentMemories){
            differentMemories.printStackTrace();
        }

        computer.checkComponents();






    }
}
