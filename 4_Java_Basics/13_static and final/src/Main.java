public class Main {

    public static void main(String[] args){

        //这次我们将要学习static和final关键字

        //static用来修改变量或方法，使其属于类而不是任何特定的对象
        //我们在main方法中经常看见static关键字，static也常用于创建使用方法或者其他共享资源
        //让我们先来创建个类实验一下吧

        Friend friend1 = new Friend("Tom");
        Friend friend2 = new Friend("Ming");

        //类中被static变成公有的属性最好以类名为前缀调用，而不是某个对象
        //这是为了方便其他人看到你的代码知道这是静态属性
        System.out.println(Friend.numOfFriends);

        //被static的属性叫做静态属性，除了静态属性还可以有静态方法
        Friend.showFriends();

        //static总结：
        //使用static关键字可以把一个类的属性或者方法变成静态属性或者方法
        //调用时尽量使用类名调用，方便他人读懂代码

        //下面我们来学final关键字
        //任何被声明为final的变量都不能在程序中被修改或者更新
        //举个例子，比如说π，这个东西不能被修改，所以我们需要使用final关键字
        final double pi = 3.1415926;

        //pi = 1223;
        //这时别人像这样修改就是违法的

        //总结：
        //使用final关键字的变量可以防止修改，类似C++的常量
        //但是java的final还可用于方法来防止重写，也可用于类来防止继承


    }

}
