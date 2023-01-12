package Tyunzhi;

import java.util.*;

public class Yun3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputString = scanner.nextLine().toLowerCase().
                replaceAll("[^a-z0-9]+", " ").split("\\s+");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        int count = 0, maxCounts = 0;
        for (int i = 0; i < inputString.length; ++i) {
            if (wordCounts.containsKey(inputString[i])) {
                count = wordCounts.get(inputString[i]) + 1;
                wordCounts.put(inputString[i], count);
                if (count > maxCounts) {
                    maxCounts = count;
                }
            } else {
                wordCounts.put(inputString[i], 1);
                if (1 > maxCounts) {
                    maxCounts = 1;
                }
            }
        }

        Set<String> keySet = wordCounts.keySet();
        ArrayList<String> resultWord = new ArrayList<>();
        for (String key : keySet) {
            if (wordCounts.get(key) == maxCounts) {
                resultWord.add(key);
            }
        }
        Collections.sort(resultWord, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(resultWord.get(0) + " " + maxCounts);
    }
}
