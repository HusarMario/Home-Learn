package Computer;

import Exceptions.DifferentMemories;

import java.util.ArrayList;

public class Configuration {
    private final ArrayList<Computer> computers = new ArrayList<>();

    public void saveComputer(Computer computer) throws DifferentMemories {
        Computer newcomp = new Computer();
        copyComputer(computer,newcomp);
        computers.add(newcomp);
        System.out.println("Zostava bola ulozena");
        System.out.println();
    }

    private void copyComputer(Computer original,Computer copy) throws DifferentMemories {
        copy.connectProcessor(original.getProcessor());

        switch (original.getNumMem()) {
            case 0 -> {
            }
            case 1 -> copy.connectMemory(original.getMemory().get(0));

            case 2 -> copy.connectMemory(original.getMemory().get(0), original.getMemory().get(1));


            case 4 -> copy.connectMemory(original.getMemory().get(0), original.getMemory().get(1),
                        original.getMemory().get(2), original.getMemory().get(3));

            case 8 -> copy.connectMemory(original.getMemory().get(0), original.getMemory().get(1),
                        original.getMemory().get(2), original.getMemory().get(3),
                        original.getMemory().get(4), original.getMemory().get(5),
                        original.getMemory().get(6), original.getMemory().get(7));

        }

        if (original.getCard()[0] != null)
            copy.connectCard(original.getCard()[0]);

        if(original.getCard()[0] != null)
            copy.connectCard(original.getCard()[1]);

        if(original.getCard()[0] != null)
        copy.connectCard(original.getCard()[2]);
    }

    public void deleteComputer(int index) {
        if(index > computers.size() || index < 1)
            System.out.println("Tento index sa v zozname nenachadza");
        else {
            computers.remove(index-1);
        }
    }

    public void importComputer(Computer computer, int index)throws DifferentMemories{
        if(index > computers.size() || index < 1)
            System.out.println("Tento index sa v zozname nenachadza");
        else
        {
            if(computers.get(index).getProcessor()==null)
                computer.getCard();
            else
                computer.connectProcessor(computers.get(index).getProcessor());

            switch (computers.get(index).getNumMem()) {
                case 0 -> computer.disconnectMemory();

                case 1 -> computer.connectMemory(computers.get(index).getMemory().get(0));


                case 2 -> computer.connectMemory(computers.get(index).getMemory().get(0), computers.get(index).getMemory().get(1));


                case 4 -> computer.connectMemory(computers.get(index).getMemory().get(0), computers.get(index).getMemory().get(1),
                        computers.get(index).getMemory().get(2), computers.get(index).getMemory().get(3));

                case 8 -> computer.connectMemory(computers.get(index).getMemory().get(0), computers.get(index).getMemory().get(1),
                        computers.get(index).getMemory().get(2), computers.get(index).getMemory().get(3),
                        computers.get(index).getMemory().get(4), computers.get(index).getMemory().get(5),
                        computers.get(index).getMemory().get(6), computers.get(index).getMemory().get(7));

            }

            if (computers.get(index).getCard()[0] != null)
                computer.connectCard(computers.get(index).getCard()[0]);
            else
                computer.disconnectCard();

            if(computers.get(index).getCard()[0] != null)
                computer.connectCard(computers.get(index).getCard()[1]);
            else
                computer.disconnectCard();

            if(computers.get(index).getCard()[0] != null)
                computer.connectCard(computers.get(index).getCard()[2]);
            else
                computer.disconnectCard();

            System.out.println("Vymenene");
        }
    }

    public void showConfigurations() {
        if (computers.isEmpty())
            System.out.println("Nie je ulozena ziadna zostava");
        else
            for (int i = 0; i < computers.size(); i++) {
                System.out.println("Konfiguracia num: " + (i+1));

                System.out.println("Procesor: ");
                if(computers.get(i).getProcessor()==null)
                    System.out.println("         /////");
                else
                    System.out.println("        " + computers.get(i).getProcessor().getProducer() + computers.get(i).getProcessor().getFrequency());

                System.out.println("Pamat: ");
                if(computers.get(i).getMemory().isEmpty())
                    System.out.println("         /////");
                else
                    for(int j = 0; j < computers.get(i).getNumMem(); j++)
                        System.out.println("        " + computers.get(i).getMemory().get(j).getSpeed() + computers.get(i).getMemory().get(j).getSize());

                System.out.println("Karty: ");
                if((computers.get(i).getCard()[0]==null)&&(computers.get(i).getCard()[1]==null)&&(computers.get(i).getCard()[2]==null))
                        System.out.println("         /////");
                else
                    if(computers.get(i).getCard()[0]==null){
                        System.out.println("         /////");
                    }
                    else
                        System.out.println("        " + computers.get(i).getCard()[0].getCardType());

                    if(computers.get(i).getCard()[1]==null){
                        System.out.println("         /////");
                    }
                    else
                        System.out.println("        " + computers.get(i).getCard()[1].getCardType());

                    if(computers.get(i).getCard()[2]==null){
                        System.out.println("         /////");
                    }
                    else
                        System.out.println("        " + computers.get(i).getCard()[2].getCardType());


            }
        System.out.println();
    }
}