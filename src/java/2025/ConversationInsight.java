static class Message {
    String author;
    String text;

    Message(String author, String text) {
        this.author = author;
        this.text = text;
    }
}

static class ConversationSummary {
    Map<String, Integer> messageCount = new HashMap<>();
    double avgUserMessageLength;

    @Override
    public String toString() {
        return "Counts: " + messageCount + ", AvgUserWords: " + avgUserMessageLength;
    }
}

public static ConversationSummary summarizeConversation(List<Message> messages) {
    ConversationSummary summary = new ConversationSummary();
    int userMessageCount = 0;
    int totalUserWords = 0;

    for (Message m : messages) {
        summary.messageCount.merge(m.author, 1, Integer::sum);
        if ("user".equalsIgnoreCase(m.author)) {
            userMessageCount++;
            totalUserWords += m.text.trim().split("\\s+").length;
        }
    }

    summary.avgUserMessageLength = userMessageCount == 0 ? 0 :
            (double) totalUserWords / userMessageCount;

    return summary;
}

void main() {
    List<Message> messages = Arrays.asList(
            new Message("agent", "Hello! How can I help you?"),
            new Message("user", "Hi, I'm having trouble logging in."),
            new Message("agent", "Can you try resetting your password?")
    );

    IO.println(summarizeConversation(messages));
    // Counts: {agent=2, user=1}, AvgUserWords ≈ 6.0
}
