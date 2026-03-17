public class Friend {

    String name;
    //如果我们想知道我们创建了多少个朋友那么就需要static关键字
    //如果没有static关键字那么他就会是每个对象的私有属性
    //这个属性也叫静态属性
    static int numOfFriends;

    Friend(String name){
        this.name = name;
        numOfFriends++;
    }

    //现在让我们来创建一个静态方法吧
    static void showFriends(){
        System.out.println("You hava "+ numOfFriends+" total friends");//写静态方法时不需要用this调用属性
    }


}
