import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段英文句子：");
        String sentence = scanner.nextLine().toLowerCase(); // 转小写统一处理


        String[] words = sentence.split("[^a-zA-Z]+");


        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }


        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());


        System.out.println("\n出现次数最多的前 3 个单词：");
        int top = Math.min(3, list.size());
        for (int i = 0; i < top; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getKey()
                    + " → " + list.get(i).getValue() + " 次");
        }

        scanner.close();

    }
}
