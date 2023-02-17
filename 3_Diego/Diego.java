import com.sun.security.jgss.InquireSecContextPermission;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Diego {

    public static final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();

        List<Integer> numList = new ArrayList<>(n);
        while (n-- > 0) {
            numList.add(scanner.nextInt());
        }

        SortedSet<Integer> setNumbers = new TreeSet<>(numList);

        n = scanner.nextInt();
        while (n-- > 0) {
            int mark = scanner.nextInt();

            if (mark > setNumbers.last()) {
                System.out.println(setNumbers.size());
            } else {
                Iterator<Integer> myIt = setNumbers.iterator();

                Integer res = 0;

                while (myIt.hasNext()) {
                    if (mark <= myIt.next()) {
                        System.out.println(res);
                        break;
                    }
                    res++;
                }
            }
        }
    }
}
