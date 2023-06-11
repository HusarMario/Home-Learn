public class ATM implements AccountManipulation {

    @Override
    public void withdraw(Account account, int suma, String pass) {
        System.out.println("Prebieha vyber cez bankomat");
        account.withdraw(suma,pass);
        System.out.println("Ukoncenie vyberu cez bankomat");
    }

    @Override
    public void deposit(Account account,  int suma, String pass) {
        System.out.println("Prebieha vyber cez bankomat");
        account.withdraw(suma,pass);
        System.out.println("Ukoncenie vyberu cez bankomat");
    }
}
