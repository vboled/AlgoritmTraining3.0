import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CuteString {
    private static final String inputFileName = "input.txt";
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));
        int k = Integer.parseInt(lines.get(0));
        String str = lines.get(1);

        int result = 0;
        byte[] bytes = str.getBytes();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int repl = k;
            int j = -1;
            int i = str.indexOf(ch);
            if (i == -1)
                continue;
            while (i < str.length()) {
                if (j == -1) {
                    j = i + 1;
                } else {
                    if (bytes[i - 1] != ch) {
                        repl++;
                    }
                }
                while (j < str.length()) {
                    if (bytes[j] != ch) {
                        if (repl == 0)
                            break;
                        repl--;
                    }
                    j++;
                }
                result = Math.max(result, j - i);
                i++;
            }
        }
        System.out.println(result);
    }
}
