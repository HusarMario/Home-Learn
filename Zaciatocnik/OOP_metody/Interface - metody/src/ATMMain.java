public class ATMMain {
    public static void main(String[] args) {
        Account account = new Account(new ATM(),"Mario","pass");
        account.takeOutMoney(500,"pass");
    }
}
