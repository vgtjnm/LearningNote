public class User {

    String username;
    String email;
    int age;

    //写一个构造函数，用来赋予不同属性，并赋予默认值
    User(String username){
        this.username = username;
        this.email = "Not provided";
        this.age = -1;
    }

    //我们在前面一个构造函数里认为用户没有填写邮箱和名字并给了默认值
    //但是有的用户又会填写，所以我们将使用构造函数重载来应对这种情况
    //两个构造函数名字都相同，但是函数的参数不同
    User(String username, String email){
        this.username = username;
        this.email = email;
    }

    //这个是用户全部输入的构造函数
    User(String username, String email, int age){
        this.username = username;
        this.email = email;
        this.age = age;
    }

    //我们甚至可以认为用户完全匿名
    User(){
        this.username = "???";
        this.email = "???";
        this.age = -2;
    }

}
