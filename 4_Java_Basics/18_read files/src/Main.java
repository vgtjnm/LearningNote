import java.io.*;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args){

        //有写就有读，这次我们来学习读取文件
        //其实写入和读取文件的类都不止一种，但是我们先学最常用的。像什么输入输出流后面再说
        //BufferedReader,缓冲读取器，可以和FileReader，文件读取器，结合使用
        //缓冲读取器本身无法读取文件，它是程序和文件系统的中间人，可以帮助我们更高效地读取文件
        //文件读取器才是真正读取文件的组件，两者结合起来可以更好地读取文件

        //下面就让我们来尝试使用一下吧
        String filePath = "D:\\ceshi\\gushi.txt";//文件需要后缀

        //缓冲处理器需要一个读取器对象，所以要与文件处理器结合
        //文件处理器还需要一个路径，我们把提前封装好的路径填进去就行了
        //BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //它说读写文件时需要使用try和catch代码块，因为总会有错误发生
        //和17的文件写入一样，我们可以把创建操作放进try的括号里面
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            //现在我们将逐行读取我们的文件使用while循环
            while((line = reader.readLine()) != null){//主要没读完就会一直读，读到空为止
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }
        catch (IOException e){
            System.out.println("Something went wrong");
        }


        //总结：
        //使用缓冲读取器配合文件读取器可以读取文件，帮助我们了解文件内容

    }

}
