import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Diego {

    public static final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));

        int collectionSize = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < collectionSize; i++) {
            treeSet.add(scanner.nextInt());
        }
        List<Integer> num = treeSet.stream()
                .sorted()
                .collect(Collectors.toList());

        int n = scanner.nextInt();

        int[][] traders = new int[n][2];
        for (int i = 0; i < n; i++) {
            traders[i][0] = i;
            traders[i][1] = scanner.nextInt();
        }
        Arrays.sort(traders, Comparator.comparing(l -> l[1]));

        int res = 0, j = 0;

        for (int i = 0; i < n; i++) {
            while (j < num.size() && traders[i][1] > num.get(j)) {
                res++;
                j++;
            }
            traders[i][1] = res;
        }

        Arrays.sort(traders, Comparator.comparing(l -> l[0]));
        for (int i = 0; i < n; i++) {
            System.out.println(traders[i][1]);
        }
    }
}
