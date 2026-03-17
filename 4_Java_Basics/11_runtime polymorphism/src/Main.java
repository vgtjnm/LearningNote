import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //这次我们将解释运行时的多态，也称为动态多态，简单来说就是
        //运行时根据对象的实际类型来决定执行哪个方法
        //我们先来创建几个类吧

        //正常来说我们并不能创建抽象类的对象像这样
        //Animal animal = new Animal();
        //但是我们却可以这样创建
        //Animal animal = new Dog();或者Cat()
        //所以我们可以以此搭配用户输入来创建

        Scanner scanner = new Scanner(System.in);

        Animal animal;

        System.out.print("Would you like a dog or a cat? (1 = dog, 2 = cat): ");
        int choice = scanner.nextInt();

        if(choice == 1){
            animal = new Dog();
            animal.speak();
        }
        else if(choice == 2){
            animal = new Cat();
            animal.speak();
        }
        else System.out.println("???");
        //我们根据用户的决定来判断生成的宠物

        scanner.close();

        //总结：
        //这就是运行时多态性，它指的是
        //在运行时根据我们创建的对象的实际类型来决定执行的方法

    }

}
