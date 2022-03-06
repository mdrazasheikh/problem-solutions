import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class SearchSuggestions {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        List<List<String>> keywordSuggestions = new ArrayList<>();
        System.out.println(repository);
        for(int i=2; i<= customerQuery.length(); i++){
            List<String> suggestions = new ArrayList<>();
            String subString = customerQuery.substring(0, i) + "\\w*";
//            System.out.println(subString);
            for (String temp:repository){
                if(temp.matches(subString)){
//                    System.out.println(temp);
                    suggestions.add(temp);
                }
            }
            keywordSuggestions.add(suggestions);
        }
        System.out.println(keywordSuggestions);
        return keywordSuggestions;
    }

    public static void main(String[] args){
        List<String> repo = new ArrayList<>();
        repo.add("bags");
        repo.add("baggage");
        repo.add("banner");
        repo.add("box");
        repo.add("cloth");
        searchSuggestions(repo, "bag");
    }
}