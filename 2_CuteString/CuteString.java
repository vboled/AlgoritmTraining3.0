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
            int j = 0;
            int replacements = k;
            for (int i = 0; i < str.length(); i++) {
                while (j < str.length()) {
                    if (bytes[j] != ch) {
                        if (replacements == 0)
                            break;
                        replacements--;
                    }
                    j++;
                }
                result = Math.max(result, j - i);
                if (bytes[i] != ch) {
                    replacements++;
                }
            }
        }
        System.out.println(result);
    }
}
