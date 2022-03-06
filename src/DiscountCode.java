import java.util.ArrayList;
import java.util.List;

class Result1 {

    /*
     * Complete the 'findValidDiscountCoupons' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY discounts as parameter.
     */

    public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
        // Write your code here
        List<Integer> response = new ArrayList<>();
        System.out.println(discounts);
        for (String code: discounts){
            if(code.isBlank() || code.length() == 1){
                response.add(1);
            }else if(isPalindrome(code)){
                response.add(1);
            } else{
                checkIfXAddedOnBothEnds(code);
            }

        }
        return response;
    }

    public static Boolean isPalindrome(String value){
        int i = 0;
        int j = value.length() - 1;

        while (i < j){
            if(value.charAt(i) != value.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static Boolean checkIfXAddedOnBothEnds(String value){
        int i=0, j = value.length() - 1;

        if(j < 2){
            return false;
        }

        if(j == 2){
            return isPalindrome(value);
        }

        Boolean firstMatch = false;

        while (i < j){
            if(value.charAt(i) != value.charAt(j)){
                break;
            }
            firstMatch = true;
            i++;j--;
        }

        if(!firstMatch){
            return false;
        }

        String firstPiece = value.substring(i, (j/i-1));
        String secondPiece = value.substring((j/i)-1, j+1);

        System.out.println(firstPiece);
        System.out.println(secondPiece);
        return isPalindrome(firstPiece) && isPalindrome(secondPiece);
    }
}

public class DiscountCode {
    public static void main(String[] args){
        List<String> codes =new ArrayList<>();
        codes.add("daabbd");
        codes.add("abc");

        List<Integer> result = Result1.findValidDiscountCoupons(codes);

        System.out.println(result);
    }
}
