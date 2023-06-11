public enum Directions {
    NORTH("N","north","S","sever"),
    SOUTH("S","south","J","juh"),
    EAST("E","east","V","vychod"),
    WEST("W","west","Z","zapad");

    private String shortEN;
    private String nameEN;
    private String shortSK;
    private String nameSK;

    Directions(String shortEN, String nameEN, String shortSK, String nameSK){
        this.shortEN = shortEN;
        this.nameEN = nameEN;
        this.shortSK = shortSK;
        this.nameSK = nameSK;
    }

    public String getShortEN(){
        return shortEN;
    }
    public String getNameEN(){
        return nameEN;
    }
    public String getShortSK(){
        return shortSK;
    }
    public String getNameSK(){
        return nameSK;
    }


}
