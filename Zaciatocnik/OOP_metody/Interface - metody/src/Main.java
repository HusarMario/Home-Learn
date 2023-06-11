public class Main {

    public static void main(String[] args) {
        Account account = new Account("Mario","pass",5000);
        account.status("pass");
        account.withdraw(300,"pass");
        account.deposit(350,"pass");
        account.status("pass");

        Account account2 = new Account("Husar","password",1000);
        account2.status("password");
        account2.withdraw(300,"password");
        account2.deposit(350,"password");
        account2.status("password");
    }
}
