package lotto.view.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    private static final int LOTTO_PICK = 6;

    public static void isDuplicated(List<Integer> lottoNumbers) {
        Set<Integer> duplicatedNumbers = new HashSet<>(lottoNumbers);
        if (duplicatedNumbers.size() == lottoNumbers.size()) {
            return;
        }
        throw new NumberDuplicatedException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
    }

    public static void isValidLength(List<Integer> lotto) {
        if (lotto.size() == LOTTO_PICK) {
            return;
        }
        throw new NumberLengthException("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    public static void isValidRange(List<Integer> lotto) {
        for (Integer n : lotto) {
            isValidRange(n);
        }
    }

    public static void isValidRange(Integer number) {
        if (number > 45 || number < 1) {
            throw new NumberRangeException("[ERROR] 1 ~ 45 범위의 숫자를 입력해주세요");
        }
    }

    public static void isLottoContainsBonusBall(List<Integer> lotto, int bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력한 번호와 중복되지 않는 번호를 입력해주세요.");
        }
    }
}
