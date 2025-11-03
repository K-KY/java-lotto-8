package lotto.view;

public class Output {
    private static final String INPUT_ORDER = "구매할 금액을 입력해주세요";
    private static final String INPUT_LOTTO = "당첨 번호 입력 (쉼표 구분)";
    private static final String INPUT_BONUS = "보너스 번호 입력";

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_ORDER);
    }

    public static void printLottoNumbersMessage() {
        System.out.println(INPUT_LOTTO);
    }

    public static void printBonusBallMessage() {
        System.out.println(INPUT_BONUS);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
