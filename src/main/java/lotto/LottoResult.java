package lotto;

public enum LottoResult {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000 ),
    FIRST(6, false, 2000000000);

    private final int correctNumbers;
    private final boolean isBonus;
    private final int reward;

    private LottoResult(int corNums, boolean isBonus, int reward){
        this.correctNumbers = corNums;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }
    public boolean getBonus(){ return isBonus;}
    public int getReward() {
        return reward;
    }

    public static LottoResult getResult(int corNums, boolean isBonus){
        for(LottoResult result:values()){
            if(result.getCorrectNumbers() != corNums){
                continue;
            }
            if(result.getCorrectNumbers() == 5 && result.isBonus == isBonus) return result;
            //if(result.getCorrectNumbers() == 5 && result.isBonus != isBonus) return result;
            if(result.getCorrectNumbers() != 5) return result;
        }
        return NONE;
    }
}
