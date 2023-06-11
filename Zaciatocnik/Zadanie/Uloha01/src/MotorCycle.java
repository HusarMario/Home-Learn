public class MotorCycle extends BiCycle {

    String defineMe(){
        return "a cycle with an engine.";
    }

    MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ defineMe());

        String temp= super.defineMe(); //Fix this line

        System.out.println("My ancestor is a cycle who is "+ temp );
    }
}
    