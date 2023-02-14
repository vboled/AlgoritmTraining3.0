import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CuteString {
    private static final String inputFileName = "input.txt";
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));
        int k = Integer.valueOf(lines.get(0));
        String str = lines.get(1);

        int result = 0;
        byte[] bytes = str.getBytes();

        for (int i = 0; i < str.length() && str.length() - i >= result; i++) {
            int interim = 1;
            int replacements = k;

            for (int j = i + 1; j < str.length(); j++) {
                if (bytes[i] != bytes[j]) {
                    if (replacements == 0)
                        break;
                    replacements--;
                }
                interim++;
                result = result < interim ? interim : result;
            }
        }
        System.out.println(result);
    }
}
