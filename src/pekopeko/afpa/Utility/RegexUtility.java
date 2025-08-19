package pekopeko.afpa.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtility {
    //attribut regex
    private static String POSITIVE_INT_REGEX = "\\d+";
    private static final String ALPHA = "^[a-zA-Z]+$";
    private static final String ALPHA_NUMERIC = "^[a-zA-Z0-9_.-]*$";

    public static boolean PositifInt (String input) {
        return input != null && input.matches(POSITIVE_INT_REGEX);
    }

    public static boolean PositiveIntStrict(String input) {
        return input != null && input.matches("[0-6]\\d*");
    }

    public static boolean regexAlpha(String input) {
        return input != null && input.matches(ALPHA);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
