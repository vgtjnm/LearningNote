public class BankAccount implements Comparable<BankAccount>{

    int number;
    int balance;

    BankAccount(int number,int balance){
        this.number = number;
        this.balance = balance;
    }

    @Override
    public int compareTo(BankAccount other){
        return Integer.compare(other.balance,this.balance);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }


}
