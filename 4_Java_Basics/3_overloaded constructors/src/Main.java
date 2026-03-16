public class Main {

    public static void main(String[] args){

        //这次我们来讲构造函数重载
        //我们先来创建一个用户类吧

        //我们来创建两个用户对象
        User user1 = new User("Tom");
        User user2 = new User("Mei","382183921@123.com");
        User user3 = new User("Jimmy","23912389829@133.com",132);
        User user4 = new User();

        //创建完之后来验证一下我们的构造函数重载
        System.out.println(user1.username+" "+user1.email+" "+user1.age);
        System.out.println(user2.username+" "+user2.email+" "+user2.age);
        System.out.println(user3.username+" "+user3.email+" "+user3.age);
        System.out.println(user4.username+" "+user4.email+" "+user4.age);

    }

}
