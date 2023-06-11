package Computer;

public class Case {
    String graphicCard;
    String processor;
    String motherBoard;
    String model;
    String label;

    boolean onOff;

    public void turnOnComputer(){
        if(!onOff)
            onOff = true;
        else
            System.out.println("Pocitac je uz zapnuty");
    }

    public void turnOffComputer(){
        if(onOff)
            onOff = false;
        else
            System.out.println("Pocitac je uz vypnuty");
    }

    public void showInfo(){
        System.out.println("Grafika: "+graphicCard);
        System.out.println("Procesor: "+processor);
        System.out.println("Doska: "+motherBoard);
        System.out.println("Model: "+model);
        System.out.println("Znacka: "+label);
    }

    public Case(String graphicCard, String processor, String motherBoard, String model, String label){
        this.graphicCard = graphicCard;
        this.processor = processor;
        this.motherBoard = motherBoard;
        this.model = model;
        this.label = label;
    }
}
