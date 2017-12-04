package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daniel on 4/12/2017.
 */

public class Validate {
    public boolean emailIsValid(String email){
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
