import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Diego {

    public static final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (String s : lines.get(1).split(" ")) {
            treeSet.add(Integer.valueOf(s));
        }
        List<Integer> nums = treeSet.stream().collect(Collectors.toList());

        int n = Integer.parseInt(lines.get(2));

        int[][] traders = new int[n][2];
        int[] result = new int[n];

        int k = 0;
        for (String s : lines.get(3).split(" ")) {
            traders[k][1] = Integer.parseInt(s);
            traders[k][0] = k++;
        }

        Arrays.sort(traders, Comparator.comparing(l -> l[1]));

        int res = 0, j = 0;

        for (int i = 0; i < n; i++) {
            while (j < nums.size() && traders[i][1] > nums.get(j)) {
                res++;
                j++;
            }
            result[traders[i][0]] = res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
