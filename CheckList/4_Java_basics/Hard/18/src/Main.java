import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        ArrayList<BankAccount> list = new ArrayList<>();

        Random random = new Random();

        for(int i =1;i<=10;i++){
            list.add(new BankAccount(i,random.nextInt(200)));
        }


        Collections.sort(list);
        System.out.println(list.get(0).balance);

        double all = 0;

        for(BankAccount num : list){
            all += (double)num.balance;
            if(num.balance<100)
                System.out.println(num);
        }

        System.out.println(all/10);

    }

}
