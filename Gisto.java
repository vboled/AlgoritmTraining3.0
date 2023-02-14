import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Gisto {

    private static final String inputFileName = "input.txt";
    private static final Map<Integer, Integer> signs = new HashMap();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));

        lines.stream().forEach(line -> {
            line.chars()
                    .filter(ch -> !Character.isWhitespace(ch))
                    .forEach(ch -> signs.compute(ch, (k, v) -> (v == null) ? 1 : v + 1));
        });

        int max = signs.values().stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .get()
                .intValue();

        List<Integer> sortedKeyList = signs.keySet().stream().sorted().collect(Collectors.toList());

        for (int it = 0; it < max; it++) {
            int finalIt = it;
            sortedKeyList.forEach(ch-> {
                if (max - finalIt <= signs.get(ch))
                    System.out.print("#");
                else
                    System.out.print(" ");
            });
            System.out.println("");
        }
        sortedKeyList.forEach(ch -> {
            System.out.print((char) ch.byteValue());
        });
    }
}
