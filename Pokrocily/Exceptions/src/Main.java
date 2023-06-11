    /* Vytvor si dve vlastné výnimky. Jedna výnimka bude dediť od Exception a druhá od RuntimeException.
Potom si vytvor dve metódy, každá z nich bude hádzať jednu z tvojich vlastných výnimiek. Potom si vytvor tretiu metódu, v ktorej použiješ tieto dve metódy.

        Napr.:
        metoda3(){
        metodat1();
        metoda2();
        }



        Vývojové prostredie ti takto bude hlásiť chybu, lebo si neošetril výnimku. Skús si ošetriť kód tak, aby ťa neupozorňoval.*/

import Exceptions.ageExcepiton;
import Exceptions.shortPassException;

public class Main {

    public static void main(String[] args) throws Exception {

        Profile newProfile = new Profile("Raven","pyro123",14);
        checkProfile(newProfile);

    }

    static void checkPasswordLength(String pass) throws Exception{
        if(pass.length() < 8)
            throw new shortPassException("Heslo je prilis kratke");
        else
            System.out.println("Heslo je v poriadku");
    }

    static void checkAge(int age){
        if(age < 15)
            throw new ageExcepiton("Vek je prilis nizky");
        else
            System.out.println("Vek je v poriadku");
    }

    static void checkProfile(Profile profile) throws Exception{
        try {
            checkPasswordLength(profile.getPassword());
        } catch (shortPassException exception) {
            exception.printStackTrace();
        }

        try {
            checkAge(profile.getAge());
        } catch (ageExcepiton exception){
            exception.printStackTrace();
        }


    }

}
