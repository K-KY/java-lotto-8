package lotto.view.validator;

import java.util.regex.Pattern;

public class NumberValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public static boolean isNumber(String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }
}
