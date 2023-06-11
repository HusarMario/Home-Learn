public class Main {

    public static void main(String[] args) {
        Account account = new Account("pass",5000);
        account.status("pass");
        account.withdraw(500,"pass");
        account.status("pass");
        account.withdraw(500,"pazz");
        account.status("pass");
        account.deposit(500,"pass");
        account.status("pass");
    }
}
