public class BankAccount {

    private String owner;
    private double balance;

    BankAccount(String owner){
        this.owner = owner;
        balance = 0;
    }

    void deposit(double money){
        balance += money;
        System.out.println(owner+"用户存款"+money+"$成功！");
    }

    void withdraw(double money){
        if(money>balance)
            System.out.println(owner+"用户取款"+money+"$失败！");
        else {
            balance -= money;
            System.out.println(owner + "用户取款"+money+"$成功！");
        }
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        return "账户持有者："+owner+"，余额："+balance+"$";
    }

}
