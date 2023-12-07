import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] hands = PuzzleInput.puzzleInput.split("\n");
        ArrayList<String> valuedSet = new ArrayList<>();
        for (String handSet: hands) {
            String[] handData = handSet.split(" ");

            String cardSet = handData[0];
            int bet = Integer.valueOf(handData[1]);

            Hand hand = new Hand(cardSet);
            int handValue = hand.getHandValue();
            String compiledValues = hand.getCompiledValues();

            valuedSet.add(handValue + " " + compiledValues + " " + bet + " " + cardSet);
        }
        Collections.sort(valuedSet);
        Collections.reverse(valuedSet);

        int rank = 1;
        int totalBids = 0;
        for (String values: valuedSet) {
            CompiledHand compiledHand = new CompiledHand(values);
            totalBids += rank*compiledHand.bet;
            System.out.println(rank + ". | " + compiledHand.normalisedHand);
            rank++;
        }
        System.out.println("Total winnings: " + totalBids);
    }



}
