import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Diego {

    public static final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));

        List<Integer> nums = new ArrayList<>(Integer.parseInt(lines.get(0)));
        for (String s : lines.get(1).split(" ")) {
            nums.add(Integer.valueOf(s));
        }
        nums.sort(Integer::compareTo);

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
                int currentValue = nums.get(j);
                while (j < nums.size() && currentValue == nums.get(j)) {
                    j++;
                }
                res++;
            }
            result[traders[i][0]] = res;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
