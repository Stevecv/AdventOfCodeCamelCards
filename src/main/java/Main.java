import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] hands = PuzzleInput.myPuzzleInput.split("\n");
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

        int rank = 1;
        int totalBids = 0;
        for (String values: valuedSet) {
            CompiledHand compiledHand = new CompiledHand(values);
            totalBids = totalBids + (rank*compiledHand.bet);
            //System.out.println(rank + " // " + values + " // " + (rank*compiledHand.bet) + " // " + totalBids);
            System.out.println(rank + ". " + compiledHand.normalisedHand + " " + compiledHand.bet);
            rank++;
        }
        System.out.println("Total winnings: " + totalBids);
    }
}
