package searchsuggestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SearchSuggestions {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    private static final int MAX_SUGGESTIONS = 3;
    private static final int MIN_PREFIX_LENGTH = 2;

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> keywordSuggestions = new ArrayList<>();
        if (repository == null || customerQuery == null) {
            return keywordSuggestions;
        }

        // Sorting once up front means each prefix can stop at the first three matches and
        // still return the lexicographically smallest three.
        List<String> sorted = new ArrayList<>(repository);
        Collections.sort(sorted);

        for (int length = MIN_PREFIX_LENGTH; length <= customerQuery.length(); length++) {
            String prefix = customerQuery.substring(0, length);
            List<String> suggestions = new ArrayList<>(MAX_SUGGESTIONS);

            for (String entry : sorted) {
                if (entry.startsWith(prefix)) {
                    suggestions.add(entry);
                    if (suggestions.size() == MAX_SUGGESTIONS) {
                        break;
                    }
                }
            }
            keywordSuggestions.add(suggestions);
        }
        return keywordSuggestions;
    }

    public static void main(String[] args) {
        List<String> repo = List.of("bags", "baggage", "banner", "box", "cloth");

        System.out.println(searchSuggestions(repo, "bag"));
        // [[baggage, bags, banner], [baggage, bags]]
    }
}
