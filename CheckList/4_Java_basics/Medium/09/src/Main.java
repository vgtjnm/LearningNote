public class Main {

    public static void main(String[] args){

        BankAccount account1 = new BankAccount("John");
        BankAccount account2 = new BankAccount("Tom");

        account1.deposit(100);
        account1.withdraw(10);;
        System.out.println("John的账户有"+account1.getBalance()+"$");
        System.out.println(account1);

        account2.deposit(10);
        account2.withdraw(100);
        System.out.println("Tom的账户有"+account2.getBalance()+"$");
        System.out.println(account2);

    }

}
