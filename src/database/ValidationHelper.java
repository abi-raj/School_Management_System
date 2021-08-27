package database;

import java.util.regex.Pattern;

public class ValidationHelper {
    public static Pattern email = Pattern.compile(".*@skcet\\.ac\\.in$");
    public static Pattern password = Pattern.compile("^(?=.{5,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$");
    public static Pattern mobile = Pattern.compile("^\\d{10}$");
}
