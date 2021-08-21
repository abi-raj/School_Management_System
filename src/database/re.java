package database;
import java.util.regex.Pattern;

public class re {
    public static Pattern email = Pattern.compile("^\\d{2}[a-zA-z]+\\d+@skcet\\.edu$");
    public static Pattern password = Pattern.compile("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).*$");
    public static Pattern mobile = Pattern.compile("^\\d{10}$");
}
