import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        //这次我们来学习如何写入文件

        //写入文件可以使用FileWriter的对象
        //然后我们需要在括号里传入文件路径或文件名
        //FileWriter fileWriter = new FileWriter("test.txt");

        //读写文件是不可预测的，你可以将其视为危险代码
        //任何危险代码都应该用try语句块包裹起来
        //新版本的java中try语句可以打开一些资源，只需要加个括号就行
        //我可以尝试打开一个文件读写器
        try(FileWriter fileWriter = new FileWriter("D:\\cehi\\test.txt");){
            fileWriter.write("I like apple!");//可以把内容写进String
            System.out.println("File has been written");
            //文件输入之后如果你没有指定路径，那么大概率在你的源文件里面
            //我们也可以使用绝对路径去指定他，你可以去复制一个地址直接粘贴到括号里比如
            //"D:\\ceshi\\test.txt"，注意要用双斜杠，单斜杠是转义字符
        }
        catch(FileNotFoundException e){//如果你的文件地址错误，那么就需要捕获这个异常
            System.out.println("Could not locate file location");
        }
        catch(IOException e){
            System.out.println("Could not write file");
        }

        //总结：
        //FileWriter是一个很好的类，帮助我们写入文件

    }

}
