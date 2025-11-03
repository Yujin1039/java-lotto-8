package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private int purchaseAmount;
    private Lotto winningNumber;
    private List<Lotto> issueNumbers;

    // 로또 번호 객체 생성
    public LottoService(int pca, List<Integer> list){
        this.purchaseAmount = pca;
        this.winningNumber = new Lotto(list);
        this.issueNumbers = new ArrayList<>();
    }

    // 로또 발행
    public void issueLotto(){
        for(int i=0; i<purchaseAmount; i++){
            Lotto issueNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            issueNumber.sortNumbers();
            issueNumbers.add(issueNumber);
        }
    }

    // 발행된 로또 반환
    public Lotto getIssueNumbers(int index){
        return issueNumbers.get(index);
    }

    // 개별 로또 당첨 여부 확인
    public void confirmLottoResult(){

    }
}
