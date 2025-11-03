package validator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    // 1000원 단위로 나눠떨어지는지 확인
    public static int checkDivisibility(String number, int minUnit){

        int amount = convertToNumber(number);

        if(amount % minUnit != 0){
            throw new IllegalArgumentException("[ERROR] 최소 입력 단위는 "+minUnit+"원입니다.");
        }
        return amount;
    }

    // 숫자인지 확인
    public static int convertToNumber(String number){
        if(number.isEmpty() || number.trim().isEmpty()){
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
        }

        try{
            return Integer.parseInt(number);
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    // 1~45 사이의 숫자인지 확인
    public static int convertToNumberInRange(int number){
        int MIN_VALUE = 1;
        int MAX_VALUE = 45;
        if(number < MIN_VALUE || number > MAX_VALUE){
            throw new IllegalArgumentException("[ERROR] "+MIN_VALUE+"~"+MAX_VALUE+"사이의 숫자만 입력 가능합니다.");
        }

        return number;
    }

    // 구분자 기준 숫자 리스트 변환
    public static List<Integer> convertToList(String LottoNumbers,String separtor){

        // 구분자 기준 분리
        String[] tempNums = LottoNumbers.split(separtor);

        // String[] → List로 변환
        List<Integer> numberList = new ArrayList<>();
        for(String number:tempNums){
            int num = convertToNumberInRange(convertToNumber(number));
            numberList.add(num);
        }
        return numberList;
    }
}
