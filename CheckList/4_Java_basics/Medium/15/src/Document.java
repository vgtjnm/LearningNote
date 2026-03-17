public class Document implements Printable, Saveable{

    private String str;

    @Override
    public void printlnfo(){
        System.out.println(str);
    }

    @Override
    public void save(String str){
        this.str = str;
        System.out.println("文档已保存并修改");
    }

}
