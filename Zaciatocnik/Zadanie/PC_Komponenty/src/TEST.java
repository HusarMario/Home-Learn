import Components.Card;
import Components.CardType;
import Components.Memory;
import Components.Processor;
import Computer.Computer;
import Computer.Configuration;
import Exceptions.DifferentMemories;

public class TEST {

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
        Processor processor3 = new Processor("AMD","4.0");
        Processor processor4 = new Processor("AMD","3.2");

        Memory memory1 = new Memory("16GB","1600");
        Memory memory2 = new Memory("8GB","3200");
        Memory memory3 = new Memory("8GB","1600");
        Memory memory4 = new Memory("4GB","1600");
        Memory memory5 = new Memory("4GB","1600");
        Memory memory6 = new Memory("8GB","1600");
        Memory memory7 = new Memory("4GB","1600");
        Memory memory8 = new Memory("4GB","1600");
        Memory memory9 = new Memory("16GB","3200");
        Memory memory10 = new Memory("8GB","3200");
        Memory memory11 = new Memory("8GB","1600");
        Memory memory12 = new Memory("4GB","1600");
        Memory memory13 = new Memory("4GB","1600");
        Memory memory14 = new Memory("8GB","1600");
        Memory memory15 = new Memory("8GB","3200");
        Memory memory16 = new Memory("8GB","3200");

        Computer computer = new Computer();

        computer.checkComponents();
        computer.connectProcessor(processor3);
        computer.checkComponents();
        computer.connectProcessor(processor4);
        computer.checkComponents();
        computer.disconnectProcessor();
        computer.checkComponents();
        computer.connectProcessor(processor1);
        computer.checkComponents();
        configuration.saveComputer(computer);

        computer.connectMemory(memory4);
        computer.checkComponents();

        computer.connectMemory(memory5,memory6);
        computer.checkComponents();

        computer.connectMemory(memory11,memory12);
        computer.checkComponents();

        computer.connectMemory(memory4,memory3,memory5,memory7);
        computer.checkComponents();

        computer.connectMemory(memory1,memory11,memory3,memory4,memory5,memory6,memory7,memory8);
        computer.checkComponents();
        configuration.saveComputer(computer);

        computer.connectCard(card1);
        computer.connectCard(card3);
        computer.connectCard(card5);
        computer.checkComponents();

        computer.connectCard(card2);
        computer.connectCard(card4);
        computer.connectCard(card6);

        computer.connectProcessor(processor2);

        configuration.saveComputer(computer);
        computer.disconnectMemory();
        computer.disconnectCard();
        computer.disconnectProcessor();

        configuration.showConfigurations();
        configuration.deleteComputer(1);
        configuration.showConfigurations();
        configuration.deleteComputer(1);
        configuration.showConfigurations();
        configuration.deleteComputer(1);
        configuration.showConfigurations();

        configuration.saveComputer(computer);
        configuration.saveComputer(computer);
        configuration.saveComputer(computer);

        configuration.showConfigurations();

        computer.connectCard(card1);
        computer.connectCard(card3);
        computer.connectCard(card5);

        computer.checkComponents();
        configuration.importComputer(computer,1);
        computer.checkComponents();







    }
}
