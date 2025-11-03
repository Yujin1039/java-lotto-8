package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {
    private int purchaseAmount;
    private Lotto winningLotto;
    private List<Lotto> issueLottos;
    private int bonusNumber;
    private Map<LottoResult, Integer> result;

    // 발행 로또 번호 객체 생성
    public LottoService(int pca){
        this.purchaseAmount = pca;
        this.issueLottos = new ArrayList<>();
    }

    // 당첨 로또 번호 저장
    public void setUpWinningLotto(List<Integer> list, int bonusNumber){
        this.winningLotto = new Lotto(list);
        this.bonusNumber = bonusNumber;
    }

    // 로또 발행
    public void issueLotto(){
        for(int i=0; i<purchaseAmount; i++){
            Lotto issueNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            issueNumber.sortNumbers();
            issueLottos.add(issueNumber);
        }
    }

    // 발행된 로또 반환
    public Lotto getIssueNumbers(int index){
        return issueLottos.get(index);
    }

    // 당첨 번호 개수 확인
    public int confirmWinningNumbers(Lotto lotto){
        int winning = 0;
        for(Integer number:lotto.getLotto()){
            if(winningLotto.getLotto().contains(number)){
                winning++;
            }
        }
        return winning;
    }

    // 보너스 번호 당첨 여부 확인
    public boolean confirmWinningBonus(Lotto lotto){
        return lotto.getLotto().contains(bonusNumber);
    }

    // 당첨 결과 저장
    public Map<LottoResult,Integer> saveLottoResult(){
        result = new EnumMap<>(LottoResult.class);

        // Map 초기화
        for(LottoResult init:LottoResult.values()){
            result.put(init,0);
        }

        for(Lotto lotto:issueLottos){
            int winningNumbers = confirmWinningNumbers(lotto);
            boolean bonus = confirmWinningBonus(lotto);

            LottoResult lottoResult = LottoResult.getResult(winningNumbers, bonus);
            result.compute(lottoResult, (k, prevResult) -> prevResult + 1);
        }
        return result;
    }
}
