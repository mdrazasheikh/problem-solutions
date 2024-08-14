package java;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoValuesInArr {

    public static Boolean checkSumInArr(int[] contextArr, int value){
        Set<Integer> foundValues = new HashSet<Integer>();

        for(int a: contextArr){
            if(foundValues.contains(value-a)){
                System.out.println("Sum found for " + value);
                System.out.println(value-a + "," + a);
                return true;
            }
            foundValues.add(a);
        }

        return false;
    }

    public static void main(String[] args){
        int[] contextArr = new int[] {3,9,11,8,2,7};
        int[] test = new int[] {4,11,6,20,5};

        for (int t: test){
            Boolean result = checkSumInArr(contextArr, t);
            System.out.println("Sum found for (" + t + ")" + (result ? "true" : "false"));
        }
    }
}
