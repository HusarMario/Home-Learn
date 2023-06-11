package Computer;

import Components.Card;
import Components.Memory;
import Components.Processor;
import Exceptions.DifferentMemories;


import java.util.ArrayList;

public class Computer {
    private Processor processor;

    private final ArrayList<Memory> memory = new ArrayList<>();
    private int numMem = 0;

    private final Card [] card = new Card[3];

    public Computer() {
    }

    public void checkComponents(){
        if (processor==null)
            System.out.println("Procesor nie je zapojeny");
        else
            System.out.println("Procesor: " + processor.getProducer() + processor.getFrequency());


        if(memory.isEmpty())
            System.out.println("Pamat nie je zapojena");
        else
            System.out.println("Pamat:");
            for(int i = 0; i<numMem ; i++ )
                System.out.println("    " + memory.get(i).getSpeed() + memory.get(i).getSize());

        if (card[0]==null)
            System.out.println("Sietova karta nie je zapojena");
        else
            System.out.println("Sietova krata je zapojena.");

        if (card[1]==null)
            System.out.println("Graficka karta nie je zapojena");
        else
            System.out.println("Graficka krata je zapojena.");

        if (card[2]==null)
            System.out.println("Zvukova karta nie je zapojena");
        else
            System.out.println("Zvukova krata je zapojena.");

        System.out.println();
    }

    public void connectProcessor(Processor processor){
        if (this.processor==null)
            System.out.println("Procesor bol zapojeny");
        else
            System.out.println("Procesor bol prepojeny");
        this.processor = processor;
        System.out.println();
    }

    public void connectMemory(Memory memory){
        if (this.memory.isEmpty())
            System.out.println("Pamat bola zapojena");
        else{
            System.out.println("Pamat bola prepojena");
            this.memory.clear();}
        this.memory.add(memory);
        numMem = 1;
        System.out.println();
    }

    public void connectMemory(Memory memory1,Memory memory2) throws DifferentMemories{
        if (!memory1.getSpeed().equals(memory2.getSpeed()))
            throw new DifferentMemories();

        if (this.memory.isEmpty())
            System.out.println("Pamat bola zapojena");
        else{
            System.out.println("Pamat bola prepojena");
            this.memory.clear();}

        this.memory.add(memory1);
        this.memory.add(memory2);
        numMem = 2;
        System.out.println();
    }

    public void connectMemory(Memory memory1,Memory memory2,Memory memory3, Memory memory4) throws DifferentMemories{
        if (!memory1.getSpeed().equals(memory2.getSpeed()))
            throw new DifferentMemories();
        else if (!memory2.getSpeed().equals(memory3.getSpeed()))
            throw new DifferentMemories();
        else if (!memory3.getSpeed().equals(memory4.getSpeed()))
            throw new DifferentMemories();

        if (this.memory.isEmpty())
            System.out.println("Pamat bola zapojena");
        else{
            System.out.println("Pamat bola prepojena");
            this.memory.clear();}

        this.memory.add(memory1);
        this.memory.add(memory2);
        this.memory.add(memory3);
        this.memory.add(memory4);
        numMem = 4;
        System.out.println();
    }

    public void connectMemory(Memory memory1,Memory memory2,Memory memory3, Memory memory4,
                                Memory memory5, Memory memory6, Memory memory7, Memory memory8) throws DifferentMemories{
        if (!memory1.getSpeed().equals(memory2.getSpeed()))
            throw new DifferentMemories();
        else if (!memory2.getSpeed().equals(memory3.getSpeed()))
            throw new DifferentMemories();
        else if (!memory3.getSpeed().equals(memory4.getSpeed()))
            throw new DifferentMemories();
        else if (!memory4.getSpeed().equals(memory5.getSpeed()))
            throw new DifferentMemories();
        else if (!memory5.getSpeed().equals(memory6.getSpeed()))
            throw new DifferentMemories();
        else if (!memory6.getSpeed().equals(memory7.getSpeed()))
            throw new DifferentMemories();
        else if (!memory7.getSpeed().equals(memory8.getSpeed()))
            throw new DifferentMemories();

        if (this.memory.isEmpty())
            System.out.println("Pamat bola zapojena");
        else{
            System.out.println("Pamat bola prepojena");
            this.memory.clear();}
        this.memory.add(memory1);
        this.memory.add(memory2);
        this.memory.add(memory3);
        this.memory.add(memory4);
        this.memory.add(memory5);
        this.memory.add(memory6);
        this.memory.add(memory7);
        this.memory.add(memory8);
        numMem = 8;
        System.out.println();
    }

    public void connectCard(Card card){
        switch (card.getCardType()) {
            case SIETOVA -> {
                if (this.card[0] == null) {
                    System.out.println("Sietova karta bola zapojena");
                } else
                    System.out.println("Sietova karta bola prepojena");
                this.card[0] = card;
            }
            case GRAFICKA -> {
                if (this.card[1] == null) {
                    System.out.println("Graficka karta bola zapojena");
                } else
                    System.out.println("Graficka karta bola prepojena");
                this.card[1] = card;
            }
            case ZVUKOVA -> {
                if (this.card[2] == null) {
                    System.out.println("Sietova karta bola zapojena");
                } else
                    System.out.println("Sietova karta bola prepojena");
                this.card[2] = card;
            }
        }
        System.out.println();
    }

    public void disconnectProcessor(){
        if(processor==null)
            System.out.println("Procesor nie je zapojeny -> nemozno odpojit");
        else {
            processor = null;
            System.out.println("Procesor bol odpojeny");
        }
        System.out.println();
    }

    public void disconnectMemory(){
        if (this.memory.isEmpty())
            System.out.println("Pamat nie je zapojena -> nemozno odpojit");
        else {
            System.out.println("Pamat bola odpojena");
            numMem = 0;
            this.memory.clear();
        }
        System.out.println();
    }

    public void disconnectCard(){
        if (card[0]==null)
            System.out.println("Sietova karta nie je zapojena");
        else
            System.out.println("Sietova krata bola odpojena.");
            card[0]=null;

        if (card[1]==null)
            System.out.println("Graficka karta nie je zapojena");
        else
            System.out.println("Graficka krata bola odpojena.");
            card[1]=null;

        if (card[2]==null)
            System.out.println("Zvukova karta nie je zapojena");
        else
            System.out.println("Zvukova krata bola odpojena.");
            card[2]=null;

        System.out.println();

    }

    public void disconnectCard(Card card){
        switch (card.getCardType()) {
            case SIETOVA -> this.card[0] = null;

            case GRAFICKA -> this.card[1] = null;

            case ZVUKOVA -> this.card[2] = null;

        }
        System.out.println();
    }

    public Processor getProcessor() {
        return processor;
    }

    public ArrayList<Memory> getMemory() {
        return memory;
    }

    public int getNumMem() {
        return numMem;
    }

    public Card[] getCard() {
        return card;
    }
}
