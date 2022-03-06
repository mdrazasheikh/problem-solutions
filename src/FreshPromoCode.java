import java.util.ArrayList;
import java.util.List;

public class FreshPromoCode {
    public static int foo(List<String> codeList, List<String> shoppingCart) {
        // Write your code here
        String codeListAsString = String.join(" ", codeList);
        codeListAsString = ".*" + codeListAsString.replace("anything", "\\w+") + ".*";
        System.out.println(codeListAsString);
        String shoppingCartAsString = String.join(" ", shoppingCart);
        System.out.println(shoppingCartAsString);

        if(shoppingCartAsString.matches(codeListAsString))
            return 1;
        return 0;
    }

    public static void main(String[] args){
        List<String> codeList = new ArrayList<>();
        codeList.add("orange");
        codeList.add("apple apple");
        codeList.add("banana anything apple");
        codeList.add("banana");

        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("kiwi");
        shoppingCart.add("apple");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("melon");
        shoppingCart.add("grape");

        int res = foo(codeList, shoppingCart);
        System.out.println("Res: " + res);
    }
}
