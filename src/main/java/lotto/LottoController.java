package lotto;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class LottoController {
    public static void main(String[] args){
        // 입력1: 로또 구입 금액
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Validator.checkDivisibility(Console.readLine(), 1000);

        // 입력2: 당첨 번호

        // 입력3: 보너스 번호

        // 출력1: 발행 로또 수량

        // 출력2: 발행 로또 번호

        // 출력3: 당첨 내역

        // 출력4: 수익률
    }
}
