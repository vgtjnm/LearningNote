import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //这次我们来学习exception handling，异常处理
        //异常是指会中断程序正常流程的事件，比如
        //当你执行除以0的1操作时，由于某种原因找不到资源时，输入类型不匹配时
        //以上操作就会出现异常，这类事件会中断程序，它们被称为异常
        //我们可以使用try，catch，finally代码来处理它们

        //任何可能中断程序的危险代码都可以用try包裹起来
        //我们来举个例子，正常来讲1不能除以0，但是我们可以try

        try{
            System.out.println(1 / 0);
        }

        //但是try还不够，一般我们还要搭配一个catch代码来捕获
        //我们需要在catch的括号里输入我们要捕获的具体异常类型，要是不知道异常类型，错误运行会显示
        //我们这次捕获的是ArithmeticException，算术异常
        //当我们遇到这个异常时我们不用中断程序，而是采取其它措施

        catch(ArithmeticException e){//e是它的别名
            System.out.println("YOU CAN'T DIVIDE BY ZERO!");
        }

        //任何导致异常的危险代码都可以用try代码块包裹起来
        //你可以添加多个catch代码块来捕获和处理特定的异常

        //下面是模拟用户输入
        //我们先模拟一遍用户的异常输入拿到异常类型
        //有些异常类型需要导入

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number：");
            int number = scanner.nextInt();
            System.out.println(number);
        }
        catch (InputMismatchException e){
            System.out.println("That wasn't number!");
        }
        //你也可以使用Exception捕获所有异常，但通常我们需要让用户知道哪里出了问题
        //不过为了预防我们没料到的情况，我们需要捕获所有异常
        catch (Exception e){
            System.out.println("Something went wrong");//防止意想不到的情况发生
        }
        scanner.close();

        //讲完了try和catch，我们来说finally

        //finally代码块是可选的，无论是否发生异常它都会运行，而且它需要try代码块为前提
        //比如说scanner没有关闭，那么就把它关闭
        //它通常用来解决如果发生了异常，那么可能不会关闭的东西
        //在其它情况下，比如你再try代码块打开了一个文件，
        //那么在完成操作后，你需要关闭该文件，你可以在finally代码块执行操作

        try{
            System.out.println(1/0);
        }

        finally{
            scanner.close();
            System.out.println("This always executes");
        }

        //总结：
        //try，catch，finally是遇到异常时的好帮手
        //catch和finally都需要前面有try才能运行
        //使用catch捕获异常时，可以先错误运行一遍拿到异常类型
        //finally用来关闭一些可能因为异常没有关闭的程序

    }

}
