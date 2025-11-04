package Output;

public class Formatter {
    public static void printStatics(int correctNumber, boolean isBonus, int reward, int count){
        System.out.print(correctNumber+"개 일치");
        if(isBonus) {
            System.out.print(", 보너스 볼 일치 ");
        }
        if(!isBonus){
            System.out.print(" ");
        }
        System.out.printf("(%,d원) - ", reward);
        System.out.println(count +"개");
    }
}
