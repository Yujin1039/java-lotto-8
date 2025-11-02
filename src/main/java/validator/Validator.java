package validator;

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
}
