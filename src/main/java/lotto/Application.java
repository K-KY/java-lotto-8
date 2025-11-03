package lotto;


import lotto.view.UserView;

public class Application {
    public static void main(String[] args) {

        UserView instance = UserView.getInstance();
        instance.inputPurchaseInfo();
    }
}
