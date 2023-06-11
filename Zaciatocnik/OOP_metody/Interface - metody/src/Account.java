public class Account {

    private int balance;
    private final String name;
    private final String pass;

    public Account(String name, String pass, int balance){
        this.pass = pass;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(int money, String pass){
        if(pass.equals(this.pass)) {
            balance = balance - money;
        }
        else
            System.out.println("Nespravne heslo");
    }

    public void deposit(int money, String pass){
        if(pass.equals(this.pass)) {
            balance = balance + money;
        }
        else
            System.out.println("Nespravne heslo");
    }

    public void status(String pass){
        if(pass.equals(this.pass)){
            System.out.print(name + " : ");
            System.out.println(balance);
        }
        else{
            System.out.println("Nespravne heslo");
        }
    }

    AccountManipulation accountManipulation;

    public Account(AccountManipulation accountManipulation, String name, String pass){
        this.accountManipulation = accountManipulation;
        this.name = name;
        this.pass = pass;
    }

    public void takeOutMoney(int money, String pass){
        accountManipulation.withdraw(this, money, pass);
    }

    public void depositMoney(int money, String pass){
        accountManipulation.deposit(this, money, pass);
    }


}
