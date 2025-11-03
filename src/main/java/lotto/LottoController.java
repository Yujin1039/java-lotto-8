package lotto;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run(){
        // 입력1: 로또 구입 금액
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Validator.checkDivisibility(Console.readLine(), 1000);

        // 입력2: 당첨 번호
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Validator.convertToList(Console.readLine(),",");

        // 입력3: 보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Validator.convertToNumber(Console.readLine());

        // 출력1: 발행 로또 수량
        int purchaseAmount = purchasePrice/1000;
        System.out.printf("%d개를 구매했습니다.\n",purchaseAmount);

        // 로또 발행
        LottoService lottoService = new LottoService(purchaseAmount, winningNumbers, bonusNumber);
        lottoService.issueLotto();

        // 출력2: 발행 로또 번호
        for(int i=0; i<purchaseAmount; i++){
            Lotto issuedLotto = lottoService.getIssueNumbers(i);
            System.out.println(issuedLotto.getLotto());
        }

        // 출력3: 당첨 내역
        Map<LottoResult,Integer> result = lottoService.saveLottoResult();

        System.out.println("당첨 통계");
        System.out.println("---");


        // 출력4: 수익률
    }
}
