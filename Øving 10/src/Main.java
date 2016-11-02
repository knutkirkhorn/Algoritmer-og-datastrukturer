import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Knut on 25.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\W*\\W\\W*");//".*\\d.*");//"[a-z]*[0-9][a-z]*");//"[a-z]*[0-9]");//Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("€&#");//"aaaaab");
        boolean asd = matcher.matches();
        System.out.println(asd);
    }
}
