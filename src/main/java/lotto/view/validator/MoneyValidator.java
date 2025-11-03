package lotto.view.validator;

public class MoneyValidator {

    public static boolean isRemainZero(Integer number, Integer divisor) {
        if (number >= 1000 && number % divisor == 0) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
    }
}
