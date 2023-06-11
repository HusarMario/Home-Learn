public class Account {

    private int balance;
    private String pass;

    public Account(String pass,int balance){
        this.pass = pass;
        this.balance = balance;
    }

    public void deposit(int sum,String pass){
        if(pass.equals(this.pass)){
            balance = balance + sum;
        }
        else{
            System.out.println("Zle heslo");
        }
    }

    public void withdraw(int sum,String pass){
        if(pass.equals(this.pass)){
            balance = balance - sum;
        }
        else{
            System.out.println("Zle heslo");
        }
    }

    public void status(String pass){
        if(pass.equals(this.pass)){
            System.out.println(balance);
        }
        else{
            System.out.println("Zle heslo");
        }
    }
}
