package srhe.dittmar;

public class Validation {

    public static int depositAmountValidation (int amount) {
        if (amount < 10)
        return 1;
        else if (amount >10000) {
            return 2;}
        else return 3;
    }
    public static boolean incrementValidation(int amount){
        return amount % 10 == 0;
    }

    public static boolean withdrawAmountValidation (int amount, int currentBalance){
        return amount <= currentBalance;
    }

}
