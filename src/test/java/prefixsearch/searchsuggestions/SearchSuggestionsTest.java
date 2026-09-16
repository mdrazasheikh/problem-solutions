package prefixsearch.searchsuggestions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SearchSuggestionsTest {

    private static final List<String> REPO =
            List.of("bags", "baggage", "banner", "box", "cloth");

    @Test
    void returnsOneListPerPrefixFromLengthTwo() {
        List<List<String>> result = SearchSuggestions.searchSuggestions(REPO, "bag");

        assertEquals(2, result.size(), "prefixes are 'ba' and 'bag'");
    }

    @Test
    void suggestsEntriesSharingThePrefix() {
        List<List<String>> result = SearchSuggestions.searchSuggestions(REPO, "bag");

        assertEquals(List.of("baggage", "bags", "banner"), result.get(0));
        assertEquals(List.of("baggage", "bags"), result.get(1));
    }

    @Test
    void capsEachPrefixAtThreeSuggestions() {
        List<String> repo = List.of("ba1", "ba2", "ba3", "ba4", "ba5");

        List<List<String>> result = SearchSuggestions.searchSuggestions(repo, "bag");

        assertEquals(List.of("ba1", "ba2", "ba3"), result.get(0));
    }

    @Test
    void returnsTheLexicographicallySmallestThree() {
        List<String> repo = List.of("bax", "bam", "bab", "baz");

        List<List<String>> result = SearchSuggestions.searchSuggestions(repo, "ba");

        assertEquals(List.of("bab", "bam", "bax"), result.get(0));
    }

    @Test
    void treatsTheQueryLiterallyNotAsARegex() {
        List<String> repo = List.of("b.g", "bag", "bxg");

        List<List<String>> result = SearchSuggestions.searchSuggestions(repo, "b.g");

        assertEquals(List.of("b.g"), result.get(1), "'.' must not match any character");
    }

    @Test
    void returnsEmptyListsWhenNothingMatches() {
        List<List<String>> result = SearchSuggestions.searchSuggestions(REPO, "zz");

        assertEquals(List.of(List.of()), result);
    }

    @Test
    void handlesQueriesShorterThanTwoCharacters() {
        assertEquals(List.of(), SearchSuggestions.searchSuggestions(REPO, "b"));
    }
}
