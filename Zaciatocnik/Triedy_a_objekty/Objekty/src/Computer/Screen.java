package Computer;

public class Screen {

    boolean onOff;
    int brightness;
    int contrast;

    String model;
    String label;

    public void turnOnScreen(){
        if(!onOff)
            onOff = true;
        else
            System.out.println("Monitor je uz zapnuty");
    }

    public void turnOffScreen(){
        if(onOff)
            onOff = false;
        else
            System.out.println("Monitor je uz vypnuty");
    }

    public void setBrightness(int value){
        if ((value>=0)&&(value<101))
            brightness = value;
        else
            System.out.println("Nespravna hodnota, prosim vlozte 1-100");
    }

    public void setContrast(int value){
        if ((value>=0)&&(value<101))
            contrast = value;
        else
            System.out.println("Nespravna hodnota, prosim vlozte 1-100");
    }

    public void showInfo(){
        System.out.println("Model: "+model);
        System.out.println("Znacka: "+label);
    }

    public void showStatus(){
        if(onOff)
            System.out.println("Monitor je zapnuty");
        else
            System.out.println("Monitor je vypnuty");

        System.out.println("Hodnoty su nastavene nasledovne: ");
        System.out.println("Jas: "+brightness);
        System.out.println("Kontrast: "+contrast);
    }

    public Screen(String model, String label){
        this.model = model;
        this.label = label;
        onOff = false;
        brightness = 50;
        contrast = 50;
    }
}
