import java.io.File;
import java.io.IOException;
import java.util.*;

public class Diego {

    public static final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));

        int collectionSize = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < collectionSize; i++) {
            treeSet.add(scanner.nextInt());
        }

        int n = scanner.nextInt();

        List<Integer> traders = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            traders.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int res = 0;
            for (Integer num : treeSet) {
                if (num < traders.get(i)) {
                    res++;
                } else {
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
