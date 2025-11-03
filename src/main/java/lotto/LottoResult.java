package lotto;

public enum LottoResult {
    FIRST(6, 2000000000),
    SECOND(6, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int correctNumbers;
    private int reward;

    private LottoResult(int corNums, int reward){
        this.correctNumbers = corNums;
        this.reward = reward;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }

    public int getReward() {
        return reward;
    }
}
