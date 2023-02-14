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

        for (int i = 0; i < str.length(); i++) {
            int interim = 1;
            int replacements = k;
            int lastFit = -1;
            boolean isSignFirst = true;

            for (int j = str.length() - 1; j > i; j--) {
                if (bytes[i] != bytes[j]) {
                    if (replacements == 0) {
                        replacements = k;
                        interim = 1;
                        j = lastFit;
                        lastFit = -1;
                        isSignFirst = true;
                    }
                    replacements--;
                } else {
                    if (isSignFirst) {
                        isSignFirst = false;
                    } else {
                        lastFit = lastFit == -1 ? j : lastFit;
                        System.out.print(lastFit + " ");
                        System.out.print(j + ", ");
                    }
                }
                interim++;
                result = result < interim ? interim : result;
            }
            System.out.println("i = " + i);
        }
        System.out.println(result);
    }
}
