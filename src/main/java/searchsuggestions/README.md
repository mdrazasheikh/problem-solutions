# Search Suggestions

Returns repository suggestions for each growing prefix of a customer query.

Approach: filter matching repository entries and retain the first three suggestions per prefix.

Complexity: O(p * r) in the direct scan, where p is query length and r is repository size.
