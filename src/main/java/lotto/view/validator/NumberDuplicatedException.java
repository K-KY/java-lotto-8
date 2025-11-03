package lotto.view.validator;

public class NumberDuplicatedException extends RuntimeException {
    public NumberDuplicatedException(String message) {
        super(message);
    }
}
