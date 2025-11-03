package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.LottoNumberValidator;
import lotto.view.validator.MoneyValidator;
import lotto.view.validator.NumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String INPUT_NUMBER_EXCEPTION = "[ERROR] 숫자를 입력해주세요.";

    public static int money() {
        while (true) {
            Output.printInputMoneyMessage();
            String input = Console.readLine();
            try {
                int money = parseInt(input);
                MoneyValidator.isRemainZero(money, 1000);
                return money;
            } catch (NumberFormatException e) {
                Output.printMessage(e.getMessage());
            } catch (IllegalArgumentException e) {
                Output.printMessage(e.getMessage());
            }
        }
    }

    private static int parseInt(String number) {
        if (NumberValidator.isNumber(number)) {
            return Integer.parseInt(number);
        }
        throw new NumberFormatException(INPUT_NUMBER_EXCEPTION);
    }

    public static List<Integer> lotto() {
        while (true) {
            List<Integer> lotto;
            Output.printLottoNumbersMessage();
            String s = contact(Console.readLine());
            try {
                lotto = parseInt(Arrays.asList(s.split(",")));
                isCompliance(lotto);
                return lotto;
            } catch (RuntimeException e) {
                Output.printMessage(e.getMessage());
            }
        }
    }

    private static void isCompliance(List<Integer> lotto) {
        LottoNumberValidator.isDuplicated(lotto);
        LottoNumberValidator.isValidLength(lotto);
        LottoNumberValidator.isValidRange(lotto);
    }

    //문자열 사이 공백 제거
    private static String contact(String s) {
        return s.replace(" ", "");
    }

    private static List<Integer> parseInt(List<String> number) {
        try {
            return number.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION);
        }
    }

    public static int bonusBall(List<Integer> lotto) {
        while (true) {
            Output.printBonusBallMessage();
            String input = Console.readLine();
            try {
                int bonusBall = parseInt(input);
                LottoNumberValidator.isValidRange(bonusBall);
                LottoNumberValidator.isLottoContainsBonusBall(lotto, bonusBall);
                return bonusBall;
            } catch (IllegalArgumentException e) {
                Output.printMessage(e.getMessage());
            } catch (RuntimeException e) {
                Output.printMessage(e.getMessage());
            }
        }
    }
}
