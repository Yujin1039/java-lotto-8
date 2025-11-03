package lotto;

public enum LottoResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000 ),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

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
            if(corNums == 3 || corNums == 4 || corNums == 6){
                return result;
            }
            if(corNums == 5 && isBonus) return result;
            if(corNums == 5) return result;
        }
        return NONE;
    }
}
