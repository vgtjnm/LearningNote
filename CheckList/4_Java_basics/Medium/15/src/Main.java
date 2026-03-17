public class Main {

    public static void main(String[] args){

        Document document = new Document();

        Printable p = document;
        Saveable s = document;

        String str = "世界上最感人的故事";
        s.save(str);
        p.printlnfo();

    }

}
