import java.util.*;

public class Hand {
    public static char[] hand;
    public Hand(String hand) {
        this.hand = hand.toCharArray();
    }

    public static Map<ArrayList<Integer>, Integer> cardHands = new HashMap<>() {{
        put(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)), 1);   // High card
        put(new ArrayList<>(Arrays.asList(2, 1, 1, 1)), 2);     // Pair
        put(new ArrayList<>(Arrays.asList(2, 2, 1)), 3);        // Two pair
        put(new ArrayList<>(Arrays.asList(3, 2)), 4);           // Full house
        put(new ArrayList<>(Arrays.asList(3, 1, 1)), 5);        // Three of a kind
        put(new ArrayList<>(Arrays.asList(4, 1)), 6);           // High card
        put(new ArrayList<>(Arrays.asList(5)), 7);              // Five of a kind
    }};

    /**
     * Returns a hashmap of each card type
     * and how many times it appears in a hand
     * @return Returns a hashmap of card type and count of each card
     */
    public static HashMap<Character, Integer> getCardTypeCounts() {
        HashMap<Character, Integer> cardTypes = new HashMap<>();
        for (char card: hand){
            if (!cardTypes.containsKey(card)) {
                cardTypes.put(card, 1);
            } else {
                Integer cardCount = cardTypes.get(card)+1;
                cardTypes.put(card, cardCount);
            }
        }
        return cardTypes;
    }

    /**
     * Returns a simple list of the counts of each card type
     * @return Returns a list of each card type for example: [2,2,1]
     */
    public ArrayList<Integer> getCardTypeList() {
        HashMap<Character, Integer> cardTypes = getCardTypeCounts();
        ArrayList<Integer> cardCounts = new ArrayList<>();
        for (Character cardType: cardTypes.keySet()) {
            cardCounts.add(cardTypes.get(cardType));
        }

        return cardCounts;
    }

    /**
     * Gets the hands value, between 1 and 18
     * @return Returns a number between 1 and 18
     * with 18 being the strongest and 1 the weakest
     */
    public int getHandValue() {
        ArrayList<Integer> values = getCardTypeList();
        Collections.sort(values);
        Collections.reverse(values);

        return cardHands.get(values);
    }

    public String getCompiledValues() {
        String compiledValues = "";
        for (char card: hand) {
            compiledValues += new Card(card).alphaValue;
        }
        return compiledValues;
    }
}
