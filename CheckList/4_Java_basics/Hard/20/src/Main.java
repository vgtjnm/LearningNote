
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> roster = new HashMap<>();

        roster.put("高一1班", new ArrayList<>(Arrays.asList("张伟", "李娜", "王芳")));
        roster.put("高一2班", new ArrayList<>(Arrays.asList("赵磊", "陈静")));
        roster.put("高一3班", new ArrayList<>(Arrays.asList("刘洋", "周鑫", "吴晨", "孙悦")));


        roster.putIfAbsent("高一1班", new ArrayList<>());
        roster.get("高一1班").add("宋佳");


        roster.get("高一1班").remove("李娜");


        String target = "高一1班";
        System.out.println(target + ": " + roster.get(target));


        String largest = null;
        int max = 0;
        for (Map.Entry<String, ArrayList<String>> entry : roster.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                largest = entry.getKey();
            }
        }
        System.out.println("人数最多的班级 - " + largest + "（" + max + "人）: " + roster.get(largest));
    }
}
