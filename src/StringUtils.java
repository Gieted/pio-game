import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private StringUtils() {}

    public static String incrementPostfix(String string) {
        Pattern pattern = Pattern.compile("(.*?)(\\d+)$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String nameWithoutPostfix = matcher.group(1);
            int currentPostfix = Integer.parseInt(matcher.group(2));
            return nameWithoutPostfix + (currentPostfix + 1);
        } else {
            return string + "1";
        }
    }
}
