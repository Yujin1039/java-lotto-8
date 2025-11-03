package lotto;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void run(){
        // 입력1: 로또 구입 금액
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Validator.checkDivisibility(Console.readLine(), 1000);

        // 출력1: 발행 로또 수량
        int purchaseAmount = purchasePrice/1000;
        System.out.printf("%d개를 구매했습니다.\n",purchaseAmount);

        // 로또 발행
        LottoService lottoService = new LottoService(purchaseAmount);//, winningNumbers, bonusNumber);
        lottoService.issueLotto();

        // 출력2: 발행 로또 번호
        for(int i=0; i<purchaseAmount; i++){
            Lotto issuedLotto = lottoService.getIssueNumbers(i);
            System.out.println(issuedLotto.getLotto());
        }
        System.out.println();

        // 입력2: 당첨 번호
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Validator.convertToList(Console.readLine(),",");

        // 입력3: 보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Validator.convertToNumber(Console.readLine());

        // 당첨 번호 저장
        lottoService.setUpWinningLotto(winningNumbers, bonusNumber);

        // 출력3: 당첨 내역
        Map<LottoResult,Integer> result = lottoService.saveLottoResult();

        System.out.println("당첨 통계");
        System.out.println("---");

        int winningPrize = 0;
        for(Map.Entry<LottoResult,Integer> entry:result.entrySet()){
            LottoResult key = entry.getKey();
            int count = entry.getValue();

            if(key.getCorrectNumbers() == 0) continue;
            System.out.print(key.getCorrectNumbers()+"개 일치 ");
            System.out.printf("(%,d원) - ", key.getReward());
            System.out.println(count +"개");
            winningPrize += key.getReward() * entry.getValue();
        }

        // 출력4: 수익률
        float roi = (float) winningPrize /purchasePrice*100;

        // 소수점 둘째 자리 반올림
        BigDecimal bd = new BigDecimal(String.valueOf(roi));
        BigDecimal final_roi = bd.setScale(1, RoundingMode.HALF_UP);
        System.out.printf("총 수익률은 %s%%입니다.%n",final_roi.toString());
    }
}
