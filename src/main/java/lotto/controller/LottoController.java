package lotto.controller;

import lotto.Lotto;
import lotto.dto.Statistics;
import lotto.service.Game;
import lotto.service.LottoService;
import lotto.service.Ticket;
import lotto.service.utils.ListMap;

import java.util.List;

public class LottoController {
    private static final LottoService lottoService = LottoService.getInstance();
    private static LottoController lottoController;

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public Statistics buyLotto(int money, List<Integer> lottoNumber, int bonusBall) {
        //구매한 로또
        Ticket ticket = lottoService.buyLotto(money);
        String string = ticket.toString();
        System.out.println(string);
        //사용자가 입력한 로또
        Lotto lotto = new Lotto(lottoNumber);

        //당첨된 로또를 맞은 번호로 구분
        ListMap<Integer, Game> sortedGames = lotto.checkTicket(ticket);

        return lottoService.calculateResult(sortedGames, bonusBall);
    }
}
