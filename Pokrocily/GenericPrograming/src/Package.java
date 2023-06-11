public class Package <P,O>{
    private P object;
    private O object2;

    public void addObject(P object){
        this.object = object;
    }

    public void addObject2(O object){
        this.object2 = object;
    }

    public P getObject(){
        return object;
    }

    public O getObject2(){
        return object2;
    }
}
