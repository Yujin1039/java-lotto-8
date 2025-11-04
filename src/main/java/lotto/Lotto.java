package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        unRepeatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 중복 여부 확인
    private void unRepeatedNumber(List<Integer> numbers){
        Set<Integer> nonRepeatedNumbers = new HashSet<>(numbers);

        if(nonRepeatedNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 당첨번호를 가질 수 없습니다.");
        }
    }

    public List<Integer> getLotto(){
        return numbers;
    }

    // 로또번호 정렬
    public void sortNumbers(){
        Collections.sort(numbers);
    }

}
