package pekopeko.afpa.Utility;

public class regexUtility {
    //attribut regex
    private static String POSITIVE_INT_REGEX = "\\d+";
    private static final String ALPHA = "^[a-zA-Z]+$";

    public static boolean PositifInt (String input) {
        return input != null && input.matches(POSITIVE_INT_REGEX);
    }

    public static boolean PositiveIntStrict(String input) {
        return input != null && input.matches("[1-9]\\d*");
    }

    public static boolean regexAlpha(String input) {
        return input != null && input.matches(ALPHA);
    }
}
